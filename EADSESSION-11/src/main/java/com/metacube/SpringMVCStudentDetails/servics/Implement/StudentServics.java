package com.metacube.SpringMVCStudentDetails.servics.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.SpringMVCStudentDetails.Model.Student;
import com.metacube.SpringMVCStudentDetails.dao.IStudentDao;
import com.metacube.SpringMVCStudentDetails.servics.IStudentServics;

@Service
public class StudentServics implements IStudentServics {

	@Autowired
	private IStudentDao dao;
	@Override
	public void addStudnet(Student student) {
		dao.addStudnet(student);
	}
	@Override
	public List<Student> getAllStudent() {
		return dao.getAllStudent();
	}

}
