package in.ineuron.Test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.sun.corba.se.pept.transport.ContactInfo;

import in.ineuron.bean.College;
import in.ineuron.bean.ContactsInfo;
import in.ineuron.bean.MarksInfo;
import in.ineuron.bean.UniversityInfo;

public class TestApp {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ClassNotFoundException {

	DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
	XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
	reader.loadBeanDefinitions("/in/ineuron/cfg/applicationContext.xml");
//	MarksInfo marksInfo=factory.getBean("marksInfo",MarksInfo.class);
//	System.out.println(marksInfo);
//	College college=factory.getBean("College",College.class);
//	System.out.println(college);
//	
//	System.out.println(college);
//	ContactsInfo contactsInfo=factory.getBean("ContactInfo",ContactsInfo.class);
//	System.out.println(contactsInfo);
	UniversityInfo info=factory.getBean("UniversityInfo",UniversityInfo.class);
	System.out.println(info);
	

	}
}
