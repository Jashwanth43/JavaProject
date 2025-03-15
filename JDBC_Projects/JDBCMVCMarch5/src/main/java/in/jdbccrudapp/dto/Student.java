package in.jdbccrudapp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//DTO==>data transfer object
@Entity
@Table(name="student")
public class Student implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sid")
		private int sid;
		@Column(name="sname")
		private String name;
		@Column(name="saddress")
		private String address;
		@Column(name="sage")
		private int sage;
		static {
			System.out.println("Student class is loading...");
		}
		
		public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			 this.sid=sid;
		}
		public  Student() {
			System.out.println("student object created");
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSaddress() {
			return address;
		}
		public void setSaddress(String address) {
			this.address = address;
		}
		public int getage() {
			return sage;
		}
		public void setage(int sage) {
			 this.sage=sage;
		}
		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + sage + ", city=" + address +"]";
		}
		
	

}
