package com.metacube.EADSESSION_12.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.metacube.EADSESSION_12.Model.Student;

/*
 * Repository interface.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	//Method to return the student which name equal to key.
	public List<Student> findByfirstNameContainingIgnoreCase(String key);
}