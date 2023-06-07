package com.wzl.service;

import com.wzl.qqcommon.Message;
import com.wzl.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class SendMessageAll {
    public void sendMessageToALL(String content ,String sender){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES_TO_ALL);
        message.setContent(content);
        message.setSender(sender);
        message.setSendTime(new Date().toString());
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManagerClientConnectSeverThread.
                    getClientConnectSeverThreadSock(message.getSender()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(message.getSender()+"对大家说"+message.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
