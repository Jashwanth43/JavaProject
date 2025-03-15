package in.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
	@Id
	private String cid;
	private String cname;
	private Integer cost;
	
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", cost=" + cost + "]";
	}

	public Course( String cid,String cname, Integer cost) {
		this.cid=cid;
		this.cname = cname;
		this.cost = cost;
	}
	
}
