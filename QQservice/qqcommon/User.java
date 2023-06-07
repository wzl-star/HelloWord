package com.wzl.qqcommon;

import java.io.Serializable;

public class User implements Serializable {
    private String userId;
    private String psw;

    public User(String userId, String psw) {
        this.userId = userId;
        this.psw = psw;
    }

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}
