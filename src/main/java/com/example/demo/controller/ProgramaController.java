package com.example.demo.controller;

import com.example.demo.DTO.ProgramaDTO;
import com.example.demo.model.Programa;
import com.example.demo.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/programa")
public class ProgramaController {

    @Autowired
    private ProgramaService programaService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ProgramaDTO>> getProgramas(@RequestParam Optional<String> active) {
        return new ResponseEntity<List<ProgramaDTO>>(programaService.getProgramas(active.orElseGet(() -> "todos")), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaDTO> getProgramas(@PathVariable Long id) {
       return ResponseEntity.ok(programaService.getProgramaByIndex(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> criarPrograma(@RequestBody ProgramaDTO dto) {
        programaService.criaPrograma(dto);
        return ResponseEntity.created(URI.create("/programa/" + dto.getId())).build();
    }

    @DeleteMapping("/{id}")
    public void removerAluno (@PathVariable("id") Long id) {
        programaService.remover(Long.valueOf(id));
    }
}
