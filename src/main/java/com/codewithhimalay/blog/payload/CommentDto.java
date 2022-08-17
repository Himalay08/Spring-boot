package com.codewithhimalay.blog.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

	private String commentId;
	
	private String content;
	
	private UserDto user;
}
