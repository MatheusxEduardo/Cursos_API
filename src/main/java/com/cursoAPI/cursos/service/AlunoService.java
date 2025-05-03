package com.cursoAPI.cursos.service;

import com.cursoAPI.cursos.dto.AlunoDTO;
import com.cursoAPI.cursos.mapper.AlunoMapper;
import com.cursoAPI.cursos.model.Aluno;
import com.cursoAPI.cursos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoMapper alunoMapper;

    public AlunoDTO criarAluno(AlunoDTO alunoDTO) {
        Aluno aluno = alunoMapper.toEntity(alunoDTO);
        aluno = alunoRepository.save(aluno);
        return alunoMapper.toDTO(aluno);
    }

    public Optional<AlunoDTO> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id)
                .map(alunoMapper::toDTO);
    }

    public List<AlunoDTO> listarAlunos() {
        return alunoRepository.findAll()
                .stream()
                .map(alunoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AlunoDTO> atualizarAluno(Long id, AlunoDTO alunoDTO) {
        return alunoRepository.findById(id)
                .map(aluno -> {
                    aluno.setNome(alunoDTO.getNome());
                    aluno.setEmail(alunoDTO.getEmail());
                    aluno = alunoRepository.save(aluno);
                    return alunoMapper.toDTO(aluno);
                });
    }

    public boolean deletarAluno(Long id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}