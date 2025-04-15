package com.academia.planoservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.academia.planoservice.DTO.PlanoRequestDTO;
import com.academia.planoservice.DTO.PlanoResponseDTO;
import com.academia.planoservice.exception.RecursoNaoEncontradoException;
import com.academia.planoservice.mapper.PlanoMapper;
import com.academia.planoservice.models.Plano;
import com.academia.planoservice.repository.PlanoRepository;
import com.academia.planoservice.service.PlanoService;

@Service
public class PlanoServiceImpl implements PlanoService {

    private final PlanoRepository repository;

    public PlanoServiceImpl(PlanoRepository repository) {
        this.repository = repository;
    }

    @Override
    public PlanoResponseDTO criarPlano(PlanoRequestDTO dto) {
        Plano plano = PlanoMapper.toEntity(dto);
        return PlanoMapper.toDTO(repository.save(plano));
    }

    @Override
    public PlanoResponseDTO buscarPorId(Long id) {
        Plano plano = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Plano não encontrado com ID: " + id));
        return PlanoMapper.toDTO(plano);
    }

    @Override
    public List<PlanoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(PlanoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlanoResponseDTO atualizarPlano(Long id, PlanoRequestDTO dto) {
        Plano plano = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Plano não encontrado com ID: " + id));

        plano.setNome(dto.getNome());
        plano.setDescricao(dto.getDescricao());
        plano.setPrecoMensal(dto.getPrecoMensal());
        plano.setLimiteUsuarios(dto.getLimiteUsuarios());

        return PlanoMapper.toDTO(repository.save(plano));
    }

    @Override
    public void deletarPlano(Long id) {
        Plano plano = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Plano não encontrado com ID: " + id));
        repository.delete(plano);
    }
}
