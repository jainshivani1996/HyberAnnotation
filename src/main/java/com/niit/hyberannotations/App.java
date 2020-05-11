package com.niit.hyberannotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory sf=cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
    	Session ses=sf.openSession();
    	ses.beginTransaction();
    	Employee e1=new Employee();
    	e1.setId(105);
    	e1.setFirstName("Jill");
    	e1.setLastName("Khan");
    	ses.save(e1);
    	ses.getTransaction().commit();
    	System.out.println("Successfully saved");
    }
}
