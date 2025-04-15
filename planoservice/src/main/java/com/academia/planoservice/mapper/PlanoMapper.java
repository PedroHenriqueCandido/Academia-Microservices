package com.academia.planoservice.mapper;

import com.academia.planoservice.DTO.PlanoRequestDTO;
import com.academia.planoservice.DTO.PlanoResponseDTO;
import com.academia.planoservice.models.Plano;

public class PlanoMapper {

	public static Plano toEntity(PlanoRequestDTO dto) {
		return new Plano(dto.getNome(), dto.getDescricao(), dto.getPrecoMensal(), dto.getLimiteUsuarios(), true);
	}

	public static PlanoResponseDTO toDTO(Plano plano) {
		return new PlanoResponseDTO(plano.getId(), plano.getNome(), plano.getDescricao(), plano.getPrecoMensal(),
				plano.getLimiteUsuarios(), plano.getAtivo());
	}
}
