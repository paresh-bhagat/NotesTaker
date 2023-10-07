package com.notestaker.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.notestaker.userservice.entity.User;

public interface UserRepository extends JpaRepository<User,String> {

	@Query("select u from User u where u.username = :username")
	public User getUserByUserName(@Param("username") String username);
}
