package com.niit.hyberannotations;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class OnetoOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory(
				new StandardServiceRegistryBuilder().configure().build());
		Session sess= factory.openSession();
		sess.beginTransaction();
		Customer c1=new Customer();
		c1.setName("Shivani2");
		c1.setEmail("jain1@gmail.com");
		Address add1=new Address();
		
		add1.setAddressLine1("sector 221");
		add1.setCity("Noida1");
		add1.setCountry("India1");
		add1.setState("UP");
		add1.setPincode(201301);
		c1.setAddress(add1);
		add1.setCustomer(c1);
		sess.persist(c1);
		sess.getTransaction().commit();
		System.out.println("Table Created & Record successfully Inserted"+"<br>");

		System.out.println("*********** Display Data ************");
		TypedQuery<Customer> query=sess.createQuery("from Customer",Customer.class);
		List<Customer> list=query.getResultList();

		Iterator<Customer> itr=list.iterator();
		while(itr.hasNext()){
		Customer cust=itr.next();
		System.out.println(cust.getCustomerId()+" "+cust.getName()+" "+cust.getEmail());
		Address address=cust.getAddress();
		System.out.println(address.getAddressLine1()+" "+address.getCity()+" "+
		address.getState()+" "+address.getCountry()+" "+address.getPincode());
		}
		sess.close();
		System.out.println("success");
		
	}

}
