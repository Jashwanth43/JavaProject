package in.ineuron.main;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;
import in.ineuron.vo.CustomerVo;
import in.ineuron.controller.MainController;
public class ClientApp {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("/in/ineuron/cfg/applicationContext.xml");
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the CustomerName :: ");
		String customerName = scanner.next();

		System.out.print("Enter the CustomerAddr :: ");
		String customerAddress = scanner.next();

		System.out.print("Enter the Principal Amount :: ");
		String pamount = scanner.next();

		System.out.print("Enter the Time period :: ");
		String time = scanner.next();

		System.out.print("Enter the Rate of Interest :: ");
		String rate = scanner.next();
		CustomerVo vo=new CustomerVo();
		vo.setCustomerAddress(customerAddress);
		vo.setCustomerName(customerName);
		vo.setPamt(pamount);
		vo.setRate(rate);
		vo.setTime(time);
//		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
//		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//		reader.loadBeanDefinitions("/in/ineuron/cfg/applicationContext.xml");
		//MainController controller=factory.getBean("controller",MainController.class);
		MainController controller=context.getBean("controller",MainController.class);
		String result = controller.processResult(vo);
		System.out.println(result);
		scanner.close();
	}
 
}
