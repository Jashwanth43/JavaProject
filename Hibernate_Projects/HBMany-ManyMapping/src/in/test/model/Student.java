package in.test.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer sid;
private String sname;
private String address;
@ManyToMany(cascade = CascadeType.ALL)
private Set<Course> set;
public Student(String sname, String address, Set<Course> set) {
	super();
	this.sname = sname;
	this.address = address;
	this.set = set;
}
@Override
public String toString() {
	return "Student [sid=" + sid + ", sname=" + sname + ", address=" + address + ", set=" + set + "]";
}

}
