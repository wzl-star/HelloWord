package com.wzl.server;

import com.wzl.qqcommon.Message;
import com.wzl.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ServerConnectSeverThread extends Thread {
    private Socket socket;
    private String userId;

    public ServerConnectSeverThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("服务器和客户端"+userId+"保持通信，读取数据");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ON_LINE_FRIEND)) {
                    ObjectOutputStream oos = new ObjectOutputStream(ManageServerConnectSeverThread.getServerConnectSeverThread(message.getSender()).getSocket().getOutputStream());
                    System.out.println(message.getSender() + "要在线用户列表");
                    String onlineList = ManageServerConnectSeverThread.getOnlineList();
                    Message message1 = new Message();
                    message1.setContent(onlineList);
                    message1.setMesType(MessageType.MESSAGE_SET_ON_LINE_FRIEND);
                    message1.setSender(message.getGetter());
                    oos.writeObject(message1);
                    //验证用户信息
                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    System.out.println(message.getSender() + "退出系统");
                    ManageServerConnectSeverThread.removeServerConnectSeverThread(message.getSender());
                    socket.close();
                    //退出系统
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {

                    ServerConnectSeverThread serverConnectSeverThread = ManageServerConnectSeverThread.
                            getServerConnectSeverThread(message.getGetter());
                    if (serverConnectSeverThread != null) {
                        ObjectOutputStream oos = new ObjectOutputStream(serverConnectSeverThread.getSocket().getOutputStream());
                        oos.writeObject(message);
                    }
                    if (serverConnectSeverThread == null){
                        ConcurrentHashMap<String, ArrayList<Message>> db = QQserver.getDb();
                        db.get(message.getGetter()).add(message);
                        db.put(message.getGetter(),db.get(message.getGetter()));
                    }
                    //发送私聊消息
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES_TO_ALL)) {
                    HashMap<String, ServerConnectSeverThread> hm = ManageServerConnectSeverThread.getHm();
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()) {
                        String onLineUser = iterator.next();
                        if (!onLineUser.equals(message.getSender())) {
                            ObjectOutputStream oos = new ObjectOutputStream(ManageServerConnectSeverThread.
                                    getServerConnectSeverThread(onLineUser).socket.getOutputStream());
                            oos.writeObject(message);
                        }
                    }//群发消息
                }else if (message.getMesType().equals(MessageType.MESSAGE_FILE_TO_ONE)){
                    ObjectOutputStream oos = new ObjectOutputStream(ManageServerConnectSeverThread.
                            getServerConnectSeverThread(message.getGetter()).socket.getOutputStream());
                    oos.writeObject(message);
                    //发文件
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
