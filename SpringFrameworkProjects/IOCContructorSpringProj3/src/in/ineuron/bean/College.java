package in.ineuron.bean;
import java.util.List;
import java.util.Date;
public class College {
private List<String> Students;
private List<Date> dates;
public List<String> getStudents() {
	return Students;
}
public void setStudents(List<String> students) {
	Students = students;
}
public List<Date> getDates() {
	return dates;
}
public void setDates(List<Date> dates) {
	this.dates = dates;
}
@Override
public String toString() {
	return "College [Students=" + Students + ", dates=" + dates + "]";
}



}
