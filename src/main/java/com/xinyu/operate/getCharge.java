package com.xinyu.operate;

import com.xinyu.Utils.utils;
import com.xinyu.entity.Charge;
import com.xinyu.entity.People;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
从数据库里得到订单
 */
public class getCharge {
    public static Charge get_charge(String roomId, Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String date1=sdf.format(date);
        Transaction tx=null;
        Session session=null;
        try {
            session= utils.getSessionObject();
            tx=session.beginTransaction();

            Query query=session.createQuery("from com.xinyu.entity.Charge where room_id=:id");
            query.setParameter("id",roomId);
            List<Charge> list=query.list();
            tx.commit();
            for (Charge c:list){
                String s=sdf.format(c.getCharge_date());
                if (date1.equals(s)){
                    return c;
                }
            }

        }catch (Exception e){
            tx.rollback();
        }
        return null;
    }
}
