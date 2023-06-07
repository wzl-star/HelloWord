package com.second.Homework0018;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Homework0018ReceiverA {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(7525);
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        String s = new String(packet.getData(),0, packet.getLength());
        String answer = "";
        if (s.equals("四大名著是哪些")){
            answer = "四大名著是《红楼梦》、《三国演义》、《西游记》《水浒传》";
        }else {
            answer = "what?";
        }
        System.out.println(answer);
        buf = answer.getBytes();
        packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.31.239"), 7526);
        socket.send(packet);
        socket.close();
    }
}
