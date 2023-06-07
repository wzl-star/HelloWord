package com.second.Homework0017;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework0017Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5369);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = "";
        s = br.readLine();
        System.out.println(s);
        String answer = "";
        if (s.equals("name")){
            answer = "我是nova,nova是你自己的名字";
        }else if (s.equals("hobby")){
            answer = "编写程序";
        }else {
            answer = "你说啥呢";
        }
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(answer);
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
        socket.close();
        serverSocket.close();
    }
}
