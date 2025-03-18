package in.ineuron.bean;

public class Student {
private int id;
private String name;
private float sal;
public Student() {
	System.out.println("default constructor is called");
}
public Student(int id, String name, float sal) {
System.out.println("The parameter consructor is called");
	this.id = id;
	this.name = name;
	this.sal = sal;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", sal=" + sal + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	System.out.println("The setter is called");

	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	System.out.println("The setter is called");

	this.name = name;
}
public float getSal() {
	return sal;
}
public void setSal(float sal) {
	System.out.println("The setter is called");

	this.sal = sal;
}

}
