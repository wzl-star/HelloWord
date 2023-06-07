package com.second.houserent.service;

import com.second.houserent.domain.House;

public class HouseService {
    private House[] Houses;
    private int numbs = 1;
    private int idCount = 1;

    public HouseService(int size) {
      Houses = new House[size];
      Houses[0] = new House(1,"小明","553344","云阳县",20000,"未出租");
    }
    public House[] list(){
        return Houses;
    }
    public boolean houseAdd_(House houseAdd){
        if (numbs == Houses.length){
            House[] Houses2 = new House[Houses.length+1];
            for (int i = 0; i < Houses.length ; i++) {
                Houses2[i] = Houses[i];
            }
            Houses2[Houses2.length-1] = houseAdd;
            Houses = Houses2;
            numbs++;
            houseAdd.setId(++idCount);
            return true;
        }
        Houses[numbs++] = houseAdd;
        houseAdd.setId(++idCount);
        return true;
    }
    public boolean del(int delId){
        int index = -1;
        for (int i = 0; i < Houses.length; i++) {
            if (delId == Houses[i].getId() ){
                index = i;
            }
        }
        if (index == -1){
            return false;
        }
        for (int i = index; i <numbs -1 ; i++) {
            Houses[i] = Houses[i + 1];
        }
        Houses[--numbs] = null;
        return true;

    }
    public House find2(int findId){
        for (int i = 0; i <numbs ; i++) {
            if (findId == Houses[i].getId()){
                return Houses[i];
            }
            }
        return null;
        }
    }

