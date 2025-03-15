package hibernate5march;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
public class JobSeeker implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	@Id 
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//  @GeneratedValue(generator = "custom-generator")
	//    @GenericGenerator(name = "custom-generator", strategy = "your.package.CustomIdentifierGenerator")
	@Id
	@GeneratedValue(generator="randGne")
	@GenericGenerator(name="randGne",strategy="in.test.generator.RandomGenerator")
	private Integer id;
	@Column(length=20)
	private String jsName;
	@Lob
	private byte[] photo;
	@Lob
	private char[] resume;
	private boolean active;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJsName() {
		return jsName;
	}
	public void setJsName(String jsName) {
		this.jsName = jsName;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public char[] getResume() {
		return resume;
	}
	public void setResume(char[] resume) {
		this.resume = resume;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "JobSeeker [id=" + id + ", jsName=" + jsName + ", active=" + active + "]";
	}
	
	
}