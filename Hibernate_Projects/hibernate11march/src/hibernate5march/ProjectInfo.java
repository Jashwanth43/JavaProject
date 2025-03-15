package hibernate5march;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class ProjectInfo implements Serializable {
	@Column(name="pid")
	private Integer pid;
	@Column(name="pgmId")
	private Integer pgmid;
	public ProjectInfo() {
		
	}
	
	public ProjectInfo(Integer pid, Integer pgmid) {
		this.pid = pid;
		this.pgmid = pgmid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getProjid() {
		return pgmid;
	}
	public void setProjid(Integer pgmid) {
		this.pgmid = pgmid;
	}
	@Override
	public String toString() {
		return "ProjectInfo [pid=" + pid + ", pgmid=" + pgmid + "]";
	}
}
