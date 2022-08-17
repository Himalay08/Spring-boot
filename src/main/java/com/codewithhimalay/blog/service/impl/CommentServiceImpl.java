package com.codewithhimalay.blog.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithhimalay.blog.entity.Comment;
import com.codewithhimalay.blog.entity.Post;
import com.codewithhimalay.blog.entity.User;
import com.codewithhimalay.blog.exception.ResourceNotFoundException;
import com.codewithhimalay.blog.payload.CommentDto;
import com.codewithhimalay.blog.repository.CommentRepository;
import com.codewithhimalay.blog.repository.PostRepository;
import com.codewithhimalay.blog.repository.UserRepository;
import com.codewithhimalay.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId) {
		// TODO Auto-generated method stub
		User user=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User"," User Id ", userId));
		Post post=this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post"," Post Id ", postId));
		
		Comment comment=this.modelMapper.map(commentDto,Comment.class);
		comment.setPost(post);
		comment.setUser(user);
		Comment updatedComment=this.commentRepository.save(comment);
		
		return this.modelMapper.map(updatedComment,CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		// TODO Auto-generated method stub

		Comment com=this.commentRepository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment"," Comment Id ", commentId));
		this.commentRepository.delete(com);
	}

}
