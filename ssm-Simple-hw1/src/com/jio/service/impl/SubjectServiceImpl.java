package com.jio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.dao.SubjectDao;
import com.jio.entity.Subject;
import com.jio.service.SubjectService;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectDao subjectDao;

	public List<Subject> findAllSubject() {
		
		return subjectDao.queryAllSubject();
	}

}
