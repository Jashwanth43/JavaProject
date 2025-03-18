package in.ineuron.Test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import in.ineuron.bean.Student;

public class TestApp {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ClassNotFoundException {

	DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
	XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
	reader.loadBeanDefinitions("/in/ineuron/cfg/applicationContext.xml");
	Student student=factory.getBean("stu",Student.class);
	System.out.println(student);
	Student student1=factory.getBean("stu1",Student.class);
	System.out.println(student1);
	

	}
}
