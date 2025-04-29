package com.cursoAPI.cursos.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class InscricaoDTO {
    private Long id;

    @NotNull(message = "Curso é obrigatório")
    private Long cursoId;

    @NotNull(message = "Aluno é obrigatório")
    private Long alunoId;

    @NotNull(message = "Data é obrigatória")
    private LocalDate dataInscricao;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCursoId() { return cursoId; }
    public void setCursoId(Long cursoId) { this.cursoId = cursoId; }
    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }
    public LocalDate getDataInscricao() { return dataInscricao; }
    public void setDataInscricao(LocalDate dataInscricao) { this.dataInscricao = dataInscricao; }
}