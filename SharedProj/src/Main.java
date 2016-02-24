

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.td.libpackage.Book;
/*
public class Main 
{
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		Book u=new Book();
/*		u.setUserid(1);
		u.setUsername("abc");
		s.persist(u);
		
		t.commit();
		System.out.println("saved");
		s.close();
	}

}
*/