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
    private Boolean active;

    public Programa programaObjeto() {
        return new Programa(this.getNome(), this.getAno(), this.getActive());
    }

    public static ProgramaDTO programaDTO(Programa programa) {
        return new ProgramaDTO(programa.getId(), programa.getNome(), programa.getAno(), programa.getActive());
    }
}
