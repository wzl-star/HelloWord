package com.mhl.service;

import com.mhl.dao.BillDAO;
import com.mhl.dao.MenuDAO;
import com.mhl.domain.Bill;

import java.util.List;
import java.util.UUID;

public class BillService {
    private BillDAO billDAO = new BillDAO();
    private MenuService menuService = new MenuService();
    private DiningTableService diningTableService =new DiningTableService();
    public boolean billOrder(int menuId,int nums,int diningTableId){
        String billId = UUID.randomUUID().toString();
        int update = billDAO.update("insert into billl values(null,?,?,?,?,?,now(),'未结账')",
                billId, menuId, nums, menuService.getMenuId(menuId).getPrice() * nums,diningTableId);
        if (update < 0){
            return false;
        }
      return diningTableService.updateDiningTableState(diningTableId,"就餐中");
    }
    public List<Bill> getBillList(){
        List<Bill> list = billDAO.queryMulti("select * from billl", Bill.class);
        return list;
    }
    public boolean checkBillOrder(int diningTableId){
        Bill bill = billDAO.querySingle("select * from billl where state='未结账' and id=?", Bill.class,diningTableId);
        if (bill == null){
            //说明当前餐桌号已结帐
            return false;
        }
        return true;
    }
    public boolean payBillOrder(int diningTableId,String paySize){
        int update = billDAO.update("update billl set state=? where diningTableId=? and state='未结账'", paySize, diningTableId);
        if (update <= 0){
            return false;
        }
        if (!diningTableService.cleanDiningTable(diningTableId,"空")){
            return false;
        }
        return true;
    }
}
