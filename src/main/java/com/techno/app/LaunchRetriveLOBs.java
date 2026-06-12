package com.techno.app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import com.techno.model.StudentTable;

import jakarta.persistence.EntityExistsException;

public class LaunchRetriveLOBs {
	public static void main(String[] args) {
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction transaction=null;
		FileOutputStream fos=null;
		FileWriter fw=null;
		boolean flag=false;
		try{
			sessionFactory=new Configuration().addAnnotatedClass(StudentTable.class).buildSessionFactory();
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			StudentTable st=session.find(StudentTable.class, 1);
			try {
			fos=new FileOutputStream("Naresh.JPG");
			fos.write(st.getImage());

			fw=new FileWriter("personal_info.txt");
			fw.write(st.getTextdoc());
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println(st);
			
			System.out.println("Transaction commited succesfully...........");
			flag=true;
		}catch (EntityExistsException e) {
			System.out.println("Entity already exists: "+e.getMessage());
		}catch (ConstraintViolationException e) {
			System.out.println("Constraint violation: "+e.getMessage());
		}catch (HibernateException e) {
			System.out.println("Hibernate Exception: "+e.getMessage());
		}catch (Exception e) {
			System.out.println("Unexpected exception: "+e.getMessage());
		}finally {
			if(!flag) {
				if(transaction!=null) {
					transaction.rollback();
					System.out.println("Transaction rolled back successfully");
				}
			}
			if(session!=null) {
				session.close();
			}
			if(sessionFactory!=null) {
				sessionFactory.close();
			}
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fw!=null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}


	}
}
