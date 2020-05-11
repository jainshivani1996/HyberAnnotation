package com.niit.hyberannotations;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ManyToManyDemo {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session sess= factory.openSession();
		sess.beginTransaction();
		Item item1=new Item();
		item1.setDescription("Toothpaste");
		item1.setPrice(30);
		Item item2=new Item();
		item2.setDescription("Samsung");
		item2.setPrice(3000);
		Cart cart=new Cart();
		cart.setTotal(500);
		Set<Item>items=new HashSet<Item>();
		items.add(item1);
		items.add(item2);
		cart.setItems(items);
		sess.save(cart);
		System.out.println("Before committing transaction");
		sess.getTransaction().commit();
		sess.close();
		System.out.println("*********Cart Items**************");
		System.out.println("Cart ID="+cart.getId());
		System.out.println("Item1 ID="+item1.getId());
		System.out.println("Product="+item1.getDescription());
		System.out.println("Price="+item1.getPrice());

		System.out.println("Item2 ID="+item2.getId());
		System.out.println("Product="+item2.getDescription());
		System.out.println("Price="+item2.getPrice());System.out.println("*********Cart Items**************");
		System.out.println("Cart ID="+cart.getId());
		System.out.println("Item1 ID="+item1.getId());
		System.out.println("Product="+item1.getDescription());
		System.out.println("Price="+item1.getPrice());

		System.out.println("Item2 ID="+item2.getId());
		System.out.println("Product="+item2.getDescription());
		System.out.println("Price="+item2.getPrice());


		
	}
	
}
