package com.second;

import java.io.*;

public class Homework0015 {
    public static void main(String[] args) throws IOException {
        String srcPath = "e:\\密码.txt";
        int readline = 0;
        String A = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(srcPath),"gbk"));
        while ((A = bufferedReader.readLine()) != null){
            System.out.println(++readline+A);
        }
        if (bufferedReader != null){
            bufferedReader.close();
        }
    }
}
