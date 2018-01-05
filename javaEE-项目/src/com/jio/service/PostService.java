package com.jio.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jio.entity.Post;

public interface PostService {
	public List<Post> queryAllPost();
	public List<Post> queryPostByDid(int id);
	public int addPost(@Param("name")String name,@Param("id")int id);
	public int delPost(int id);

}
