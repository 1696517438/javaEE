package com.jio.dao;

import java.util.List;

import com.jio.entity.AddStudent;
import com.jio.entity.Student;

public interface StudentDao {
	
	public List<Student> queryAllStudents();
	
	public int  addStudents(AddStudent addStudent);

	public Student queryStudentById(int id);
	
	public int delStudent(int id);
	
	public int updateStudent(AddStudent student);

	public Student findStudentByName(String name);

	public List<Student> findStudentBySubjectId(int id);
}
