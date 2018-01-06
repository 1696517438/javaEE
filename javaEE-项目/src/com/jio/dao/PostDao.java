package com.jio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jio.entity.Post;

public interface PostDao {
	public List<Post> queryAllPost();
	public List<Post> queryPostByDid(int id);
	public int addPost(@Param("name")String name,@Param("id")int id);
	public int delPost(int id);
	
	public Post queryPostByDidAndPname(@Param("id")int id,@Param("name")String name);

}
