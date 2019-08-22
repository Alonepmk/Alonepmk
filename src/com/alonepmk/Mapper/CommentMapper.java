package com.alonepmk.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.alonepmk.Model.Comment;

public interface CommentMapper {
	
	@Select("select *,"
			+ "(select firstName from account where email=email) as firstName,"
			+ "(select lastName from account where email=email) as lastName,"
			+ "(select CONCAT(firstName,' ',lastName) from account where email=email) as fullName"
			+ " from comment")
	public List<Comment> getAllComment();

	@Select("select *,"
			+ "(select firstName from account where email=email) as firstName,"
			+ "(select lastName from account where email=email) as lastName,"
			+ "(select CONCAT(firstName,' ',lastName) from account where email=email) as fullName"
			+ " from comment where id>#{lastIndex}")
	public List<Comment> getLastComments(@Param("lastIndex") int lastIndex);

	@Insert("INSERT INTO comment (email,comment) VALUES (#{email}, #{data})" )
	public void insertNewComment(@Param("email") String email,@Param("data") String data);
}
