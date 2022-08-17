package com.codewithhimalay.blog.service;

import com.codewithhimalay.blog.payload.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto,Integer postId,Integer userId);
    
	void deleteComment(Integer commentId);
}
