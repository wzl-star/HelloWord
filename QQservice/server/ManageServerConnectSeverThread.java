package com.wzl.server;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ManageServerConnectSeverThread {
    private static HashMap<String,ServerConnectSeverThread> hm = new HashMap<>();
    public static void addServerConnectSeverThread(String userId,ServerConnectSeverThread serverConnectSeverThread){
        hm.put(userId,serverConnectSeverThread);
    }
    public static ServerConnectSeverThread getServerConnectSeverThread(String userId){
        return hm.get(userId);
    }
    public static String getOnlineList(){
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineList ="";
        while (iterator.hasNext()) {
            onlineList +=  iterator.next()+ " ";
        }
        return onlineList;

    }
    public  static void removeServerConnectSeverThread(String userId){
        hm.remove(userId);
    }

    public static HashMap<String, ServerConnectSeverThread> getHm() {
        return hm;
    }
}
