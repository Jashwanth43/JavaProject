package in.ineuron.bean;

public class FirstFlight implements Courier {

	static {
		System.out.println("FirstFlight.class file is loading...");
	}

	public FirstFlight() {
		System.out.println("FirstFlight object is created...");
	}

	@Override
	public String deliver(int oid) {
		return "FirstFlight courier will deliver with the order id :: " + oid + " order products";
	}

}
