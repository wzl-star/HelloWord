package com.second;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Homework0014 {
    public static void main(String[] args) throws IOException {
        String file1 = "e:\\mytemp";
        File file = new File(file1);
        if (!file.exists()){
            file.mkdirs();
        }else {
            System.out.println("该文件夹已经存在");
        }
        String file2 = file1 + "\\hello.txt";
        File file3 = new File(file2);
        if (!file3.exists()){
            file3.createNewFile();
        }else {
            System.out.println("该文件已经存在");
        }
        FileWriter fileWriter = new FileWriter(file2);
        fileWriter.write("hello,word");
        fileWriter.close();
    }
}
