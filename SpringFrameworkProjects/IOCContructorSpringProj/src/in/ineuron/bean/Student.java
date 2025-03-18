package in.ineuron.bean;

public class Student {
private int id;
private String name;
private float sal;
public Student(int id, String name, float sal) {

	this.id = id;
	this.name = name;
	this.sal = sal;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", sal=" + sal + "]";
}

}
