package tvv1994.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tvv1994.notes.model.Note;


public interface NoteRepo extends JpaRepository<Note, Long> {
}
