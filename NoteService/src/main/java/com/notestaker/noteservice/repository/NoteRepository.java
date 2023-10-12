package com.notestaker.noteservice.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.notestaker.noteservice.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Integer> {
	
	// find notes by id and username
	Optional<Note> findByIdAndUsername(int id, String username);
	
	// find notes by username
	Optional<List<Note>> findAllByUsername(String username);
	
	@Modifying
    @Query("DELETE FROM Note n WHERE n.username = ?1")
    void deleteAllByUsername(String username);
}
