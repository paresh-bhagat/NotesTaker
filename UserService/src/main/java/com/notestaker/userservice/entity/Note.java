package com.notestaker.userservice.entity;

import java.util.Date;
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
	private String user;
	private String title;
	private String content;
	private Date date;
	
}
