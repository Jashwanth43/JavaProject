package in.ineuron.Test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import in.ineuron.bean.Student;

public class TestApp {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ClassNotFoundException {

		// using the FileSystemResource to locate the configuration file
		FileSystemResource resource = new FileSystemResource("./src/applicationContext.xml");

		// Creating an IOC container
 		XmlBeanFactory factory = new XmlBeanFactory(resource);
 		
 		
 		Student student=(Student)factory.getBean("stu",in.ineuron.bean.Student.class);
 		System.out.println(student);
 		
//		WishMessgeGenerator generator1 = factory.getBean("wmg", WishMessgeGenerator.class);
//
//		System.out.println("Generator1 class object reference :: " + generator1.hashCode());
//
//		System.out.println();
//
//		String result = generator1.generateWishMessage("jashwanth");
//		System.out.println(result);

	}
}
