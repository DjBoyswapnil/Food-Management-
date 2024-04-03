package com.School.mypro_hib;

import java.util.Scanner;
import java.util.List;
import java.util.Queue;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
	Scanner sc=new Scanner(System.in);
    public static void main( String[] args )
    {
    	
        System.out.println( "Welcome to food system" );
        
       /* Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        System.out.println(factory);*/
        App obj=new App();
          //obj.dataEntry();
         //obj.getFoodbyid();
        //obj.getAllData(); 
       //obj.Update();
      //obj.delete();
      obj.findby();
    }
        public void dataEntry()
        {
        
        Session session=HibernateUtil.getSession();
        Food f1=new Food();
        System.out.println("Enter the Food Name");
        f1.setF_name(sc.next());
        System.out.println("Enter the Food Price");
        f1.setF_price(sc.nextInt());
        System.out.println("Enter the Food Quantity");
        f1.setF_quantity(sc.nextInt());
        Transaction tx=session.beginTransaction();
        session.save(f1);
        System.out.println(f1);
        tx.commit();
        session.close();
        
    }
        public void getFoodbyid()
        {
        	Session session=HibernateUtil.getSession();
        	Transaction tx=session.beginTransaction();
        	System.out.println("enter id ");
        	int id=sc.nextInt();
        	Food f1=session.get(Food.class,id);
        	System.out.println("Food id: "+f1.getF_id());
        	System.out.println("Food Name: "+f1.getF_name());
        	System.out.println("Price: "+f1.getF_price());
        	System.out.println("Quantity: "+f1.getF_quantity());
        	tx.commit();
            session.close();
        }
        
      public void getAllData()
      {
    	  Session session=HibernateUtil.getSession();
      	  Transaction tx=session.beginTransaction();
      	  Query qur=session.createQuery("from my_order");
      	  
      	  List<Food> list_Food=qur.getResultList();
      	  for(Food f1:list_Food)
      	  {
      		System.out.println("Food id: "+f1.getF_id());
        	System.out.println("Food Name: "+f1.getF_name());
        	System.out.println("Price: "+f1.getF_price());
        	System.out.println("Quantity: "+f1.getF_quantity());  
      	  }
      	tx.commit();
        session.close();
      }
        public void Update()
        {
        	Session session=HibernateUtil.getSession();
        	Transaction tx=session.beginTransaction();
        	System.out.println("Enter the id");
        	int id=sc.nextInt();
        	Food f1=session.get(Food.class,id);
        	
        	System.out.println("Enter name");
        	f1.setF_name(sc.next());
        	
        	session.saveOrUpdate(f1);
        	tx.commit();
        	session.close();
        }
        public void delete()
        {
        	Session session=HibernateUtil.getSession();
        	Transaction tx=session.beginTransaction();
        	System.out.println("Enter the id");
        	int id=sc.nextInt();
        	Food f1=session.get(Food.class,id);
        	
        	session.delete(f1);
        	tx.commit();
        	session.close();
        }
        public void findby()
        {
        	Session session=HibernateUtil.getSession();
        	System.out.println("Enter name");
            String hql = "from my_order where f_name = :name";
            List<Food> food = session.createQuery(hql)
                    .setParameter("name", sc.next())
                    .getResultList();
            food.forEach(f1 -> System.out.println(f1.getF_id()+"\t"+f1.getF_name()+"\t"+f1.getF_price()+"\n"+f1.getF_quantity()));
            session.getTransaction().commit();
        }
}
