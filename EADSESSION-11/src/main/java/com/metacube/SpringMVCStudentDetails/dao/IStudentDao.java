package com.metacube.SpringMVCStudentDetails.dao;

import java.util.List;

import com.metacube.SpringMVCStudentDetails.Model.Student;

public interface IStudentDao {

	public void addStudnet(Student student);
	public List<Student> getAllStudent();
}
