package com.cursoAPI.cursos.mapper;

import com.cursoAPI.cursos.dto.InscricaoDTO;
import com.cursoAPI.cursos.model.Inscricao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InscricaoMapper {
    @Mapping(source = "curso.id", target = "cursoId")
    @Mapping(source = "aluno.id", target = "alunoId")
    InscricaoDTO toDTO(Inscricao inscricao);

    @Mapping(source = "cursoId", target = "curso.id")
    @Mapping(source = "alunoId", target = "aluno.id")
    Inscricao toEntity(InscricaoDTO inscricaoDTO);
}