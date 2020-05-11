package com.niit.hyberannotations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class OneToMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory(
		new StandardServiceRegistryBuilder().configure().build());
		Session sess= factory.openSession();
		sess.beginTransaction();
		Answer ans1=new Answer();
		ans1.setAnswerName("HTML is used to create Static Web Page");
		ans1.setPostedBy("Raj gs");

		Answer ans2=new Answer();
		ans2.setAnswerName("HTML is used for Web Designing");
		ans2.setPostedBy("John");
		Answer ans3=new Answer();
		ans3.setAnswerName("Java SCript is a Scripting language");
		ans3.setPostedBy("Ram Kumar");

		Answer ans4=new Answer();
		ans4.setAnswerName("JS is Client side Scripting language");
		ans4.setPostedBy("Arun");

		Answer ans5=new Answer();
		ans5.setAnswerName("JS is client/server Scripting language");
		ans5.setPostedBy("Mike");
		ArrayList<Answer> list1=new ArrayList<Answer>();
		list1.add(ans1);
		list1.add(ans2);

		ArrayList<Answer> list2=new ArrayList<Answer>();
		list2.add(ans3);
		list2.add(ans4);
		list2.add(ans5);

		Question question1=new Question();
		question1.setQname("What is HTML?");
		question1.setAnswer(list1);

		Question question2=new Question();
		question2.setQname("What is Java Script?");
		question2.setAnswer(list2);

		sess.persist(question1);
		sess.persist(question2);

		sess.getTransaction().commit();


		System.out.println("Table Created & Record successfully Inserted"+"<br>");

		System.out.println("<br>"+"*********** Display Data ************"+"<br>");
		TypedQuery<Question> query=sess.createQuery("from Question",Question.class);
		List<Question> list= query.getResultList();

		Iterator<Question> itr=list.iterator();
		while(itr.hasNext()){
		Question q=itr.next();
		System.out.println("<br>"+"Question Name: "+q.getQname());

		//printing answers
		List<Answer> list3=q.getAnswer();
		Iterator<Answer> itr2=list3.iterator();
		while(itr2.hasNext())
		{
		Answer a=itr2.next();
		System.out.println("<br>"+a.getAnswerName()+":"+a.getPostedBy());
		}
		System.out.println("<br>");
		}
		sess.close();
		System.out.println("success");



	}

}
