package in.test.main;
import hibernate5march.*;
import java.io.*;
import in.test.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class TestApp {
	public static void main(String... args) {

		Session session=null;
		session=HibernateUtil.getSession();
		Transaction transaction=null;
		 boolean result=false;
		byte [] imageContent=null;
		char [] resumeContent=null;
		try (FileInputStream fis=new FileInputStream("C:\\Users\\jashw\\Downloads\\1.png")){
			imageContent=new byte[(int) fis.available()];
			fis.read(imageContent);
			File f=new File("C:\\Users\\jashw\\Downloads\\03_12_2022_Jdbc_classNotes.pdf");
			try(FileReader fr=new FileReader(f)){
				resumeContent=new char[(int) f.length()]; 
				fr.read(resumeContent);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
		if(session!=null) 
			transaction=session.beginTransaction();
		 JobSeeker seeker=new JobSeeker();
			seeker.setActive(true);
			seeker.setPhoto(null);
			seeker.setPhoto(imageContent);
			seeker.setResume(resumeContent);
			Integer id=null;
		if(transaction!=null) {
			id=(Integer) session.save(seeker);
			System.out.println("The generated id value is: "+id);
			result=true;
		}
		}catch(HibernateException e1) {
			e1.printStackTrace();
		}finally {
			if(result) {
					transaction.commit();
			}else {
				transaction.rollback();
			}
			HibernateUtil.closeSession(session); 
		}
		
	}
}
