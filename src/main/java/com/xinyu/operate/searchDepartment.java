package com.xinyu.operate;

import com.xinyu.Utils.utils;
import com.xinyu.entity.Department;
import com.xinyu.entity.People;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.type.StringType;

/*
数据库搜索所有的部门.
 */
public class searchDepartment {
    public static boolean isExist(String departmentId){
        Session session=null;
        Transaction tx=null;
        try {
            session= utils.getSessionObject();
            tx=session.beginTransaction();

            Query query=session.createQuery("from com.xinyu.entity.Department where department_id=:dId");
            query.setParameter("dId",departmentId);
            Department department=(Department) query.uniqueResult();
            tx.commit();
            if (department!=null){
                return true;
            }

        }catch (Exception e){
            tx.rollback();
        }
        return false;
    }

//    public static void main(String[] args) {
//        System.out.println(isExist("888"));
//    }
}
