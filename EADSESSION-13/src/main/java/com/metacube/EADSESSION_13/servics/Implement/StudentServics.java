package com.metacube.EADSESSION_13.servics.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.EADSESSION_13.Model.Student;
import com.metacube.EADSESSION_13.dao.IStudentDao;
import com.metacube.EADSESSION_13.servics.IStudentServics;

/*
 * Class to implement servics layer method.
 */
@Service
public class StudentServics implements IStudentServics {

	@Autowired
	private IStudentDao dao;
	
	//Method to add student in the database.
	@Override
	public void addStudnet(Student student) {
		dao.addStudnet(student);
	}
	
	//Method to get student list from database.
	@Override
	public List<Student> getAllStudent() {
		return dao.getAllStudent();
	}

}
