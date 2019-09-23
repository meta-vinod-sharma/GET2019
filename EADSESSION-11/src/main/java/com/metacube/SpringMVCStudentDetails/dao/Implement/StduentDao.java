package com.metacube.SpringMVCStudentDetails.dao.Implement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.metacube.SpringMVCStudentDetails.Model.Student;
import com.metacube.SpringMVCStudentDetails.dao.IStudentDao;

@Transactional
@Component
public class StduentDao implements IStudentDao{

	@Autowired
	HibernateTemplate sqlHandler;
	@Override
	public void addStudnet(Student student) {
		sqlHandler.save(student);
		
	}
	@Override
	public List<Student> getAllStudent() {
		return sqlHandler.loadAll(Student.class);
	}

}
