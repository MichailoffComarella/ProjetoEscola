package com.example.demo.controller;

import com.example.demo.model.Mentor;
import com.example.demo.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @GetMapping
    public ResponseEntity<List<String>> getMentores() {
        return new ResponseEntity<List<String>>(mentorService.getMentores(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getMentores(@PathVariable Long id) {
        return ResponseEntity.ok(mentorService.getMentoresByIndex(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> criarMentor(@RequestBody Mentor mentor) {
        mentorService.criarMentor(mentor);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void removerAluno (@PathVariable("id") Long id) {
        mentorService.remover(Long.valueOf(id));
    }
}
