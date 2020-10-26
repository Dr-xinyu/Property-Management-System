package com.xinyu.test;

import com.xinyu.Utils.utils;
import com.xinyu.entity.Department;
import com.xinyu.entity.Owner;
import com.xinyu.entity.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class test_delete {
    public static void main(String[] args) {
        SessionFactory sessionFactory=null;
        Session session=null;
        Transaction tx=null;
        try {
            sessionFactory= utils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            Owner owner=session.get(Owner.class,6);
            session.delete(owner);

            tx.commit();


        }catch (Exception e){
            tx.rollback();
        }
        finally {
            session.close();
        }
    }
}
