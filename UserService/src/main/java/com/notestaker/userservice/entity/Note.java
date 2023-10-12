package com.notestaker.userservice.entity;

import java.util.Date;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Note {
	
	private int id;
	
	@Size(min=1,max=20,message="Username between 1 to 20 characters")
	private String username;
	
	@Size(min=1,max=70,message="Title between 1 to 70 characters")
	private String title;
	
	@Size(min=1,max=7500,message="Content between 1 to 7500 characters")
	private String content;
	
	private Date date;
	
}
