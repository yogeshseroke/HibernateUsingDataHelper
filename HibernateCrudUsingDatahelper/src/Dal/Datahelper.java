package Dal;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import PojoExample.SchoolExample;

public class Datahelper {
static Configuration cfg;
static SessionFactory sf;
static Session session;

	public static void connection() {
		cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sf=cfg.buildSessionFactory();
		session=sf.openSession();
	}
	public static Query dql(String query) {
		Query q=session.createQuery(query);
		return q;
	}
	public static void dmlInsert(Object o) {
		Transaction tx=session.beginTransaction();
		session.save(o);
		tx.commit();
	}
	public static Object dqlFind(Class c,int rn) {
		Object o1=session.get(c,rn);
		return o1;
	}
	public static void dmlUpdate(Object o) {
		Transaction tx=session.beginTransaction();
		session.update(o);
		tx.commit();
	}
	public static void dmlDelete(Object o) {
		Transaction tx=session.beginTransaction();
		session.delete(o);
		tx.commit();
		
	}
	public static void closeconn() {
		session.close();
	}
}
