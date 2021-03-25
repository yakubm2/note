package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Note;
import com.example.demo.entity.User;
import com.example.demo.repo.NoteRepo;
import com.example.demo.repo.UserRepo;

@Service
public class NoteService {
	@Autowired
	NoteRepo noteRepo;

	@Autowired
	UserRepo userRepo;
	public int createNotes(Note data,int  userId) {

		if(userRepo.existsById(userId))
		{
			
			User usr=userRepo.findById(userId).orElse(null);
			data.setUser(usr);
			data.setArchived(false);
			data.setTempDelete(false);
			
			noteRepo.save(data);
			
		}
		return data.getId();

	}
	public User  getNotes(int userId){

		return userRepo.getMyUser(userId);


	}
	public void updateNotes(int noteId,Note data) {

		if(noteRepo.existsById(noteId))
		{
			Note n=noteRepo.findById(noteId).orElseThrow();
			n.setTempDelete(data.isTempDelete());
			n.setArchived(data.isArchived());
			n.setText(data.getText());
			noteRepo.save(n);
		}
	}
	public void tempDeleteNotes(int noteId) {
		Note n=noteRepo.findById(noteId).orElse(null);
		n.setTempDelete(true);
		noteRepo.save(n);
	}
	
	public void restoreNotes(int noteId) {
		Note n=noteRepo.findById(noteId).orElse(null);
		n.setTempDelete(false);
		noteRepo.save(n);
	}
	
	public void deleteNotes(int noteId) {
		noteRepo.deleteById(noteId);
	}

}
