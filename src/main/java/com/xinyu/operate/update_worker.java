package com.xinyu.operate;

import com.xinyu.Utils.utils;
import com.xinyu.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
修改员工信息
 */
public class update_worker {
    public static void update(People people){
            SessionFactory sessionFactory=null;
            Session session=null;
            Transaction tx=null;
            try {
                session= utils.getSessionObject();
                tx=session.beginTransaction();

                session.update(people);

                tx.commit();
            }
            catch (Exception e){
                tx.rollback();
            }
        }

//    public static void main(String[] args) {
//            People people=Get_people.get(2);
//            people.setAddress("西交");
//            update(people);
//    }
}
