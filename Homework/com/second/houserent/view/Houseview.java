package com.second.houserent.view;

import com.second.houserent.domain.House;
import com.second.houserent.service.HouseService;
import com.second.houserent.utils.Utility;

public class Houseview {
    private boolean loop = true ;
    private char key = ' ';
    HouseService houseService = new HouseService(2);
    public void display() {
        System.out.println("-------------房屋列表-------------");
        System.out.println("编号\t\t 房主\t\t 电话\t\t 地址\t\t 月租\t\t 状态(未出租/已出租)");
        House[] houses = houseService.list();
        for (int i = 0; i <houses.length ; i++) {
            if (houses[i]== null){
                break;
            }
            System.out.println(houses[i]);

        }
        System.out.println("-------------房屋列表显示完毕-------------");
    }
    public void find(){
        System.out.println("-------------查找房屋-------------");
        int findId = Utility.readInt();
        House findHouse = houseService.find2(findId);
        if (findHouse != null){
            System.out.println(findHouse);
        }else{
            System.out.println("不存在房屋编号");
        }
    }
    public void polish(){
        System.out.println("-------------修改房屋-------------");
        System.out.println("请选择待修改房屋编号(-1退出)");
        int polishId = Utility.readInt();
        if (polishId == -1){
            System.out.println("你放弃了删除");
            return;
        }
        House polishHouse = houseService.find2(polishId);
        if (polishHouse == null){
            System.out.println("不存在房屋编号");
        }else{
            System.out.print("姓名(" + polishHouse.getName() +" ):");
            String name = Utility.readString(8,"");
            if (!"".equals(name) ){
                polishHouse.setName(name);
            }
            System.out.print("电话(" + polishHouse.getPhone() +" ):");
            String phone = Utility.readString(20,"");
            if (!"".equals(phone) ){
                polishHouse.setPhone(phone);
            }
            System.out.print("地址(" + polishHouse.getAds() +" ):");
            String add = Utility.readString(8,"");
            if (!"".equals(add) ){
                polishHouse.setAds(add);
            }System.out.print("租金(" + polishHouse.getSalary() +" ):");
            String salary = Utility.readString(8,"");
            if (!"".equals(salary) ){
                polishHouse.setName(salary);
            }System.out.print("状态(" + polishHouse.getState() +" ):");
            String state = Utility.readString(8,"");
            if (!"".equals(state) ){
                polishHouse.setName(state);
            }
        }


    }
    public void add(){
        System.out.println("-------------添加房屋-------------");
        System.out.print("姓名：");
        String name = Utility.readString(4);
        System.out.print("电话:");
        String phone = Utility.readString(10);
        System.out.print("地址:");
        String add = Utility.readString(20);
        System.out.print("月租:");
        int salary = Utility.readInt();
        System.out.print("状态(未出租/已出租):");
        String state = Utility.readString(4);
        House houseAdd = new House(0,name,phone,add,salary,state);
       if (houseService.houseAdd_(houseAdd)){
           System.out.println("======添加成功=======");
       }
    }
    public void delHouse(){
        System.out.println("-------------删除房屋-------------");
        System.out.println("请选择待删除房屋编号(-1退出)");
        int delId = Utility.readInt();
        if (delId == -1){
            System.out.println("你放弃了删除");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y'){
            if (houseService.del(delId)){
                System.out.println("删除房屋信息成功");
            }else {
                System.out.println("不存在房屋编号");
            }

        }else {
            System.out.println("放弃删除房屋信息");
        }


    }
    public void exit(){
        char c = Utility.readConfirmSelection();
        if (c == 'Y'){
            loop = false;
        }
    }
    public void mainView(){
        do {
            System.out.println("\n-------------房屋出租系统-------------");
            System.out.println("\t\t\t1 新增房源");
            System.out.println("\t\t\t2 查找房源");
            System.out.println("\t\t\t3 删除房源");
            System.out.println("\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t5 房屋列表");
            System.out.println("\t\t\t6 退  出");
            System.out.println("请输入选择(1-6)");
            key = Utility.readChar();
            switch (key){
                case '1':
                    add();
                    break;
                case '2':
                    find();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    polish();
                    break;
                case '5':
                   display();
                    break;
                case '6':
                    exit();
                    break;
            }
        }while (loop);
    }
}
