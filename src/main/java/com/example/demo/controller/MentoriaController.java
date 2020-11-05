package com.example.demo.controller;

import com.example.demo.DTO.MentorDTO;
import com.example.demo.DTO.MentoriaDTO;
import com.example.demo.service.MentoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mentoria")
public class MentoriaController {

    @Autowired
    private MentoriaService mentoriaService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<MentoriaDTO>> getMentorias (@RequestParam Optional<String> active) {
        return new ResponseEntity<List<MentoriaDTO>>(mentoriaService.getMentorias(active.orElseGet(() -> "todos")), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MentoriaDTO> getMentorias (@PathVariable Long id) {
        return ResponseEntity.ok(mentoriaService.getMentoriaByIndex(id));
    }

    @PostMapping
    public ResponseEntity<MentoriaDTO> salvar(@RequestBody MentoriaDTO dto) {
        mentoriaService.criarMentoria(dto);
        return ResponseEntity.created(URI.create("/mentoria/" + dto.getId())).build();
    }

    @DeleteMapping("/{id}")
    public void removerMentoria (@PathVariable ("id") Long id) {
        mentoriaService.remover(Long.valueOf(id));
    }

}

