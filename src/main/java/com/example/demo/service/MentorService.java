package com.example.demo.service;

import com.example.demo.DTO.MentorDTO;
import com.example.demo.DTO.mapper.MentorMapper;
import com.example.demo.model.Aluno;
import com.example.demo.model.Mentor;
import com.example.demo.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MentorService {

    @Autowired
    private AlunoService alunoService;

    private MentorRepository mentorRepository;

    public List<MentorDTO> getMentores(String active) {

        List<Mentor> mentores = (List<Mentor>) mentorRepository.findAll();

        List<MentorDTO> mentoresDTO = new ArrayList<>();

        List<MentorDTO> mentoresAtivos = new ArrayList<>();

        List<MentorDTO> mentoresInativos = new ArrayList<>();

        for (Mentor mentor: mentores) {
            MentorDTO newMentorDTO = new MentorDTO();

            newMentorDTO.setActive(mentor.getActive());
            newMentorDTO.setCpf(mentor.getCpf());
            newMentorDTO.setId(mentor.getId());
            newMentorDTO.setNome(mentor.getNome());
            newMentorDTO.setPais(mentor.getPais());

            mentoresDTO.add(newMentorDTO);

            if (newMentorDTO.getActive() == true) {
                mentoresAtivos.add(newMentorDTO);
            } else {
                mentoresInativos.add(newMentorDTO);
            }

        }

        if (active.equals("ativos")) {
            return mentoresAtivos;
        } else if (active.equals("inativos")) {
            return mentoresInativos;
        } else {
            return mentoresDTO;
        }

    }

    @Autowired
    public MentorService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public Mentor salvar(Mentor mentor){
        return mentorRepository.save(mentor);
    }

    public MentorDTO getMentorByIndex(Long id) {
        Mentor mentor = mentorRepository.findById(id).orElse(null);
        MentorDTO newMentorDTO = new MentorDTO();

        newMentorDTO.setActive(mentor.getActive());
        newMentorDTO.setCpf(mentor.getCpf());
        newMentorDTO.setId(mentor.getId());
        newMentorDTO.setNome(mentor.getNome());
        newMentorDTO.setPais(mentor.getPais());

        return newMentorDTO;
    }

    public MentorDTO criarMentor(MentorDTO mentorDTO) {
        Mentor mentor = MentorMapper.toMentor(mentorDTO);
        Mentor savedMentor = mentorRepository.save(mentor);

        return MentorMapper.toMentorDTO(savedMentor);
    }

    @Transactional
    public void remover(Long id) {
        Mentor one = mentorRepository.findById(id).orElse(null);
        one.setActive(false);
        mentorRepository.save(one);
    }
}
