package com.jio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.dao.StudentDao;
import com.jio.entity.AddStudent;
import com.jio.entity.Student;
import com.jio.service.StudentService;

@Service("stuentService")
public class StuentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	public List<Student> findAllStudents() {
		
		return studentDao.queryAllStudents();
	}

	@Override
	public int addStudent(AddStudent addStudent) {
		
		return studentDao.addStudents(addStudent);
	}

	@Override
	public Student findStudentById(int id) {
		
		return studentDao.queryStudentById(id);
	}

	@Override
	public int delStudent(int id) {
		
		return studentDao.delStudent(id);
	}

	@Override
	public int updateStudent(AddStudent addStudent) {
		
		return studentDao.updateStudent(addStudent);
	}

	@Override
	public Student findStudentByName(String name) {
		
		return studentDao.findStudentByName(name);
	}

	@Override
	public List<Student>  findStudentBySubjectId(int val) {
		return studentDao.findStudentBySubjectId(val);
	}

}
