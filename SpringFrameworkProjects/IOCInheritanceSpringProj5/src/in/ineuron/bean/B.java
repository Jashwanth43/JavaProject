package in.ineuron.bean;

public class B {
private A a;

@Override
public String toString() {
	return "B [a=" + a + "]";
}

public A getA() {
	return a;
}

public void setA(A a) {
	this.a = a;
}


public B() {
	System.out.println("Called B");	

}
}
