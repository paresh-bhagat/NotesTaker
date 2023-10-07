package com.notestaker.noteservice.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.notestaker.noteservice.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Integer> {
	Optional<Note> findByIdAndUserUsername(int id, String username);
}
