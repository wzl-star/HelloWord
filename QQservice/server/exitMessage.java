package com.wzl.server;

import com.wzl.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class exitMessage implements Runnable {
    @Override
    public void run() {
        while (true) {
            Iterator<String> iterator = QQserver.getDb().keySet().iterator();//从集合中取出遍历
            HashMap<String, ServerConnectSeverThread> hm = ManageServerConnectSeverThread.getHm();//
            Iterator<String> iterator1 = hm.keySet().iterator();
            while (iterator.hasNext()) {
                String exitLineId = iterator.next();
                while (iterator1.hasNext()) {
                    String onlineId = iterator1.next();
                    if (exitLineId == onlineId) {
                        ArrayList<Message> messages = QQserver.getDb().get(exitLineId);
                        for (int i = 0; i < messages.size(); i++) {
                            Message message = messages.get(i);
                            try {
                                ObjectOutputStream oos = new ObjectOutputStream(ManageServerConnectSeverThread.
                                        getServerConnectSeverThread(message.getGetter()).getSocket().getOutputStream());
                                oos.writeObject(message);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            QQserver.getDb().get(exitLineId).remove(message);
                        }
                        QQserver.getDb().remove(exitLineId);
                    }
                }
            }
        }
    }
}

