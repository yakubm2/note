package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Note;

public interface NoteRepo extends CrudRepository<Note,Integer> {

//	@Query("Select n from Note n where n.userId=:userId")
//	List<Note> findAllByUserId(@Param("userId")int userId);
	
//	List<Note> findAllByUserId(int userId);
    
}
