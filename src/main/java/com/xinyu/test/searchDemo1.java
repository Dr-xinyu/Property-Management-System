package com.xinyu.test;
import com.xinyu.Utils.utils;
import com.xinyu.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

/*
1对多的导航查询
 */
public class searchDemo1 {
    public static void select(){
        SessionFactory sessionFactory=null;
        Session session=null;
        Transaction tx=null;
        try {
            sessionFactory= utils.getSessionFactory();
            session=sessionFactory.openSession();

            tx=session.beginTransaction();

//            第一个 通过set集合得到
//            Department department= session.get(Department.class,1);
////            得到department里面的set集合
//            Set<People> people=department.getPeople();
//
//            for(People people1:people){
//                System.out.println(people1.getWorker_name());
//            }
           String id="1";
            String hql="from com.xinyu.entity.People as p where p.worker_id = "+id;

            Query query=session.createQuery(hql);

            People people=(People) query.list().get(0);


            System.out.println(people.getWorker_name());

            tx.commit();



        }catch (Exception e){
            tx.rollback();
        }finally {
            session.close();
        }
    }

    public static void main(String[] args) {
        select();
    }
}
