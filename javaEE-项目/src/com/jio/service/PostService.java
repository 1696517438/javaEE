package com.jio.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jio.entity.Post;

public interface PostService {
	public List<Post> queryAllPost();
	public List<Post> queryPostByDid(int id);
	public int addPost(String name,int id);
	public int delPost(int id);
	public Post queryPostByDidAndPname(int id,String name);
	

}
