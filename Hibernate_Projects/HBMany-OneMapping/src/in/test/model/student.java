package in.test.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ManyToOne(cascade=CascadeType.ALL)
private Integer studentId;
private String studentName;
private String studentAdder;
private branch br;
public student( String studentName, String studentAdder, branch br) {
	this.studentName = studentName;
	this.studentAdder = studentAdder;
	this.br = br;
}
@Override
public String toString() {
	return "student [studentId=" + studentId + ", studentName=" + studentName + ", studentAdder=" + studentAdder
			+ ", br=" + br + "]";
}

}
