package com.example.demo.DTO.mapper;

import com.example.demo.DTO.MentorDTO;
import com.example.demo.model.Mentor;

public class MentorMapper {

    public static Mentor toMentor(MentorDTO mentorDTO) {
        Mentor mentor = new Mentor(mentorDTO.getNome(), mentorDTO.getCpf(), mentorDTO.getPais(), mentorDTO.getActive());
        mentor.setId(mentorDTO.getId());
        mentor.setActive(mentorDTO.getActive());

        return mentor;
    }

    public static MentorDTO toMentorDTO(Mentor mentor){
        return new MentorDTO(mentor.getId(), mentor.getNome(), mentor.getCpf(), mentor.getPais(), mentor.getActive());
    }
}
