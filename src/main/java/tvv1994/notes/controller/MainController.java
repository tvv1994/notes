package tvv1994.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tvv1994.notes.service.NoteService;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/getNotes")
    public String getNotesLink(Model model){
        model.addAttribute("notes", noteService.getAllModels());
        return "getNotes";
    }

    @PostMapping("/addNote")
    public String addNote(@RequestParam String title, @RequestParam String note, Model model) throws IOException {
        if( !note.isEmpty() || !note.equals("")) {
            noteService.add(title, note);
        } else {
            throw new IOException("Поле заметки не должно быть пустым!");
        }
        return "redirect:/getNotes";
    }

    @GetMapping(value = "/remove/{id}")
    public String remove(@PathVariable Long id, Model model){
        noteService.remove(id);
        return "redirect:/getNotes";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String filter, Model model){
        if(filter !=null && !filter.isEmpty()){
            model.addAttribute("notes", noteService.getModelsByFilter(filter));
            model.addAttribute("st", "Выполненно!");
            return "getNotes";
        } else {
            model.addAttribute("notes", noteService.getAllModels());
            return "getNotes";
        }
    }
}
