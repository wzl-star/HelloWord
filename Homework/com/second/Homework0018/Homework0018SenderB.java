package com.second.Homework0018;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Homework0018SenderB {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(7526);
        System.out.println("请输入问题");
        Scanner scanner = new Scanner(System.in);
        byte[] buf = scanner.next().getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.31.239"), 7525);
        socket.send(packet);
        byte[] bytes = new byte[1024];
        packet = new DatagramPacket(bytes, 0, bytes.length);
        socket.receive(packet);
        String s1 = new String(packet.getData(), 0, packet.getLength());
        System.out.println(s1);
        socket.close();
    }
}
