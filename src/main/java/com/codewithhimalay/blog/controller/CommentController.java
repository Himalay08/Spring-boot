package com.codewithhimalay.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithhimalay.blog.payload.CommentDto;
import com.codewithhimalay.blog.service.CommentService;
import com.codewithhimalay.blog.utils.ApiResponse;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping("user/{userId}/post/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(
		@RequestBody CommentDto commentDto,	
		@PathVariable("userId") Integer userId,
		@PathVariable("postId") Integer postId
			){
		CommentDto newCommentDto=this.commentService.createComment(commentDto, postId, userId);
		return new ResponseEntity<CommentDto>(newCommentDto,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(
		@PathVariable("commentId") Integer commentId
			){
		this.commentService.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully!",true),HttpStatus.OK);
	}
	
}
