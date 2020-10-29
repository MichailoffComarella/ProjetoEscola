package com.example.demo.service;

import com.example.demo.model.Programa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgramaService {

    private List<String> programas = new ArrayList<>(List.of("1º ano", "2º ano", "3ão",
            "Faculdade", "Estágio"));

    public List<String> getProgramas() {
        System.out.println("Teste");
        return programas;
    }

    public String getProgramaByIndex (Long id) {
        return programas.get(id.intValue());
    }

    public void criaPrograma(Programa programa){
        programas.add(programa.getNome());
    }

    public void remover(Long id) {
        programas.remove(id.intValue());
    }
}
