package com.jio.dao;

import com.jio.entity.Resume;

public interface ResumeDao {
	
	public Resume queryResumeByName(String name);
	
	public int addResume(Resume resume);
	
	public int updateResume(Resume resume);
	
	public Resume queryResumeById(int id);

}
