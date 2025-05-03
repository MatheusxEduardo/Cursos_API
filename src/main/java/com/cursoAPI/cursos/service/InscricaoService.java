package com.cursoAPI.cursos.service;

import com.cursoAPI.cursos.dto.InscricaoDTO;
import com.cursoAPI.cursos.mapper.InscricaoMapper;
import com.cursoAPI.cursos.model.Inscricao;
import com.cursoAPI.cursos.repository.AlunoRepository;
import com.cursoAPI.cursos.repository.CursoRepository;
import com.cursoAPI.cursos.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private InscricaoMapper inscricaoMapper;

    public InscricaoDTO criarInscricao(InscricaoDTO inscricaoDTO) {
        Inscricao inscricao = inscricaoMapper.toEntity(inscricaoDTO);
        inscricao.setDataInscricao(LocalDate.now());
        inscricao = inscricaoRepository.save(inscricao);
        return inscricaoMapper.toDTO(inscricao);
    }

    public Optional<InscricaoDTO> buscarInscricaoPorId(Long id) {
        return inscricaoRepository.findById(id)
                .map(inscricaoMapper::toDTO);
    }

    public List<InscricaoDTO> listarInscricoes() {
        return inscricaoRepository.findAll()
                .stream()
                .map(inscricaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public boolean deletarInscricao(Long id) {
        if (inscricaoRepository.existsById(id)) {
            inscricaoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}