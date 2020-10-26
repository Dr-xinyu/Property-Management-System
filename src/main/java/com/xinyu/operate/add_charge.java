package com.xinyu.operate;

import com.xinyu.Utils.utils;
import com.xinyu.entity.Charge;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
添加一个流水单
 */
public class add_charge {
    public static void add(Charge charge){
        Session session=null;
        Transaction tx=null;
        try {
            session= utils.getSessionObject();
            tx=session.beginTransaction();

            session.save(charge);
            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }
    }
}
