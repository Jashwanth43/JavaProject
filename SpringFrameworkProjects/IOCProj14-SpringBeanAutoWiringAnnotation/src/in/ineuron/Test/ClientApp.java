package in.ineuron.Test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import in.ineuron.bean.Flipkart;

public class ClientApp {
	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");

		

		Flipkart flipkart = context.getBean("fpkt", Flipkart.class);
//		System.out.println(flipkart.shopping(new String[] { "fossil", "puma", "iphone" },
//				new float[] { 35000.5f, 56000.0f, 75000.35f }));
		
		System.out.println(flipkart.shopping(new String[] {"fossil", "puma", "iphone" }, new float[] {35000.5f, 56000.0f, 75000.35f }));
		
	}
}
