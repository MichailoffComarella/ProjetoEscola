package com.example.demo.DTO;

import com.example.demo.model.Programa;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
public class ProgramaDTO {

    private Long id;
    private String nome;
    private String ano;

    public Programa programaObjeto() {
        return new Programa(id, nome, ano);
    }

    public static ProgramaDTO programaDTO(Programa programa) {
        return new ProgramaDTO(programa.getId(), programa.getAno(), programa.getNome());
    }
}
