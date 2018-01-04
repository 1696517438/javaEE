package com.jio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.dao.ResumeDao;
import com.jio.entity.Resume;
import com.jio.service.ResumeService;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService{
	@Autowired
	private ResumeDao resumeDao;

	@Override
	public Resume queryResumeByName(String name) {
		
		return resumeDao.queryResumeByName(name);
	}

	@Override
	public int addResume(Resume resume) {
		
		return resumeDao.addResume(resume);
	}

	@Override
	public int updateResume(Resume resume) {
		
		return resumeDao.updateResume(resume);
	}

	@Override
	public Resume queryResumeById(int id) {
		return resumeDao.queryResumeById(id);
	}
}
