package com.wzl.server;

import com.wzl.qqcommon.Message;
import com.wzl.qqcommon.MessageType;
import com.wzl.utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;

public class SendNews implements Runnable{


    @Override
    public void run() {
        while (true) {
            System.out.println("请输入想输入的新闻");
            String news = Utility.readString(100);
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_NEWS_TO_ALL);
            message.setSender("服务器");
            if (news.equals("exit")){
                break;
            }
            message.setContent(news);
            HashMap<String, ServerConnectSeverThread> hm = ManageServerConnectSeverThread.getHm();
            Iterator<String> iterator = hm.keySet().iterator();
            while (iterator.hasNext()) {
                String onlineId = iterator.next();
                ServerConnectSeverThread serverConnectSeverThread = ManageServerConnectSeverThread.getServerConnectSeverThread(onlineId);
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectSeverThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            System.out.println(message.getSender() + "推送消息给所有人大家说" + message.getContent());
        }
    }
}
