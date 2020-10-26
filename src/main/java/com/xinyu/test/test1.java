package com.xinyu.test;

import com.xinyu.Utils.utils;
import com.xinyu.entity.Owner;
import com.xinyu.entity.Room;
import com.xinyu.operate.searchPeople;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class test1 {
    public static void main(String[] args) {
        Session session=null;
        Transaction tx=null;
        try {
            session= utils.getSessionObject();
            tx=session.beginTransaction();

            Owner owner=new Owner();
            owner.setOwner_id("O0002");
            owner.setPhone_number("14321432432");
            owner.setWork_unit("西交");
            owner.setOwner_name("小楠");

            Room room=new Room();
            room.setRoom_id("A1102");
            room.setRoom_area(120.0);


//            在业主里表示房屋 房屋里表示业主
//            1、业主中表示房屋。把房屋的对象放入set集合里
            owner.getRooms().add(room);
            room.setOwner(owner);


//            保存到数据库
            session.save(owner);
            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }
    }


}
