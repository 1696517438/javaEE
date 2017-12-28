package com.jio.service;

import java.util.List;

import com.jio.entity.AddStudent;
import com.jio.entity.Student;


public interface StudentService {

	public List<Student> findAllStudents();
	
	public int addStudent(AddStudent assAtudent);
	
	public Student findStudentById(int id);
	
	public int delStudent(int id);
	
	public int updateStudent(AddStudent addStudent);

	public Student findStudentByName(String name);

	public List<Student>  findStudentBySubjectId(int val);
}
