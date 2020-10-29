package com.example.demo.controller;

import com.example.demo.model.Programa;
import com.example.demo.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programa")
public class ProgramaController {

    @Autowired
    private ProgramaService programaService;

    @GetMapping
    public ResponseEntity<List<String>> getProgramas() {
        return new ResponseEntity<List<String>>(programaService.getProgramas(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getProgramas(@PathVariable Long id) {
        return ResponseEntity.ok(programaService.getProgramaByIndex(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> criarPrograma(@RequestBody Programa programa) {
        programaService.criaPrograma(programa);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void removerAluno (@PathVariable("id") Long id) {
        programaService.remover(Long.valueOf(id));
    }
}
