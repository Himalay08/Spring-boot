package com.codewithhimalay.blog.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	public static final String AUTHORIZARION_HEADER="Authorization";
	
	
	private ApiKey apikeys() {
		return new ApiKey("JWT", AUTHORIZARION_HEADER, "Header");
	}
	
	private List<SecurityContext> securityContexts(){
		return Arrays.asList(SecurityContext.builder().securityReferences(securityReferances()).build());
	}
	
	private List<SecurityReference> securityReferances(){
		AuthorizationScope scope=new AuthorizationScope("global","AccessEverything");
		return Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[] {scope}));
	}
	
	@Bean 
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfo())
				.securityContexts(securityContexts())
				.securitySchemes(Arrays.asList(apikeys()))
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo getInfo() {
		
		return new ApiInfo(
				"Blogging Application","Himalay Goyani personal project",
				"1.0",
				"Terms of Service",
				new Contact(
						"Himalay",
						"https://www.linkedin.com/in/goyani-himalay-376716135/",
						"hpgoyani08@gmail.com"
						),"License of API" , 
				"https://www.linkedin.com/in/goyani-himalay-376716135/", 
				Collections.emptyList()
				 
				);
	}
}
