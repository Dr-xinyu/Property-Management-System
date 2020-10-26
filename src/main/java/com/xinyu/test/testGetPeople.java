package com.xinyu.test;

import com.xinyu.Utils.utils;
import com.xinyu.entity.Department;
import com.xinyu.entity.People;
import com.xinyu.operate.getPeople;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class testGetPeople {
    public static void main(String[] args) {
        Session session=null;
        Transaction tx=null;
        try {
            session= utils.getSessionObject();
            tx=session.beginTransaction();

            People people=session.get(People.class,"003");
            Department department=session.get(Department.class,"666");

            department.getPeople().add(people);
            people.setDepartment(department);

            session.update(department);

            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }
    }
}
