package com.cursoAPI.cursos.service;

import com.cursoAPI.cursos.dto.CursoDTO;
import com.cursoAPI.cursos.mapper.CursoMapper;
import com.cursoAPI.cursos.model.Curso;
import com.cursoAPI.cursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoMapper cursoMapper;

    public CursoDTO criarCurso(CursoDTO cursoDTO) {
        Curso curso = cursoMapper.toEntity(cursoDTO);
        curso = cursoRepository.save(curso);
        return cursoMapper.toDTO(curso);
    }

    public Optional<CursoDTO> buscarCursoPorId(Long id) {
        return cursoRepository.findById(id)
                .map(cursoMapper::toDTO);
    }

    public List<CursoDTO> listarCursos() {
        return cursoRepository.findAll()
                .stream()
                .map(cursoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CursoDTO> atualizarCurso(Long id, CursoDTO cursoDTO) {
        return cursoRepository.findById(id)
                .map(curso -> {
                    curso.setNome(cursoDTO.getNome());
                    curso.setDescricao(cursoDTO.getDescricao());
                    curso.setCargaHoraria(cursoDTO.getCargaHoraria());
                    curso = cursoRepository.save(curso);
                    return cursoMapper.toDTO(curso);
                });
    }

    public boolean deletarCurso(Long id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}