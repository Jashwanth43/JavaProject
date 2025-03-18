package in.ineuron.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="bDart")
@Scope(value = "prototype")
public class BlueDart implements Courier {

	static {
		System.out.println("BlueDart.class file is loading...");
	}

	public BlueDart() {
		System.out.println("BlueDart object is instantiated...");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("BlueDart.deliver()");

		return "BlueDart courier will deliver with the order id ::" + oid + " order products";
	}

}
