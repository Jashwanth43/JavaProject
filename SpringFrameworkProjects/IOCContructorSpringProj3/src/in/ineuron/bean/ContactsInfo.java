package in.ineuron.bean;
import java.util.Date;
import java.util.Set;
public class ContactsInfo {
private Set<String> phoneNumbers;
private Set <Date> dates;
public ContactsInfo(Set<String> phoneNumbers, Set<Date> dates) {
	this.phoneNumbers = phoneNumbers;
	this.dates = dates;
}
@Override
public String toString() {
	return "ContactsInfo [phoneNumbers=" + phoneNumbers + ", dates=" + dates + "]";
}

}
