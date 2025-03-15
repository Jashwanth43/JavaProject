package in.jdbccrudapp.main;
import in.jdbccrudapp.model.*;
import in.jdbccrudapp.utils.HibernateUtil;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import in.jdbccrudapp.controller.IStudentController;
import in.jdbccrudapp.factory.StudentControlerFactory;

public class TestApp {
 static {
	 HibernateUtil.startUp();
 }
	public static void main(String[] args) {
		 IStudentController studentController= null;
		 String name=null;int id;String city=null;String email=null;String country=null;
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 Student student;
		 String status=null;
		 try {
			while (true) {
				System.out.println("1:CREATE");
				System.out.println("2:READ");
				System.out.println("3:UPDATE");
				System.out.println("4:DELETE");
				System.out.println("5:EXIT");
				Integer option=Integer.parseInt(br.readLine());
				switch(option) {
				case 1:
					System.out.print("Enter name: ");
					 name=br.readLine();
					System.out.println("Enter city: ");
					 city=br.readLine();
					System.out.println("Enter email: ");
					 email=br.readLine();
					System.out.println("Enter country: ");
					 country=br.readLine();
					 studentController= StudentControlerFactory.getStudentController();
					  student=new Student();
					 student.setName(name);
					 student.setCity(city);
					 student.setCountry(country);
					 student.setEmail(email);
					  status= studentController.save(student);
					  if(status!=null) {
					 if(status.equalsIgnoreCase("success")) {
						 System.out.println("success");
					 }
					 else if (status.equalsIgnoreCase("failure")) {
						 System.out.println("failure");
					 }
					 else {
						 System.out.println("Something wrong");
					 }
					  }
					 
				break;
				case 2:
						System.out.println("Enter the id: ");
						id=Integer.parseInt(br.readLine());
						 studentController= StudentControlerFactory.getStudentController();
						student=studentController.findById(id);
						if(student!=null)
							System.out.println(student);
						else 
							System.out.println("Record not available");
					break;
				case 3:
					System.out.println("Enter the id: ");
					id=Integer.parseInt(br.readLine());
					 studentController= StudentControlerFactory.getStudentController();
					student=studentController.findById(id);
					if(student!=null) {
						student.setSid(student.getSid());
						System.out.println(student);
						System.out.println("Enter the details to get update: ");
						System.out.print("Enter name: ");
						 name=br.readLine();
						 if(name==null || name.equalsIgnoreCase("")) {
							 student.setName(student.getName());
						 }else {
							 student.setName(name);
						 }
							System.out.println("Enter city: ");

						 city=br.readLine();
						 if(city==null || city.equalsIgnoreCase("")) {
							 student.setCity(student.getCity());
						 }else {
							 student.setCity(city);
						 }
							System.out.println("Enter email: ");

						 email=br.readLine();
						 if(email==null || email.equalsIgnoreCase("")) {
							 student.setEmail(student.getEmail());
						 }else {
							 student.setEmail(email);
						 }
							System.out.println("Enter country: ");

						 country=br.readLine();
						 if(country==null || country.equalsIgnoreCase(" ")) {
							 student.setCountry(student.getCountry());
						 }else {
							 student.setCountry(country);
						 }
						 
						 status=studentController.updateById(student);
						 if(status!=null) {
							 if(status.equalsIgnoreCase("success")) {
								 System.out.println("success");
							 }
							 else if (status.equalsIgnoreCase("failure")) {
								 System.out.println("failure");
							 }
							 else {
								 System.out.println("Something wrong");
							 }
							  }
					}
					else 
						System.out.println("Record not available");
					break;
				case 4:
					  studentController= StudentControlerFactory.getStudentController();
					  System.out.println("Enter the id: ");
					  id=Integer.parseInt(br.readLine());
					  status= studentController.deleteById(id);
					  if(status!=null) {
					 if(status.equalsIgnoreCase("success")) {
		   				 System.out.println("Record deleted successfully");
					 }
					 else if (status.equalsIgnoreCase("failure")) {
						 System.out.println("Record deletion failed");
					 }
					 else {
						 System.out.println("record not available");
					 }
					  }
					break;
				case 5:
					System.exit(0);
					
				default:
			}
					
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
