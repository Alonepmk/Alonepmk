package com.alonepmk.Manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alonepmk.Mapper.CommentMapper;
import com.alonepmk.Model.Comment;

@Service
@Transactional
public class CommentManager {
	@Autowired
	public CommentMapper commentMapper;
	
	public List<Comment> getAllComment(){
		return commentMapper.getAllComment();
	}

	public List<Comment> getLastComments(int lastIndex) {
		return commentMapper.getLastComments(lastIndex);
	}

	public void insertNewComment(String email, String data) {
		commentMapper.insertNewComment(email,data);
	}
}
