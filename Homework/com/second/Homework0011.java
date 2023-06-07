package com.second;

import java.util.*;

public class Homework0011 {
}
class User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class DAO<T>{
    private Map<String,T> map = new HashMap<>();
    public void save(String id ,T entity){
        map.put(id,entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id , T entity){
        map.put(id , entity);
    }

    public List<T> List() {
        List<T> es = new ArrayList<>();
        Set<String> strings = map.keySet();
        for (String key :strings) {
            es.add(map.get(key));
        }
        return es;

    }

}
