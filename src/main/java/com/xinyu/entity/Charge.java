package com.xinyu.entity;

import java.util.Date;

/*
流水单的类
 */
public class Charge {
    private Integer ID;
    private String worker_id;
    private String room_id;
    private String owner_id;
    private Date charge_date;
    private String wuye_number;
    private String water_number;
    private String elevator_number;
    private String electricity_number;
    private String money;


    public Charge() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public Date getCharge_date() {
        return charge_date;
    }

    public void setCharge_date(Date charge_date) {
        this.charge_date = charge_date;
    }

    public String getWuye_number() {
        return wuye_number;
    }

    public void setWuye_number(String wuye_number) {
        this.wuye_number = wuye_number;
    }

    public String getWater_number() {
        return water_number;
    }

    public void setWater_number(String water_number) {
        this.water_number = water_number;
    }

    public String getElevator_number() {
        return elevator_number;
    }

    public void setElevator_number(String elevator_number) {
        this.elevator_number = elevator_number;
    }

    public String getElectricity_number() {
        return electricity_number;
    }

    public void setElectricity_number(String electricity_number) {
        this.electricity_number = electricity_number;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(String worker_id) {
        this.worker_id = worker_id;
    }
}




