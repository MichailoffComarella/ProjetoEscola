package com.example.demo.service;

import com.example.demo.DTO.MentoriaDTO;
import com.example.demo.DTO.mapper.MentoriaMapper;
import com.example.demo.model.Mentoria;
import com.example.demo.repository.MentoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MentoriaService {

    @Autowired
    private MentorService mentorService;

    @Autowired
    private AlunoService alunoService;

    private MentoriaRepository mentoriaRepository;

    public List<MentoriaDTO> getMentorias(String active) {

        List<Mentoria> mentorias = (List<Mentoria>) mentoriaRepository.findAll();

        List<MentoriaDTO> mentoriasDTO = new ArrayList<>();

        List<MentoriaDTO> mentoriasAtivas = new ArrayList<>();

        List<MentoriaDTO> mentoriasInativas = new ArrayList<>();

        for (Mentoria mentoria: mentorias) {
            MentoriaDTO newMentoriaDTO = new MentoriaDTO();

            newMentoriaDTO.setId(mentoria.getId());
            newMentoriaDTO.setAluno(mentoria.getAluno());
            newMentoriaDTO.setMentor(mentoria.getMentor());
            newMentoriaDTO.setActive(mentoria.getActive());

            mentoriasDTO.add(newMentoriaDTO);

            if (newMentoriaDTO.getActive() == true) {
                mentoriasAtivas.add(newMentoriaDTO);
            } else {
                mentoriasInativas.add(newMentoriaDTO);
            }
        }

        if (active.equals("ativos")) {
            return mentoriasAtivas;
        } else if (active.equals("inativos")) {
            return mentoriasInativas;
        } else {
            return mentoriasDTO;
        }
    }

    @Autowired
    public MentoriaService(MentoriaRepository mentoriaRepository) {
        this.mentoriaRepository = mentoriaRepository;
    }

    public Mentoria salvar(Mentoria mentoria) {
        return mentoriaRepository.save(mentoria);
    }

    public MentoriaDTO getMentoriaByIndex(Long id) {
        Mentoria mentoria = mentoriaRepository.findById(id).orElse(null);

        MentoriaDTO mentoriaDTO = new MentoriaDTO();

        mentoriaDTO.setId(mentoria.getId());
        mentoriaDTO.setAluno(mentoria.getAluno());
        mentoriaDTO.setMentor(mentoria.getMentor());
        mentoriaDTO.setActive(mentoria.getActive());

        return mentoriaDTO;
    }

    public MentoriaDTO criarMentoria (MentoriaDTO mentoriaDTO) {
        Mentoria mentoria = MentoriaMapper.toMentoria(mentoriaDTO);
        Mentoria savedMentoria = mentoriaRepository.save(mentoria);

        return MentoriaMapper.toMentoriaDTO(savedMentoria);
    }

    @Transactional
    public void remover(Long id) {
        Mentoria one = mentoriaRepository.findById(id).orElse(null);
        one.setActive(false);
        mentoriaRepository.save(one);
    }

}
