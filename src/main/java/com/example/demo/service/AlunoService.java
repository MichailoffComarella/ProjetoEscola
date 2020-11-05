package com.example.demo.service;

import com.example.demo.DTO.AlunoDTO;
import com.example.demo.DTO.mapper.AlunoMapper;
import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private MentorService mentorService;

    private AlunoRepository alunoRepository;
    
    public List<AlunoDTO> getAlunos(String active) {

        List<Aluno> alunos = (List<Aluno>) alunoRepository.findAll();

        List<AlunoDTO> alunosDTO = new ArrayList<>();

        List <AlunoDTO> alunosAtivos = new ArrayList<>();

        List <AlunoDTO> alunosInativos = new ArrayList<>();

        for (Aluno aluno: alunos) {
            AlunoDTO newAlunoDTO = new AlunoDTO();

            newAlunoDTO.setNome(aluno.getNome());
            newAlunoDTO.setId(aluno.getId());
            newAlunoDTO.setPais(aluno.getPais());
            newAlunoDTO.setIdade(aluno.getIdade());
            newAlunoDTO.setCPF(aluno.getCPF());
            newAlunoDTO.setClasse(aluno.getClasse());
            newAlunoDTO.setActive(aluno.getActive());

            alunosDTO.add(newAlunoDTO);

            if (newAlunoDTO.getActive() == true) {
                alunosAtivos.add(newAlunoDTO);
            } else {
                alunosInativos.add(newAlunoDTO);
            }

        }

        if (active.equals("ativos")) {
            return alunosAtivos;
        } else if (active.equals("inativos")) {
            return alunosInativos;
        } else {
            return alunosDTO;
        }

    }


    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public AlunoDTO getAlunoByIndex(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElse(null);

        AlunoDTO alunoDTO = new AlunoDTO();

        alunoDTO.setId(aluno.getId());
        alunoDTO.setClasse(aluno.getClasse());
        alunoDTO.setNome(aluno.getNome());
        alunoDTO.setCPF(aluno.getCPF());
        alunoDTO.setIdade(aluno.getIdade());
        alunoDTO.setPais(aluno.getPais());
        alunoDTO.setActive(aluno.getActive());

        return alunoDTO;
    }

    public AlunoDTO criarAluno (AlunoDTO alunoDTO) {
        // Mentor mentor = mentorService.getById(alunoDTO.getMentorId());
        Aluno aluno = AlunoMapper.toAluno(alunoDTO);
        Aluno savedAluno = alunoRepository.save(aluno);

        return AlunoMapper.toAlunoDTO(savedAluno);
    }

    @Transactional
    public void remover(Long id) {
        Aluno one = alunoRepository.findById(id).orElse(null);
        one.setActive(false);
        alunoRepository.save(one);
    }


}
