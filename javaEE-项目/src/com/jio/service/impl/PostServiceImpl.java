package com.jio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.dao.PostDao;
import com.jio.entity.Post;
import com.jio.service.PostService;

@Service("postService")
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostDao postDao;
	@Override
	public List<Post> queryAllPost() {
		
		return postDao.queryAllPost();
	}

	@Override
	public List<Post> queryPostByDid(int id) {
		
		return postDao.queryPostByDid(id);
	}

	@Override
	public int addPost(String name, int id) {
		
		return postDao.addPost(name, id);
	}

	@Override
	public int delPost(int id) {
		
		return postDao.delPost(id);
	}

	@Override
	public Post queryPostByDidAndPname(int id, String name) {
		
		return postDao.queryPostByDidAndPname(id, name);
	}

}
