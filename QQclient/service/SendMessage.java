package com.wzl.service;

import com.wzl.qqcommon.Message;
import com.wzl.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class SendMessage {
    public void sendMessageToOne(String sender,String getter,String content){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setSender(sender);
        message.setGetter(getter);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManagerClientConnectSeverThread.
                    getClientConnectSeverThreadSock(message.getSender()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(message.getSender()+"对"+message.getGetter()+"说"+message.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
