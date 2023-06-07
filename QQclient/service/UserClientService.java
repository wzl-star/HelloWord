package com.wzl.service;

import com.wzl.qqcommon.Message;
import com.wzl.qqcommon.MessageType;
import com.wzl.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class UserClientService {
    private User u = new User();
    private Socket socket;

    public boolean checkUserID(String userID, String psw) {
        u.setUserId(userID);
        u.setPsw(psw);
        boolean b = false;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);//向服务器端发送相关验证信息;
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message message = (Message) ois.readObject();
            if (message.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
                ClientConnectSeverThread ccst = new ClientConnectSeverThread(socket);
                ccst.start();
                ManagerClientConnectSeverThread.addClientConnectSeverThread(userID, ccst);
                b = true;
            } else {
                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public void getOnlineFriend() {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ON_LINE_FRIEND);
        message.setSender(u.getUserId());
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManagerClientConnectSeverThread.
                    getClientConnectSeverThreadSock(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void exitSys(){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManagerClientConnectSeverThread.
                    getClientConnectSeverThreadSock(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println("退出系统");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
