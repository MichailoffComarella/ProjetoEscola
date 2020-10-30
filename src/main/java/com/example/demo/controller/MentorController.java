package com.example.demo.controller;

import com.example.demo.DTO.MentorDTO;
import com.example.demo.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<MentorDTO>> getMentores(@RequestParam Optional<String> active) {
        return new ResponseEntity<List<MentorDTO>>(mentorService.getMentores(active.orElseGet(() -> "todos")), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MentorDTO> getMentores(@PathVariable Long id) {
        return ResponseEntity.ok(mentorService.getMentorByIndex(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> salvar(@RequestBody MentorDTO dto) {
        mentorService.criarMentor(dto);
        return ResponseEntity.created(URI.create("/mentor/" + dto.getId())).build();
    }

    @DeleteMapping("/{id}")
    public void removerAluno(@PathVariable("id") Long id) {
        mentorService.remover(Long.valueOf(id));
    }
}
