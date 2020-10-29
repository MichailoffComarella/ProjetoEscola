package com.example.demo.DTO;

import com.example.demo.model.Mentor;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
public class MentorDTO {

    private Long id;
    private String name;
    private String pais;

    public Mentor mentorObjeto() {
        return new Mentor(name, pais);
    }

    public static MentorDTO mentorDTO(Mentor mentor) {
        return new MentorDTO(mentor.getId(), mentor.getName(), mentor.getPais());
    }
}
