package com.wzl.service;

import java.net.Socket;
import java.util.HashMap;

public class ManagerClientConnectSeverThread {
    private static HashMap<String,ClientConnectSeverThread> hm = new HashMap<>();
    //    通过一个集合管理socket
    public static void addClientConnectSeverThread(String userID,ClientConnectSeverThread clientConnectSeverThread){
        hm.put(userID, clientConnectSeverThread);
    }
    //    方法用于获得相应的Socket
    public static ClientConnectSeverThread getClientConnectSeverThreadSock(String userID){
     return hm.get(userID);
    }
}
