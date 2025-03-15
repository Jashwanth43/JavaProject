package hibernate5march;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Person")
public class PersonInfo {
	@Id

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pid;
	@Column(length=20)
	private String pname;
	@Column(length=20)
	private String paddress;
	//@Temporal(TemporalType.DATE)
	private LocalDate dob;
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dom;
	//@Temporal(TemporalType.TIME)
	private LocalTime doj;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPaddress() {
		return paddress;
	}
	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate localDate) {
		this.dob = localDate;
	}
	public LocalDateTime getDom() {
		return dom;
	}
	public void setDom(LocalDateTime localDateTime) {
		this.dom = localDateTime;
	}
	public LocalTime getDoj() {
		return doj;
	}
	public void setDoj(LocalTime localTime) {
		this.doj = localTime;
	}
	@Override
	public String toString() {
		return "PersonInfo [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress + ", dob=" + dob + ", dom="
				+ dom + ", doj=" + doj + "]";
	}
	
	
	
}
