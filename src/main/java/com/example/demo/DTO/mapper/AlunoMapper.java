package com.example.demo.DTO.mapper;

import com.example.demo.DTO.AlunoDTO;
import com.example.demo.model.Aluno;

public class AlunoMapper {

    public static Aluno toAluno(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno(alunoDTO.getNome(), alunoDTO.getCPF(), alunoDTO.getClasse(), alunoDTO.getIdade(), alunoDTO.getPais(), alunoDTO.getActive());
        aluno.setId(alunoDTO.getId());
        aluno.setActive(alunoDTO.getActive());

        return aluno;
    }

    public static AlunoDTO toAlunoDTO(Aluno aluno){
        return new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getClasse(), aluno.getCPF(), aluno.getIdade(), aluno.getPais(), aluno.getActive());
    }
}
