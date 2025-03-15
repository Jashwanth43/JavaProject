package in.test.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class branch implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String branchId;
	private String branchName;
	private String branchAddr;
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchAddr() {
		return branchAddr;
	}
	public void setBranchAddr(String branchAddr) {
		this.branchAddr = branchAddr;
	}
	@Override
	public String toString() {
		return "branch [branchId=" + branchId + ", branchName=" + branchName + ", branchAddr=" + branchAddr + "]";
	}
	
	
	
}
