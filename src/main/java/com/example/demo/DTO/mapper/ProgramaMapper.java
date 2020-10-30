package com.example.demo.DTO.mapper;

import com.example.demo.DTO.ProgramaDTO;
import com.example.demo.model.Programa;

public class ProgramaMapper {

    public static Programa toPrograma (ProgramaDTO programaDTO) {
        Programa programa = new Programa(programaDTO.getNome(), programaDTO.getAno(),
                programaDTO.getActive());
        programa.setActive(programaDTO.getActive());
        programa.setId(programaDTO.getId());

        return programa;
    }

    public static ProgramaDTO toProgramaDTO (Programa programa) {
        return new ProgramaDTO(programa.getId(), programa.getNome(), programa.getAno(),
                programa.getActive());
    }

}
