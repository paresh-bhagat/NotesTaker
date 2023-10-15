package com.notestaker.userservice.externalservice;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.notestaker.userservice.entity.Note;

import jakarta.validation.Valid;

@FeignClient(name = "NOTE-SERVICE" )
public interface NoteServiceClient {

	@GetMapping("/notestaker/notes/{id}/{username}")
	public ResponseEntity<Note> getNote(@PathVariable("id") int id, @PathVariable("username") String username);
	
	@GetMapping("/notestaker/notes/{username}")
	public ResponseEntity<List<Note>> getAllNotes(@PathVariable("username") String username);
	
	@PostMapping("/notestaker/notes/{username}")
	public ResponseEntity<?> addNote(@Valid @RequestBody Note newNote, 
			@PathVariable("username") String username);
	
	@DeleteMapping("/notestaker/notes/{id}/{username}")
	public ResponseEntity<Void> deleteNote(@PathVariable("id") int id, @PathVariable("username") String username);
	
	@PutMapping("/notestaker/notes/{id}/{username}")
	public ResponseEntity<?> updateNote(@PathVariable("id") int id, @Valid @RequestBody Note newNote, 
		 @PathVariable("username") String username);
	
	@DeleteMapping("/notestaker/notes/{username}")
	public ResponseEntity<Void> deleteAllNotes(@PathVariable("username") String username);
}
