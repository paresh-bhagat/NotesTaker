package com.notestaker.userservice.entity;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
@Entity
@Table(name="user")
public class User {

	@Id
	@Column(length=20,name="user_name")
	@Size(min=1,max=20,message="Username between 1 to 20 characters")
	private String username;
	
	@Column(length=100,name="user_password")
	private String password;
	
	@Column(length=10,name="user_role")
	private String role;
	
	@Transient
	private List<Note> notes;

}
