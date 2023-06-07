package com.second;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings({"all"})
public class Homework0008 {
    public static void main(String[] args) {
        news news1 = new news("新冠确诊超千万，数百万印度教徒赴恒河\"圣浴\"引民众担忧");
        news news2 = new news("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生");
        List arrayList = new ArrayList();
        arrayList.add(news1);
        arrayList.add(news2);
        int size = arrayList.size();
        for (int i = size -1 ; i >= 0  ; i--) {
            news arrayList1 = (news) arrayList.get(i);
            System.out.println(processTitle(arrayList1.getTitle()));
        }
    }
    public static String processTitle(String title){
        if (title.length() >15){
            return title.substring(0,15) + "..";
        }
        return title;
    }
    }
class news{
    private String title;
    private String content;

    public news(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return  title;
    }
}
