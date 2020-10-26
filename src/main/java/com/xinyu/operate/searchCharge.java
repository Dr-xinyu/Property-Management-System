package com.xinyu.operate;

import com.xinyu.Utils.utils;
import com.xinyu.entity.Charge;
import com.xinyu.entity.People;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
查询charge表单
 */
public class searchCharge {
    public static boolean isExist(String roomId, Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String date1=sdf.format(date);
        Transaction tx=null;
        Session session=null;
        try {
            session= utils.getSessionObject();
            tx=session.beginTransaction();

            Query query=session.createQuery("from com.xinyu.entity.Charge where room_id=:id");
            query.setParameter("id",roomId);
            List<Charge>charge=query.list();
            tx.commit();
            for (Charge c:charge){
               String s=sdf.format(c.getCharge_date());
               if (date1.equals(s)){
                   return true;
               }
            }
            return false;

        }catch (Exception e){
            tx.rollback();
        }
        return false;
    }

//    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//        String s1="2020-10";
//        Date date=sdf.parse(s1);
//        System.out.println(isExist("A0101",date));
//    }
}
