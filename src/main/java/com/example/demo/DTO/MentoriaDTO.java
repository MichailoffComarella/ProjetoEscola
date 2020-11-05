package com.example.demo.DTO;

import com.example.demo.model.Aluno;
import com.example.demo.model.Mentor;
import com.example.demo.model.Mentoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
public class MentoriaDTO {

    private Long id;
    private Aluno aluno;
    private Mentor mentor;
    private Boolean active;

    public Mentoria mentoriaObejto() {
        return new Mentoria(this.getId(), this.getAluno(), this.getMentor(), this.getActive());
    }

    public static MentoriaDTO mentoriaDTO(Mentoria mentoria) {
        return new MentoriaDTO(mentoria.getId(), mentoria.getAluno(), mentoria.getMentor(), mentoria.getActive());
    }

}
