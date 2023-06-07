package com.mhl.view;

import com.mhl.domain.Bill;
import com.mhl.domain.DiningTable;
import com.mhl.domain.Employee;
import com.mhl.domain.Menu;
import com.mhl.service.BillService;
import com.mhl.service.DiningTableService;
import com.mhl.service.EmployeeService;
import com.mhl.service.MenuService;
import com.mhl.utils.Utility;

import java.util.List;

public class MHLView {
    private boolean loop = true;
    private String key = "";
    private EmployeeService employeeService = new EmployeeService();
    private DiningTableService diningTableService = new DiningTableService();
    private MenuService menuService = new MenuService();
    private BillService billService = new BillService();

    public static void main(String[] args) {
        new MHLView().mainView();
    }
    public void tableList(){
        List<DiningTable> list = diningTableService.list();
        System.out.println("\n餐桌编号\t\t餐桌状态");
        for (DiningTable diningTable : list) {
            System.out.println(diningTable);
        }
        System.out.println("显示完毕");
    }
    public void orderDiningTable(){
        System.out.println("==========预定餐桌=========");
        System.out.println("请选择要预定餐桌编号(-1退出)");
        int orderId = Utility.readInt();
        if (orderId == -1){
            System.out.println("退出订餐系统");
            return;
        }
        char c = Utility.readConfirmSelection();
        if (c == 'Y'){
            DiningTable diningTable = diningTableService.checkId(orderId);
            if (diningTable == null){
                System.out.println("该餐桌不存在");
                return;
            }
            if (!(diningTable.getState().equals("空"))){
                System.out.println("该餐桌已预定或就餐中");
                return;
            }
            System.out.println("请输入你的姓名");
            String orderName = Utility.readString(10);
            System.out.println("请输入你的电话");
            String orderTel = Utility.readString(20);
            if (diningTableService.updateDiningTable(orderId,orderName,orderTel)){
                System.out.println("预定成功");
            }else{
                System.out.println("预定失败");
            }
        }else {
            System.out.println("退出订餐系统");
            return;
        }

    }
    public void menuInfo(){
        List<Menu> menus = menuService.menuList();
        System.out.println("菜品编号\t\t菜品名\t\t类别\t\t价格");
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }
    public void orderMenu(){
        System.out.println("=========点餐服务=========");
        System.out.println("请选择点餐的桌号(-1退出)");
        int diningTableId = Utility.readInt();
        if (diningTableId == -1){
            System.out.println("退出点餐服务");
            return;
        }
        DiningTable diningTable = diningTableService.checkId(diningTableId);
        if (diningTable == null){
            System.out.println("点餐桌号不存在");
            return;
        }
        System.out.println("请选择要菜品编号(-1退出)");
        int menuId = Utility.readInt();
        if (menuId== -1){
            System.out.println("退出点餐服务");
            return;
        }
        Menu menu = menuService.getMenuId(menuId);
        if (menu == null){
            System.out.println("菜品编号不存在");
            return;
        }
        System.out.println("请选择要菜品数量(-1退出)");
        int nums = Utility.readInt();
        if (nums == -1){
            System.out.println("退出点餐服务");
            return;
        }
        System.out.println("确认是否点这个菜(Y/N)");
        char c = Utility.readConfirmSelection();
        if (c == 'Y'){
           if (billService.billOrder(menuId,nums,diningTableId)){
               System.out.println("点餐成功");
           }else {
               System.out.println("点餐失败");
           }
        }else {
            System.out.println("退出点菜系统");
            return;
        }
    }
    public void billLists(){
        System.out.println("编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t状态");
        List<Bill> billList = billService.getBillList();
        for (Bill bill : billList) {
            System.out.println(bill);
        }
    }
    public void payBill(){
        System.out.println("========结账服务=========");
        System.out.println("请选择要结账的餐桌编号(-1表示退出)");
        int diningTableId = Utility.readInt();
        if (diningTableId == -1){
            System.out.println("退出点餐服务");
            return;
        }
        if (diningTableService.checkId(diningTableId) ==null){
            System.out.println("餐桌编号不存在");
        }
        if (!billService.checkBillOrder(diningTableId)){
            System.out.println("该餐桌未显示未结账");
        }
        System.out.println("结账的方式(现金/支付宝/微信)回车表示退出");
        String paySize = Utility.readString(20,"");
        if (paySize.equals("")){
            System.out.println("退出点餐服务");
            return;
        }
        System.out.println("确认是否付账(Y/N)");
        char c = Utility.readConfirmSelection();
        if (c == 'Y'){
           if(billService.payBillOrder(diningTableId,paySize)){
               System.out.println("付款成功");
           }

        }else {
            System.out.println("放弃付款");
            return;
        }


    }

    public void mainView() {
        while (loop) {
            System.out.println("========登录满汉楼========");
            System.out.println("\t\t 1 登录满汉楼");
            System.out.println("\t\t 2 退出满汉楼");
            System.out.println("请输入你的选择:");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.println("请输入员工号");
                    String empId = Utility.readString(10);
                    System.out.println("请输入密码");
                    String pwd = Utility.readString(20);
                    Employee employeeIdAndPwd = employeeService.getEmployeeIdAndPwd(empId, pwd);
                    if (employeeIdAndPwd != null) {
                        System.out.println("=========登录成功["+employeeIdAndPwd.getNAME()+"]==========\n");
                        while (loop) {
                            System.out.println("=========满汉楼二级菜单========");
                            System.out.println("1 显示餐桌状态");
                            System.out.println("2 预定餐桌");
                            System.out.println("3 显示所有菜品");
                            System.out.println("4 点餐服务");
                            System.out.println("5 显示餐桌状态");
                            System.out.println("6 结账");
                            System.out.println("9 退出满汉楼");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    tableList();
                                    break;
                                case "2":
                                    orderDiningTable();
                                    break;
                                case "3":
                                    menuInfo();
                                    break;
                                case "4":
                                    orderMenu();
                                    break;
                                case "5":
                                    billLists();
                                    break;
                                case "6":
                                    payBill();
                                    break;
                                case "9":
                                    loop = false;
                                    break;
                            }
                        }
                    } else {
                        System.out.println("========登录失败=======");
                    }
                case "2":
                    loop = false;
                    System.out.println("退出满汉楼系统");
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
            }
        }
    }
}