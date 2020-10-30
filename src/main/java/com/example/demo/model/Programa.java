package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Data
public class Programa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String ano;

    @Column
    private Boolean active;

    public Programa(String nome, String ano, Boolean active) {
        this.nome = nome;
        this.ano = ano;
        this.active = active;
    }
}
