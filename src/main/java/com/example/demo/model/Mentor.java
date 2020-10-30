package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Getter
@NoArgsConstructor
public class Mentor {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String pais;

    @Column
    private Boolean active;

    public Mentor(String nome, String cpf, String pais, Boolean active) {
        this.nome = nome;
        this.cpf = cpf;
        this.pais = pais;
        this.active = active;
    }
}
