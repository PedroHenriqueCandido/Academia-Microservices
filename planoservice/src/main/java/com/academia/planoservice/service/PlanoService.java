package com.academia.planoservice.service;

import java.util.List;

import com.academia.planoservice.DTO.PlanoRequestDTO;
import com.academia.planoservice.DTO.PlanoResponseDTO;

public interface PlanoService {

	PlanoResponseDTO criarPlano(PlanoRequestDTO dto);

    PlanoResponseDTO buscarPorId(Long id);

    List<PlanoResponseDTO> listarTodos();

    PlanoResponseDTO atualizarPlano(Long id, PlanoRequestDTO dto);

    void deletarPlano(Long id);
}
