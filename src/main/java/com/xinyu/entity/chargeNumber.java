package com.xinyu.entity;

import java.util.ArrayList;
import java.util.List;

public class chargeNumber {

    private String number;
    public chargeNumber() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public  static List<chargeNumber> getList(){
        List<chargeNumber> list=new ArrayList<>();
        chargeNumber number1=new chargeNumber();
        chargeNumber number2=new chargeNumber();
        chargeNumber number3=new chargeNumber();
        chargeNumber number4=new chargeNumber();
        list.add(number1);
        list.add(number2);
        list.add(number3);
        list.add(number4);
        return list;
    }
}
