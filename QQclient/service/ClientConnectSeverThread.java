package com.wzl.service;

import com.wzl.qqcommon.Message;
import com.wzl.qqcommon.MessageType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConnectSeverThread extends Thread{
    private Socket socket;
    public ClientConnectSeverThread(Socket socket){
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("客户端线程，等待从读取从服务器发来的消息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                if (message.getMesType().equals(MessageType.MESSAGE_SET_ON_LINE_FRIEND)){
                    String[] s = message.getContent().split(" ");
                    System.out.println("当前在线用户列表");
                    for (int i = 0; i <s.length ; i++) {
                        System.out.println("用户"+s[i]);
                    }
                }else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                    System.out.println("\n"+message.getSender()+"对"+message.getGetter()+"说"+message.getContent());
                }else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES_TO_ALL)){
                    System.out.println(message.getSender()+"对大家说"+message.getContent());
                }else if (message.getMesType().equals(MessageType.MESSAGE_FILE_TO_ONE)){
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(message.getDest()));
                    fileOutputStream.write(message.getBytes());
                    fileOutputStream.close();
                    System.out.println(message.getSender()+"给"+message.getGetter()+"发送文件:"+message.getSrc()+"我的电脑目录"+message.getDest());
                    System.out.println("文件保持成功");
                }else if (message.getMesType().equals(MessageType.MESSAGE_NEWS_TO_ALL)){
                    System.out.println(message.getSender()+"对大家说"+message.getContent());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
