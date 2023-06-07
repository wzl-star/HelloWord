package com.wzl.qqcommon;

public interface MessageType {
    String MESSAGE_LOGIN_SUCCEED = "1"; //表示登录成功;
    String MESSAGE_LOGIN_FAIL = "2";// 表示登录失败;
    String MESSAGE_COMM_MES = "3";// 表示普通消息；
    String MESSAGE_GET_ON_LINE_FRIEND = "4";//表示获取在线列表;
    String MESSAGE_SET_ON_LINE_FRIEND = "5";//表示返回在线列表;
    String MESSAGE_CLIENT_EXIT = "6";//表示退出系统;
    String MESSAGE_COMM_MES_TO_ALL= "7";//表示群发消息
    String MESSAGE_FILE_TO_ONE= "8";//表示发文件
    String MESSAGE_NEWS_TO_ALL = "9";//发送新闻
}
