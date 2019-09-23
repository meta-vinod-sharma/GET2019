package com.metacube.EADSESSION_12.servics.Implement;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.EADSESSION_12.Model.Student;
import com.metacube.EADSESSION_12.repository.StudentRepository;
import com.metacube.EADSESSION_12.servics.IStudentServics;

/*
 * Class to implement servics layer method.
 */
@Service
public class StudentServics implements IStudentServics {

	@Autowired
	private StudentRepository repository;
	
	//Method to add student in the database.
	@Override
	@Transactional
	public void addStudnet(Student student) {
		repository.save(student);
	}
	
	//Method to get student list from database.
	@Override
	@Transactional
	public List<Student> getAllStudent() {
		return (List<Student>) repository.findAll();
	}

	//Method to return the student which name equal to key.
	@Override
	@Transactional
	public List<Student> getStudentByName(String Key) {
		return repository.findByfirstNameContainingIgnoreCase(Key);
	}

}
