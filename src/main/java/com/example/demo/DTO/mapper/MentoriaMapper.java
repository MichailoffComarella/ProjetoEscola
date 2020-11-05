package com.example.demo.DTO.mapper;

import com.example.demo.DTO.MentoriaDTO;
import com.example.demo.model.Mentoria;

public class MentoriaMapper {

    public static Mentoria toMentoria(MentoriaDTO mentoriaDTO) {
        Mentoria mentoria = new Mentoria(mentoriaDTO.getId(), mentoriaDTO.getAluno(), mentoriaDTO.getMentor(), mentoriaDTO.getActive());
        mentoria.setId(mentoriaDTO.getId());
        mentoria.setActive(mentoriaDTO.getActive());

        return mentoria;
    }

    public static MentoriaDTO toMentoriaDTO(Mentoria mentoria){
        return new MentoriaDTO(mentoria.getId(), mentoria.getAluno(), mentoria.getMentor(), mentoria.getActive());
    }

}
