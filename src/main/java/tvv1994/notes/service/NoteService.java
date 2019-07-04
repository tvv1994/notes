package tvv1994.notes.service;

import tvv1994.notes.model.Note;

import java.util.List;

public interface NoteService {

    void add(String title, String note);
    void remove(Long id);
    List<Note> getAllModels();
    List<Note> getModelsByFilter(String filter);

}