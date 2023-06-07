package com.second;

import java.util.*;

@SuppressWarnings({"all"})
public class Homework0009 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("jack",650);
        hashMap.put("tom",1200);
        hashMap.put("smith",2900);
        hashMap.put("jack",2600);
        Set keyset = hashMap.keySet();
        for (Object key :keyset) {
            hashMap.put(key,(Integer)hashMap.get(key) + 100);
        }
        System.out.println(hashMap);
        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry next =(Map.Entry)iterator.next();
            System.out.println(next.getKey() + "-" + next.getValue() );
        }
        Collection values = hashMap.values();
        for (Object value :values) {
            System.out.println(value);

        }


    }

    }

