package com.wzl.server;

import com.wzl.qqcommon.Message;
import com.wzl.qqcommon.MessageType;
import com.wzl.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class QQserver {
    private ServerSocket ss = null;
    private Socket socket = null;
    private static HashMap<String, User> userCheck = new HashMap<>();
    private static ConcurrentHashMap<String, ArrayList<Message>> db = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<String, ArrayList<Message>> getDb() {
        return db;
    }

    public static void setDb(ConcurrentHashMap<String, ArrayList<Message>> db) {
        QQserver.db = db;
    }

    static {
        userCheck.put("100", new User("100", "123456"));
        userCheck.put("200", new User("200", "123456"));
        userCheck.put("300", new User("300", "123456"));
        userCheck.put("紫霞仙子", new User("紫霞仙子", "123456"));
        userCheck.put("至尊宝", new User("自尊宝", "123456"));
        userCheck.put("牛魔王", new User("牛魔王", "123456"));

    }

    public boolean check(String userId, String psw) {
        User user = userCheck.get(userId);
        if (user == null) {
            return false;
        }
        if (!user.getPsw().equals(psw)) {
            return false;
        }
        return true;
    }


    public QQserver() {
        try {
            ss = new ServerSocket(9999);
            new Thread(new SendNews()).start();
            new Thread(new exitMessage()).start();
            System.out.println("服务端在9999端口连接");
            while (true) {
                socket = ss.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User u = (User) ois.readObject();
                Message message = new Message();
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                if (check(u.getUserId(), u.getPsw())) {
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);
                    ServerConnectSeverThread serverConnectSeverThread = new
                            ServerConnectSeverThread(socket, u.getUserId());
                    serverConnectSeverThread.start();
                    ManageServerConnectSeverThread.addServerConnectSeverThread
                            (u.getUserId(), serverConnectSeverThread);
                } else {
                    System.out.println("登录失败");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
