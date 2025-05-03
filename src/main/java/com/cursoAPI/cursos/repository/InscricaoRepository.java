package com.cursoAPI.cursos.repository;

import com.cursoAPI.cursos.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
}