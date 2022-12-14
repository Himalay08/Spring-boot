package com.codewithhimalay.blog.payload;

 
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email; 
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	
	@NotEmpty
	@Size(min = 4,message = "Username must be 4 characters long")
	private String name;
	
	@Email(message = "Enter valid email addresss")
	
	@NotEmpty
	private String email;
	
	
	@NotEmpty
	@Size(min = 3,max = 10,message = "Password must be minimum of 3 chars and maximum of 10 characters long")
	private String password;
	
	
	@NotEmpty
	private String about;
	
	private Set<RoleDto> roles=new HashSet<RoleDto>();
}
