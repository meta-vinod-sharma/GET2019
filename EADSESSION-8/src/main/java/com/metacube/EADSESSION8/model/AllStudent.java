package com.metacube.EADSESSION8.model;

import java.util.ArrayList;

public class AllStudent {
	
	 public static  ArrayList<Student> list1 = new ArrayList<Student>();

	public static ArrayList<Student> getStudent(){
		
	
	ArrayList<Student> list1 = new ArrayList<Student>();
	Student s1 = new Student("Vinod", "Sharma", "RS Sharma",
			"vinod.sharma@metacube.com", "12", "12");
	Student s2 = new Student("Vinay", "Pancholi", "DK Pancholi",
			"vinay.pancholi@metacube.com", "1", "1");
	Student s3 = new Student("Bhupendra", "Kumawat", "BK",
			"Bhupendra.Kumawat@metacube.com", "10", "2");
	Student s4 = new Student("Surender", "Sengwa", "SR",
			"Surender.Sengwa@metacube.com", "8", "12");
	Student s5 = new Student("Vinod", "Sharma", "RS Sharma",
			"vinod.sharma@metacube.com", "5", "12");
	list1.add(s1);
	list1.add(s2);
	list1.add(s3);
	list1.add(s4);
	list1.add(s5);
	
	return list1;
	
	}
	
}
