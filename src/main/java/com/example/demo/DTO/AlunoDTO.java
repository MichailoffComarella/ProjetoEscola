package com.example.demo.DTO;

import com.example.demo.model.Aluno;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
public class AlunoDTO {

    private Long id;
    private String nome;
    private String CPF;
    private String classe;
    private int idade;
    private String pais;
    private Boolean active;


    public Aluno alunoObjeto() {
        return new Aluno(this.getNome(), this.getClasse(), this.getCPF(), this.getIdade(), this.getPais(), this.getActive());
    }

    public static AlunoDTO alunoDTO(Aluno aluno) {
        return new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getCPF(), aluno.getClasse(), aluno.getIdade(),
                aluno.getPais(), aluno.getActive());
    }
}
