package com.xinyu.operate;

import com.xinyu.Utils.utils;
import com.xinyu.entity.People;
import com.xinyu.entity.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.type.StringType;

import java.util.List;
import java.util.Map;

/*
判断这个员工是否存在
 */
public class searchPeople {

    /*
    判断这个员工是否存在
     */
    public  static boolean isExist(String worker_id){
        Session session=null;
        Transaction tx=null;
        try {
            session= utils.getSessionObject();
            tx=session.beginTransaction();

            Query query=session.createQuery("from com.xinyu.entity.People where worker_id=:id");
            query.setParameter("id",worker_id,StringType.INSTANCE);
            People people=(People)query.uniqueResult();
            tx.commit();
            if (people!=null){
                return true;
            }

        }catch (Exception e){
            tx.rollback();
        }
        return false;
    }
    //判断房屋是否存在。而且业主ID可以对应上
    public static boolean isExist(String ownerId,String roomId){
        Session session=null;
        Transaction tx=null;
        try {
            session= utils.getSessionObject();
            tx=session.beginTransaction();
            Query query=session.createQuery("from com.xinyu.entity.Room where room_id =:id");
            query.setParameter("id",roomId);

            Room room=(Room)query.uniqueResult();
            tx.commit();
            if (room!=null){
//                判断业主ID是否对应
                if(room.getOwner().getOwner_id().equals(ownerId)){
                    return true;
                }
                else
                    return false;
            }

        }catch (Exception e){
            tx.rollback();
        }
        return false;
    }
}
