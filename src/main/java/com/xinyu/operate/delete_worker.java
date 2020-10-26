package com.xinyu.operate;

import com.xinyu.Utils.utils;
import com.xinyu.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/*
删除员工的操作

 */
public class delete_worker {
    public static void delete(String worker_id){
        SessionFactory sessionFactory=null;
        Session session=null;
        Transaction tx=null;
        try {
            session= utils.getSessionObject();
            tx=session.beginTransaction();

            People people=session.get(People.class,worker_id);
            session.delete(people);

            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }
    }
}
