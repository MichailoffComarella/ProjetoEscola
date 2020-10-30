package com.example.demo.controller;

import com.example.demo.DTO.AlunoDTO;
import com.example.demo.model.Aluno;
import com.example.demo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<AlunoDTO>> getAlunos(@RequestParam Optional<String> active) {
        return new ResponseEntity<List<AlunoDTO>>(alunoService.getAlunos(active.orElseGet(() -> "todos")), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> getAluno(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.getAlunoByIndex(id));
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> salvar(@RequestBody AlunoDTO dto) {
        alunoService.criarAluno(dto);
        return ResponseEntity.created(URI.create("/aluno/" +dto.getId())).build();
    }

    @DeleteMapping("/{id}")
    public void removerAluno (@PathVariable("id") Long id) {
        alunoService.remover(Long.valueOf(id));
    }

}
