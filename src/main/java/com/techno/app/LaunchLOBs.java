package com.techno.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
//import java.util.HashSet;
//import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import org.hibernate.engine.transaction.jta.platform.internal.GlassFishJtaPlatform;
import org.hibernate.exception.ConstraintViolationException;

//import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
import com.techno.model.StudentTable;

import jakarta.persistence.EntityExistsException;

public class LaunchLOBs {
	public static void main(String[] args) {
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction transaction=null;
		FileInputStream fis=null;
		File fsFile=null;
		FileReader fReader=null;
		char[] txt=null;
		byte[] image=null;
		boolean flag=false;
		try{
			sessionFactory=new Configuration().addAnnotatedClass(StudentTable.class).buildSessionFactory();
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			fis=new FileInputStream("C:\\Users\\Naresh\\Desktop\\impotant docs\\photo.jpg");
			image=new byte[fis.available()];
			fis.read(image);
			
			fsFile=new File("C:\\Users\\Naresh\\Desktop\\impotant docs\\naresh.txt");
			fReader=new FileReader(fsFile);
			txt=new char[(int)fsFile.length()];
			fReader.read(txt);
			
			
			StudentTable st=new StudentTable();
			st.setName("Naresh");
			st.setImage(image);
			st.setTextdoc(txt);
			session.persist(st);
			transaction.commit();
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
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fReader!=null) {
				try {
					fReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}


	}
}
