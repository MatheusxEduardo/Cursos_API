package com.cursoAPI.cursos.mapper;

import com.cursoAPI.cursos.dto.CursoDTO;
import com.cursoAPI.cursos.model.Curso;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CursoMapper {
    CursoDTO toDTO(Curso curso);
    Curso toEntity(CursoDTO cursoDTO);
}