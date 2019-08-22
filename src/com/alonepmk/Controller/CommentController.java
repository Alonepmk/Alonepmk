package com.alonepmk.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alonepmk.Exception.AccountUnauthorizedException;
import com.alonepmk.Manager.CommentManager;
import com.alonepmk.Model.Comment;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	public CommentManager commentManager;
	
	@RequestMapping(value = "/getAllComment", method = RequestMethod.GET)
	public List<Comment> getAllComment(HttpSession session){
		if(session.getAttribute("account") == null) {
			 throw new AccountUnauthorizedException();
		}
		List<Comment> comment = null;
		comment = commentManager.getAllComment();
		return comment;
	}
	
	@RequestMapping(value = "/getLatestData/{lastIndex}", method = RequestMethod.GET)
	public List<Comment> getAllComment1(HttpSession session,@PathVariable("lastIndex") int lastIndex){
		if(session.getAttribute("account") == null) {
			 throw new AccountUnauthorizedException();
		}
		
		List<Comment> comment = null;
		comment = commentManager.getLastComments(lastIndex);
		return comment;
	}
	
	@RequestMapping(value = "/postAComment/{email}/{data}", method = RequestMethod.POST)
	public void postAComment(HttpSession session,@PathVariable("email") String email,
			@PathVariable("data") String data){
		if(session.getAttribute("account") == null) {
			 throw new AccountUnauthorizedException();
		}
		try {
			commentManager.insertNewComment(email,data);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
}
