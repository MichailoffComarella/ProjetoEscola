package com.example.demo.service;

import com.example.demo.DTO.ProgramaDTO;
import com.example.demo.DTO.mapper.ProgramaMapper;
import com.example.demo.model.Programa;
import com.example.demo.repository.ProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProgramaService {

    private ProgramaRepository programaRepository;

    public List<ProgramaDTO> getProgramas(String active) {

        List<Programa> programas = (List<Programa>) programaRepository.findAll();

        List<ProgramaDTO> programasDTO = new ArrayList<>();

        List<ProgramaDTO> programasAtivos = new ArrayList<>();

        List<ProgramaDTO> programasInativos = new ArrayList<>();

        for (Programa programa: programas) {
            ProgramaDTO newProgramaDTO = new ProgramaDTO();

            newProgramaDTO.setNome(programa.getNome());
            newProgramaDTO.setAno(programa.getAno());
            newProgramaDTO.setId(programa.getId());
            newProgramaDTO.setActive(programa.getActive());

            programasDTO.add(newProgramaDTO);

            if (newProgramaDTO.getActive() == true) {
                programasAtivos.add(newProgramaDTO);
            } else {
                programasInativos.add(newProgramaDTO);
            }

        }

        if (active.equals("ativos")) {
            return programasAtivos;
        } else if (active.equals("inativos")) {
            return programasInativos;
        } else {
            return programasDTO;
        }

    }

    @Autowired
    public ProgramaService(ProgramaRepository programaRepository) {
        this.programaRepository = programaRepository;
    }

    public Programa salvar(Programa programa) {
        return programaRepository.save(programa);
    }

    public ProgramaDTO getProgramaByIndex (Long id) {
        Programa programa = programaRepository.findById(id).orElse(null);

        ProgramaDTO programaDTO = new ProgramaDTO();

        programaDTO.setNome(programa.getNome());
        programaDTO.setAno(programa.getAno());
        programaDTO.setId(programa.getId());
        programaDTO.setActive(programa.getActive());

        return programaDTO;
    }

    public ProgramaDTO criaPrograma(ProgramaDTO programaDTO){
        Programa programa = ProgramaMapper.toPrograma(programaDTO);
        Programa savedPrograma = programaRepository.save(programa);

        return ProgramaMapper.toProgramaDTO(savedPrograma);
    }

    @Transactional
    public void remover(Long id) {
        Programa one = programaRepository.findById(id).orElse(null);
        one.setActive(false);
        programaRepository.save(one);
    }
}
