package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{
	       @Query("SELECT r FROM User r WHERE r.id = :id")
			User getMyUser(@Param("id") int userId);
}
