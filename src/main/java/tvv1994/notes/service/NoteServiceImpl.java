package tvv1994.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tvv1994.notes.model.Note;
import tvv1994.notes.repository.NoteRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepo noteRepo;

    @Override
    @Transactional
    public void add(String title, String note) {
            noteRepo.save(new Note(title, note));
    }

    @Override
    @Transactional
    public void remove(Long id) {
        noteRepo.deleteById(id);
    }

    @Override
    public List<Note> getAllModels() {
        return noteRepo.findAll();
    }

    @Override
    public List<Note> getModelsByFilter(String filter) {
        List<Note> noteList = new ArrayList<>();
        for (Note note: noteRepo.findAll()){
            if(note.getTitle().contains(filter) || note.getNote().contains(filter)){
                noteList.add(note);
            }
        }
        return noteList;
    }
}
