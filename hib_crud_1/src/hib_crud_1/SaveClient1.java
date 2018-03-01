package hib_crud_1;

import org.hibernate.*;
import org.hibernate.cfg.*;
public class SaveClient1 {
public static void main(String rags[]) throws Exception {
	Configuration c=new Configuration();
	c.configure("./hibernate.cfg.xml");
	SessionFactory sf=c.buildSessionFactory();
	Session s=sf.openSession();
	Transaction t=s.beginTransaction();
	try {
		Course c1=new Course(1, "Core Java", "Lang Intro, OOPs", 60);
		Course c2=new Course(2, "Adv Java", "J2EE,JSP,Servlets", 60);
		Course c3=new Course(3, "Hibernate", "IS-A,HAS-A", 60);
		Course c4=new Course(4, "Spring", "IoC,AOP",60);
		s.save(c1); s.save(c2); s.save(c3); s.save(c4);
		s.flush();
		t.commit();
		System.out.println("Course inserted");
	}
	catch(Exception e) {
		t.rollback();
		System.out.println("TX failed");
	}
}
}
