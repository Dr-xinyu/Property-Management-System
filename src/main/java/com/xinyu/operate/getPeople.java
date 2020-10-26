package com.xinyu.operate;

import com.xinyu.Utils.utils;
import com.xinyu.entity.People;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class getPeople {
    public static People get_People(String worker_id) {
        Transaction tx=null;
        Session session=null;
        try {
            session= utils.getSessionObject();
            tx=session.beginTransaction();

            Query query=session.createQuery("from com.xinyu.entity.People where worker_id=:id");
            query.setParameter("id",worker_id);
            People people=(People) query.uniqueResult();
            tx.commit();
            if (people!=null){
                return people;
            }
        }catch (Exception e){
            tx.rollback();
        }
        return null;
    }
    public static List<People> get_People(){
        Transaction tx=null;
        Session session=null;
        try {
            session= utils.getSessionObject();
            tx=session.beginTransaction();

            Query query=session.createQuery("from com.xinyu.entity.People");
            List<People> people=query.getResultList();
            tx.commit();
            if (people!=null){
                return people;
            }
        }catch (Exception e){
            tx.rollback();
        }
        return null;
    }
}
