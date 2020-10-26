package com.xinyu.test;

import com.xinyu.Utils.utils;
import com.xinyu.entity.Department;

import com.xinyu.entity.People;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        SessionFactory sessionFactory=null;
        Session session=null;
        Transaction tx=null;
//        设置生日
//        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
//        String str="2000-05-24";

        try {
            sessionFactory=utils.getSessionFactory();
            session=sessionFactory.openSession();
             tx=session.beginTransaction();

            Department department=session.get(Department.class,"888");

            department.setDepartment_phone("88888888");
            department.setDepartment_name("金融部");

            People people=new People();
            people.setWorker_id("001");
            people.setWorker_name("小王");
            people.setWork_phone("12341234512");

//            员工权限为0
            people.setAccess(0);
            people.setAddress("西安");
            Date d1=new Date();

            people.setBirth_day(d1);


            people.setGender("男");
            people.setPassword("123456");
            if (people.getAccess().equals(1)){
                people.setPost("经理");
            }
            else {
                people.setPost("员工");
            }
            department.getPeople().add(people);
            people.setDepartment(department);

            session.update(department);

            tx.commit();


        }catch (Exception e){
            tx.rollback();
        }
        finally {
            session.close();
        }
    }
}
