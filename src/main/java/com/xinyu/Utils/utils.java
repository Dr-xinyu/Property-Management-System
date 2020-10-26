package com.xinyu.Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class utils {
    private static Configuration cfg=null;
    private static SessionFactory sessionFactory=null;
    static {
        cfg=new Configuration();
        cfg.configure();
        sessionFactory=cfg.buildSessionFactory();
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public static Session getSessionObject(){
        return sessionFactory.getCurrentSession();
    }

}
