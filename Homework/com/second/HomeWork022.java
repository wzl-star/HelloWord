package com.second;

public class HomeWork022 {
    public static void main(String[] args) {
        String content = "0.3546";
        String regStr = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";
        if (content.matches(regStr)){
            System.out.println("匹配成功");
        }else {
            System.out.println("匹配失败");
        }
    }
}
