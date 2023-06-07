package com.mhl.service;

import com.mhl.dao.DiningTableDAO;
import com.mhl.domain.DiningTable;

import java.util.List;

public class DiningTableService {
    private DiningTableDAO diningTableDAO = new DiningTableDAO();

    public List<DiningTable> list() {
        List<DiningTable> diningTablesList = diningTableDAO.queryMulti("select id,state from diningtable", DiningTable.class);
        return diningTablesList;
    }

    public DiningTable checkId(int id) {
        DiningTable diningTable =
                diningTableDAO.querySingle("select * from diningtable where id=?", DiningTable.class, id);
        return diningTable;
    }

    public boolean updateDiningTable(int id, String orderName, String orderTel) {
        int update = diningTableDAO.update("update diningtable set state='已经预定',orderName=?,orderTel=? where id=?", orderName, orderTel, id);
        return update > 0;
    }

    public boolean updateDiningTableState(int id,String state) {
        int update = diningTableDAO.update("update diningtable set state=? where id=?",state,id);
        return update > 0;
    }
    public boolean cleanDiningTable(int id,String state) {
        int update = diningTableDAO.update("update diningtable set state=?,orderName='',orderTel='' where id=?",state,id);
        return update > 0;
    }
}
