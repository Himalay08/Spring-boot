package com.codewithhimalay.blog;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.codewithhimalay.blog.config.AppConstants;
import com.codewithhimalay.blog.entity.Role;
import com.codewithhimalay.blog.repository.RoleRepository;

@SpringBootApplication
public class BlogAppApisApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(this.passwordEncoder.encode("himalay"));
		
		try {
			Role role=new Role();
			role.setId(AppConstants.ADMIN);
			role.setName("ROLE_ADMIN");
			
			Role role1=new Role();
			role1.setId(AppConstants.USER);
			role1.setName("ROLE_USER");
			
			List<Role> roles=List.of(role,role1);
			
			List<Role> result=this.roleRepository.saveAll(roles);
			
//			result.forEach(r->{
//				System.out.println(r.getName());
//			});
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
