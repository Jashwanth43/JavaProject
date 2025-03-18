package in.ineuron.bean;

import java.util.Date;

//Target class-----> UserDefined
public class WishMessgeGenerator {

	private Date date;

	static {
		System.out.println("WishMessageGenerator.class file is loading...");
	}

	public WishMessgeGenerator() {
		System.out.println("WishMessageGenerator object is instantiated...");
	}

	public void setDate(Date date) {
		System.out.println("WishMessgeGenerator.setDate()");
		this.date = date;
	}

	// BUISNESS logic to use Injected DATE in the Target class Object
	public String generateWishMessage(String name) {
		System.out.println("Date object created using setter inject with the value :: "+date);
		@SuppressWarnings("deprecation")
		int hour = date.getHours();
		if (hour <= 12)
			return "Hello :: " + name + " Good morning!!!";
		else if (hour <= 16)
			return "Hello :: " + name + " Good Afternoon!!!";
		else if (hour <= 20)
			return "Hello :: " + name + " Good Evening!!!";
		else
			return "Hello :: " + name + " Good Night!!!";
	}
}
