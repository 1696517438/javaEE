package com.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jio.dao.StudentDao;
import com.jio.dao.SubjectDao;
import com.jio.entity.AddStudent;
import com.jio.entity.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring.xml","/spring-mvc.xml","/spring-mybatis.xml"})
public class HwTest {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private SubjectDao subjectDao;
	@Test
	public void select() {
		List<Student> findStudentBySubjectId = studentDao.findStudentBySubjectId(1);
		
	}
}
