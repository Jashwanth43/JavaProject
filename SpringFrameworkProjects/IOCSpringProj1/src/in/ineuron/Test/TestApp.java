package in.ineuron.Test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import in.ineuron.bean.WishMessgeGenerator;

public class TestApp {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		//using the FileSystemResource to locate the configuration file
		FileSystemResource resource = new FileSystemResource("./src/applicationContext.xml");

		// Creating an IOC container
		XmlBeanFactory factory = new XmlBeanFactory(resource);

		//Requesting IOC container to give the Object,searching will happen in cache and if it is not found then 
		Object gen = (WishMessgeGenerator)factory.getBean("wmg");
		//object will created by loading and performing setter injection.
		WishMessgeGenerator generator1= factory.getBean("wmg", WishMessgeGenerator.class);
		
		//Searching will happen in cache, it is found so get it from cache only.
		WishMessgeGenerator generator2= factory.getBean("wmg", WishMessgeGenerator.class);
		Class c= Class.forName("in.ineuron.bean.WishMessgeGenerator");

		System.out.println(c.newInstance().getClass());
		
		System.out.println("Generator1 class object reference :: "+generator1.hashCode());
		System.out.println("Generator2 class object reference :: "+generator2.hashCode());
		
		System.out.println();
//		
		//using the target object performing the operation and printing the result
		String result = generator1.generateWishMessage("jashwanth");
		System.out.println(result);
		
	}
}
