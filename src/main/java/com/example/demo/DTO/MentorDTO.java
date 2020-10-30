package com.example.demo.DTO;

import com.example.demo.model.Mentor;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
public class MentorDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String pais;
    private Boolean active;

    public Mentor mentorObjeto() {
        return new Mentor(this.getNome(), this.getCpf(),
                this.getPais(), this.getActive());
    }

    public static MentorDTO mentorDTO(Mentor mentor) {
        return new MentorDTO(mentor.getId(), mentor.getNome(), mentor.getCpf(),
                mentor.getPais(), mentor.getActive());
    }
}
