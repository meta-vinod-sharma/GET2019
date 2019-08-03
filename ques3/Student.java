package ques3;

import java.util.ArrayList;

public class Student {
	String studentName;
	ArrayList<String> preference = new ArrayList<String>();

	Student(String studentName, ArrayList<String> values) {
		this.studentName = studentName;
		this.preference = values;
	}

}