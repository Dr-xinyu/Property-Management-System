package com.xinyu.entity;

import java.util.ArrayList;
import java.util.List;

public class chargeMoney {
    private String chargeMoney;

    public chargeMoney() {
    }

    public String getChargeMoney() {
        return chargeMoney;
    }

    public void setChargeMoney(String chargeMoney) {
        this.chargeMoney = chargeMoney;
    }

    public static List<chargeMoney> getList(){
        List<chargeMoney> list=new ArrayList<>();
        com.xinyu.entity.chargeMoney chargeMoney1=new chargeMoney();
        com.xinyu.entity.chargeMoney chargeMoney2=new chargeMoney();

        com.xinyu.entity.chargeMoney chargeMoney3=new chargeMoney();

        com.xinyu.entity.chargeMoney chargeMoney4=new chargeMoney();
        list.add(chargeMoney1);
        list.add(chargeMoney2);
        list.add(chargeMoney3);
        list.add(chargeMoney4);
        return list;
    }
}
