package com.cursoAPI.cursos.mapper;

import com.cursoAPI.cursos.dto.AlunoDTO;
import com.cursoAPI.cursos.model.Aluno;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlunoMapper {
    AlunoDTO toDTO(Aluno aluno);
    Aluno toEntity(AlunoDTO alunoDTO);
}