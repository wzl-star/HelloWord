package com.wzl.qqview;

import com.wzl.service.SendFile;
import com.wzl.service.SendMessage;
import com.wzl.service.SendMessageAll;
import com.wzl.service.UserClientService;
import com.wzl.utils.Utility;

public class View {

   private UserClientService userClientService = new UserClientService();
   private SendMessage sendMessage = new SendMessage();
   private SendMessageAll sendMessageAll = new SendMessageAll();
   private SendFile sendFile = new SendFile();
    private boolean loop = true;

    public void viewMain() {
        while (loop) {
            System.out.println("============欢迎登录网络通信系统============");
            System.out.println("\t\t\t1登录系统");
            System.out.println("\t\t\t9退出系统");
            System.out.print("请输入你的选择：");
            String key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.print("请输入用户号：");
                    String userID = Utility.readString(5);
                    System.out.print("请输入密  码：");
                    String passWord = Utility.readString(50);
                    if (userClientService.checkUserID(userID,passWord)) {
                        System.out.println("============欢迎" + userID + "用户============");
                        while (loop) {
                            System.out.println("============网络通信系统二级菜单(用户" + userID + ")============");
                            System.out.println("\t\t\t1显示在线用户列表");
                            System.out.println("\t\t\t2群发消息");
                            System.out.println("\t\t\t3私聊消息");
                            System.out.println("\t\t\t4发送文件");
                            System.out.println("\t\t\t5退出系统");
                            System.out.print("请输入你的选择：");
                            String choice = Utility.readString(5);
                            switch (choice) {
                                case "1":
                                    userClientService.getOnlineFriend();
                                    break;
                                case "2":
                                    System.out.print("请输入你想对大家说的话");
                                    String content2 = Utility.readString(100);
                                    sendMessageAll.sendMessageToALL(content2,userID);
                                    break;
                                case "3":
                                    System.out.print("请输入想聊天的用户号(在线):");
                                    String senderId = Utility.readString(10);
                                    System.out.print("请输入你想说的话:");
                                    String content = Utility.readString(100);
                                    sendMessage.sendMessageToOne(userID,senderId,content);
                                    break;
                                case "4":
                                    System.out.print("请输入想发送文件的用户号(在线)");
                                    String sendFileId = Utility.readString(5);
                                    System.out.print("请输入文件的完整路径(形式e:\\xxx.jpg):");
                                    String src = Utility.readString(50);
                                    System.out.print("请输入文件到对方路径(形式e:\\xxx.jpg):");
                                    String dest = Utility.readString(50);
                                    sendFile.SendFileOne(userID,src,dest,sendFileId);
                                    break;
                                case "5":
                                    userClientService.exitSys();
                                    loop = false;
                                    break;
                            }
                        }
                    } else {
                        System.out.println("登录失败");
                    }
                    break;
                case "2":
                    System.out.println("退出系统");
                    loop = false;
                    break;
            }
        }

    }

}

