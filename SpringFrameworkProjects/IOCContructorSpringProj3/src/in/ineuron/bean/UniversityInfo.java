package in.ineuron.bean;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

public class UniversityInfo {
 private Map<Integer,String> facultyDetails;
 private Map<String,Date> dataInfo;
 private Properties technologies;


public void setTechnologies(Properties technologies) {
	this.technologies = technologies;
}

public Map<Integer, String> getFacultyDetails() {
	return facultyDetails;
}

public void setFacultyDetails(Map<Integer, String> facultyDetails) {
	this.facultyDetails = facultyDetails;
}

public Map<String, Date> getDataInfo() {
	return dataInfo;
}

public void setDataInfo(Map<String, Date> dataInfo) {
	this.dataInfo = dataInfo;
}

@Override
public String toString() {
	return "UniversityInfo [facultyDetails=" + facultyDetails + ", dataInfo=" + dataInfo + ", technologies="
			+ technologies + "]";
}


 
}
