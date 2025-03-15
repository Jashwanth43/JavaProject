package in.test.main;
import hibernate5march.*;
import java.io.*;
import in.test.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class selectTest {
	public static void main(String... args) throws IOException {

		Session session=null;
		session=HibernateUtil.getSession();
		JobSeeker seeker=null;
		FileOutputStream fos=null;
		PrintWriter out=null;
		try {
		if(session!=null) {
		
			seeker=session.load(JobSeeker.class, 1);
			if(seeker!=null) {
				fos=new FileOutputStream("store/photo1.png");
				fos.write(seeker.getPhoto());
				fos.flush();
				fos.close();
				out=new PrintWriter("store/resume1.pdf");
				out.write(seeker.getResume());
				out.flush();
				out.close();
			}
			
		}
		}catch(HibernateException e1) {
			e1.printStackTrace();
		}finally {
			
			HibernateUtil.closeSession(session); 
		}
	}
}
	

