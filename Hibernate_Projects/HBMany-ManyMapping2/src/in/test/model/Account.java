package in.test.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Account implements Serializable {
	@Id
private Integer accNo;
private String accName;
private String accType;
public Integer getAccNo() {
	return accNo;
}
public void setAccNo(Integer accNo) {
	this.accNo = accNo;
}
public String getAccName() {
	return accName;
}
public void setAccName(String accName) {
	this.accName = accName;
}
public String getAccType() {
	return accType;
}
public void setAccType(String accType) {
	this.accType = accType;
}
@Override
public String toString() {
	return "Account [accNo=" + accNo + ", accName=" + accName + ", accType=" + accType + "]";
}

}
