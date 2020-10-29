package com.example.demo.service;

import com.example.demo.model.Mentor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MentorService {

    private List<String> mentores = new ArrayList<>(List.of("Xavier", "Alvo Dumbledore", "Minerva McGonagall"));

    public List<String> getMentores() {
        System.out.println("Teste");
        return mentores;
    }

    public String getMentoresByIndex(Long id) {
        return mentores.get(id.intValue());
    }

    public void criarMentor(Mentor mentor) {
        mentores.add(mentor.getName());
    }

    public void remover(Long id) {
        mentores.remove(id.intValue());
    }
}
