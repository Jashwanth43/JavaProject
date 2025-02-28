import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;


class Student implements  Comparable<Student> {
    private Integer studentID;
    private String name;
    private String address;

    public Student(Integer studentID, String name, String address) {
        this.studentID = studentID;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        System.out.println(this.studentID.compareTo(o.studentID));
        return o.studentID.compareTo(this.studentID);
    }

    public Integer getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
     Student S1=new Student(1, "jashwanth", "redmond");
     Student S2=new Student(2, "Jay", "seattle");
     Student S3=new Student(3, "sandeep", "bellavue");
     List<Student> ls=new ArrayList<>(List.of(S1,S2,S3));
//     Collections.sort(ls); //Done through Comparable interface
//        Collections.sort(ls,new comp()); //using Comparator interface by creating object
        Collections.sort(ls,(s1,s2)->s2.getStudentID()>s1.getStudentID()?1:-1); //comparator using lambda expressions
        for(Student s: ls ){
            System.out.println(s);
        }


    }


}
class comp implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getStudentID()>o2.getStudentID() ? -1 :1 ; // it will print reverse order of the list based on the studentID;
    }
}
