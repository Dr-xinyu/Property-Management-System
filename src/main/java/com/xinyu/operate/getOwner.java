package com.xinyu.operate;

import com.xinyu.Utils.utils;
import com.xinyu.entity.Owner;
import com.xinyu.entity.People;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class getOwner {
    public  static Owner get_owner(String ownerId){
        Transaction tx=null;
        Session session=null;
        try {
            session= utils.getSessionObject();
            tx=session.beginTransaction();

            Query query=session.createQuery("from com.xinyu.entity.Owner where owner_id =:id");
            query.setParameter("id",ownerId);
            Owner owner=(Owner) query.uniqueResult();
            tx.commit();
            if (owner!=null){
                return owner;
            }
        }catch (Exception e){
            tx.rollback();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(get_owner("O0001").getOwner_name());
    }
}
