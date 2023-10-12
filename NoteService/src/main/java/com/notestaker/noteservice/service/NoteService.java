package com.notestaker.noteservice.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.notestaker.noteservice.entity.Note;
import com.notestaker.noteservice.repository.NoteRepository;

@Service
public class NoteService {
	
	@Autowired
	private NoteRepository noteRepository;
	
	public Note getNote(int id, String username) {
        return this.noteRepository.findByIdAndUsername(id, username).orElse(null);
    }
	
	public Note addNote(String name,Note note) {
		
		note.setUsername(name);
		Date date = new Date();
		note.setDate(date);
		return this.noteRepository.save(note);
	}
	
	public Boolean deleteNote(int id , String name) {
		
		Note temp = getNote(id,name);
		
		if(temp==null)
			return false;
		
		this.noteRepository.deleteById(id);
		
		return true;
	}

	public Note updateNote(int id, String name, Note note) {
		
		Note temp = getNote(id,name);
		
		if(temp==null)
			return null;
		
		temp.setTitle(note.getTitle());
		temp.setContent(note.getContent());
		Date date = new Date();
		temp.setDate(date);
		temp.setUsername(name);
		
		return this.noteRepository.save(temp);
	}

	public List<Note> getAllNotes(String username) {
		
		return this.noteRepository.findAllByUsername(username).orElse(null);
	}
	
	public void deleteAllNotes(String username) {
		this.noteRepository.deleteAllByUsername(username);
		return;
	}
}
