package com.metacube.SpringMVCStudentDetails.servics;

import java.util.List;

import com.metacube.SpringMVCStudentDetails.Model.Student;

public interface IStudentServics {

	public void addStudnet(Student student);
	public List<Student> getAllStudent();
}
