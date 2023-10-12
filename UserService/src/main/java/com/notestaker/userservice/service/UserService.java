package com.notestaker.userservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.notestaker.userservice.entity.Note;
import com.notestaker.userservice.entity.User;
import com.notestaker.userservice.externalservice.NoteServiceClient;
import com.notestaker.userservice.repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserService {

	@Autowired
	private BCryptPasswordEncoder passswordEncoder;
	
	@Autowired
	private NoteServiceClient noteserviceclient;
	
	@Autowired
	private UserRepository userrepo;
	
	public List<User> getUsers(){
		return this.userrepo.findAll();
	}
	
	public Boolean checkUsername(String username) {
		return userrepo.existsById(username);
	}
	
	public User signup(User user) {
		user.setPassword(this.passswordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		return this.userrepo.save(user);
	}
	
	public User getUserDetails(String name) {
		return this.userrepo.getUserByUserName(name);
	}

	public boolean deleteUser(String name, String password) {
		
		User user = getUserDetails(name);
		
		if(passswordEncoder.matches(password, user.getPassword())==false)
			return false;
		
		this.userrepo.delete(user);
		
		ResponseEntity<Void> responseentity = this.noteserviceclient.deleteAllNotes(name);
		
		if(responseentity.getStatusCode() != HttpStatus.OK)
			return false;
		
		return true;
	}

	public ResponseEntity<Note> getNotes(String name, int id) {
		
		return noteserviceclient.getNote(id,name);
	}

	public ResponseEntity<List<Note>> getAllNotes(String name) {
		return noteserviceclient.getAllNotes(name);
	}

	public ResponseEntity<?> addNote(String name, Note newNote) {
		
		return noteserviceclient.addNote(newNote, name);
	}

	public ResponseEntity<Void> deleteNote(String name, int id) {
		return noteserviceclient.deleteNote(id, name);
	}

	public ResponseEntity<?> updateNote(String name, int id, Note newNote) {
		return noteserviceclient.updateNote(id, newNote, name);
	}
	
	
}
