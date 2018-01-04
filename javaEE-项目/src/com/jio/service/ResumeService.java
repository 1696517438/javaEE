package com.jio.service;


import com.jio.entity.Resume;

public interface ResumeService {
	
	public Resume queryResumeByName(String name);
	
	public int addResume(Resume resume);
	
	public int updateResume(Resume resume);
	
	public Resume queryResumeById(int id);

}
