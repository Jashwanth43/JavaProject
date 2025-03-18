package in.ineuron.bean;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component(value="fpkt")
@PropertySource(value = { "in/ineuron/common/info.properties" })

//Target Object
public class Flipkart {

	// Dependent Object
	@Autowired
	@Qualifier(value = "dtdc")
	private Courier courier;
    @Autowired
	private Date date;
	@Value(value="${url}")
	private String url;
	@Value(value="${discount}")
	private int discount;
	@Value(value = "${Path}")
	private String pathValue;
	@Value(value="${os.name}")
	private String os;
	@Override
	public String toString() {
		return "Flipkart [courier=" + courier + "]";
	}

	static {
		System.out.println("Flipkart.class file is loading...");
	}

	public Flipkart() {
		System.out.println("Flipkart object is created...");
	}

	

	// BUISNESS LOGIC
	public String shopping(String[] items, float[] prices) {
		System.out.println("Flipkart.shopping()");
		System.out.println(courier.getClass().getName());
		System.out.println("Date object details :: " + date);
		System.out.println("URL value is :: " + url);
		System.out.println("Discount amount is :: " + discount);
		
		System.out.println();
		
		System.out.println(os);
		System.out.println(pathValue);

		Random random = null;
		float billAmt = 0.0f;
		int oid = 0;
		for (float price : prices) {
			billAmt += price;
		}
		random = new Random();
		oid = random.nextInt(1000);
		String msg = courier.deliver(oid);

		return Arrays.toString(items) + "are purchase having prices " + Arrays.toString(prices)
				+ " with the bill amount :: " + billAmt + "---> " + msg;
	}
}
