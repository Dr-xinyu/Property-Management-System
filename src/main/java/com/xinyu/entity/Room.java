package com.xinyu.entity;

import lombok.Data;
@Data
public class Room {
    private String room_id;
    private  Double room_area;
    private Owner owner;

    public Room() {
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public Double getRoom_area() {
        return room_area;
    }

    public void setRoom_area(Double room_area) {
        this.room_area = room_area;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
