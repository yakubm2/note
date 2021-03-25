package com.example.demo.controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Note;
import com.example.demo.entity.User;
import com.example.demo.service.NoteService;

@RestController
public class Notes {
  @Autowired
  NoteService noteService;
  @RequestMapping(method = RequestMethod.POST,value="/create/{userId}",produces=MediaType.APPLICATION_JSON_VALUE)
  public String createNotes(@PathVariable int userId,@RequestBody Note notes) {
	  int id= noteService.createNotes(notes,userId);
	  return "note with "+id+" created";
	  
  }
  
  @RequestMapping(method = RequestMethod.GET,value="/get/{userId}",produces=MediaType.APPLICATION_JSON_VALUE)
  public Set<Note> getNotes(@PathVariable int userId) {
	  
	  User u=  noteService.getNotes(userId);
	  Set<Note> response=u.getNotes();
	  return response;
  }
  
  @RequestMapping(method = RequestMethod.PUT,value="/update/{noteId}",produces=MediaType.APPLICATION_JSON_VALUE)
  public Note updateNotes(@PathVariable int noteId,@RequestBody Note notes) {
	  noteService.updateNotes(noteId, notes);
	  return notes;
  }
  @RequestMapping(method = RequestMethod.POST,value="/tempDelete/{noteId}",produces=MediaType.APPLICATION_JSON_VALUE)
  public String deleteTempNotes(@PathVariable int noteId) {
	  noteService.tempDeleteNotes(noteId);
	  return "tempDeleted";
  }
  
  @RequestMapping(method = RequestMethod.DELETE,value="/delete/{noteId}",produces=MediaType.APPLICATION_JSON_VALUE)
  public String deleteNotes(@PathVariable int noteId) {
	  noteService.deleteNotes(noteId);
	  return "Deleted";
  }
}
