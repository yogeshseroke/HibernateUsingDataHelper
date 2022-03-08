package PojoExample;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Dal.Datahelper;

public class CrudExample {
	
	
	static void selectRecord()
	{
		Datahelper.connection();
		Query q = Datahelper.dql("from SchoolExample s");
		List lst = q.list();
		Iterator it = lst.iterator();
		while(it.hasNext())
		{
			SchoolExample s =(SchoolExample)it.next();
			System.out.println(s.getRn() + " "+s.getName());
		}
		Datahelper.closeconn();
		
	}
	static void insertRecord(int rn,String name)
	{
		
		Datahelper.connection();
		SchoolExample s = new SchoolExample();
		s.setRn(rn);
		s.setName(name);
		Datahelper.dmlInsert(s);
		Datahelper.closeconn();
		
	}
	static void deleteRecord(int rn)
	{
		Datahelper.connection();
		SchoolExample s = (SchoolExample)Datahelper.dqlFind(SchoolExample.class,rn);
		
		Datahelper.dmlDelete(s);
		Datahelper.closeconn();
	}
	static void updateRecord(int rn,String name)
	{
		Datahelper.connection();
		SchoolExample s = (SchoolExample)Datahelper.dqlFind(SchoolExample.class,rn);
		Datahelper.dmlUpdate(s); 
		Datahelper.closeconn();
	}
	
	public static void main(String[] args) {
	
		insertRecord(113,"salman");
		//updateRecord(110,"tony kakkar");
		//deleteRecord(111);
	    selectRecord();
	    
	    
		

	}

}
