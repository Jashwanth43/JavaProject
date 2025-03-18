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



	public WishMessgeGenerator(Date date) {
		System.out.println("The constructor has loaded: "+date);
		this.date = date;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		System.out.println("WishMessgeGenerator.setDate()");
		this.date = date;
	}



	// BUISNESS logic to use Injected DATE in the Target class Object
	public String generateWishMessage(String name) {
		System.out.println("The metod has loaded ***: "+date);
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
