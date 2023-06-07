package com.wzl.service;

import com.wzl.qqcommon.Message;
import com.wzl.qqcommon.MessageType;

import java.io.*;

public class SendFile {
    public void SendFileOne(String sender,String src,String dest,String getter){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_TO_ONE);
        message.setSender(sender);
        message.setGetter(getter);
        message.setSrc(src);
        message.setDest(dest);
        FileInputStream fileInputStream = null;
        byte[] fileBytes = new byte[(int)new File(src).length()];
        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(fileBytes);
            message.setBytes(fileBytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManagerClientConnectSeverThread.
                    getClientConnectSeverThreadSock(message.getSender()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(message.getSender()+"向"+message.getGetter()+"发送文件从"+message.getSrc()+"到"+message.getDest());
    }
}
