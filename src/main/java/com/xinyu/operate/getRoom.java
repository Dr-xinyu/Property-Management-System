package com.xinyu.operate;

import com.xinyu.Utils.utils;
import com.xinyu.entity.People;
import com.xinyu.entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class getRoom {
    public static Room getroom(String roomid){
        Transaction tx=null;
        Session session=null;
        try {
            session= utils.getSessionObject();
            tx=session.beginTransaction();

            Query query=session.createQuery("from com.xinyu.entity.Room where room_id=:id");
            query.setParameter("id",roomid);
            Room room=(Room) query.uniqueResult();
            tx.commit();
            if (room!=null){
                return room;
            }
        }catch (Exception e){
            tx.rollback();
        }
        return null;
    }
}
