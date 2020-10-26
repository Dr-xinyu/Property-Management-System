package com.xinyu.operate;

import com.xinyu.Utils.utils;
import com.xinyu.entity.Department;
import com.xinyu.entity.People;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/*
添加员工。为这个员工指定一个部门
传入的参数为添加的人和部门。
如果部门编号不存在，则报错
 */
public class add_worker {
    public static void add(People people,String department_id){
        SessionFactory sessionFactory=null;
        Session session =null;
        Transaction tx=null;
        try {
            session=utils.getSessionObject();
            tx=session.beginTransaction();

            Department department=session.get(Department.class,department_id);

            department.getPeople().add(people);
            people.setDepartment(department);

            session.update(department);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }
    }
}
