package com.example.holistitimeapi.logic;

import com.example.holistitimeapi.model.Note;
import com.example.holistitimeapi.model.NoteRepository;
import com.example.holistitimeapi.model.projection.NoteResponse;
import com.example.holistitimeapi.user.User;
import com.example.holistitimeapi.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final UserRepository userRepository;
    private final NoteRepository noteRepository;

    public Note createNoteForUser(String userEmail, Note note) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        note.setUser(user);
        return noteRepository.save(note);
    }

    public void deleteNoteById(int noteId) {
        noteRepository.deleteById(noteId);
    }

    public List<Note> getAllNotesForUser(String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return noteRepository.findByUser(user);
    }

    public NoteResponse mapToNoteResponse(Note note) {
        return NoteResponse.builder()
            .id(note.getId())
            .content(note.getContent())
            .build();
    }
}

