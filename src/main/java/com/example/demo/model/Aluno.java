package com.example.demo.model;

import com.example.demo.DTO.AlunoDTO;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Data
public class Aluno {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String CPF;
    private String classe;
    private int idade;
    private String pais;


    @Column
    private Boolean active;

    public Aluno(String nome, String CPF, String classe, int idade, String pais, Boolean active) {
        this.nome = nome;
        this.classe = classe;
        this.CPF = CPF;
        this.idade = idade;
        this.pais = pais;
        this.active = active;
    }


}
