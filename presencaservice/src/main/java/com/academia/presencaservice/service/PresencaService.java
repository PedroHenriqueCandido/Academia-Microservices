package com.academia.presencaservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.presencaservice.model.Presenca;
import com.academia.presencaservice.repository.PresencaRepository;

@Service
public class PresencaService {

	@Autowired
	private PresencaRepository presencaRepository;
	
	public Presenca registrarPresenca(Presenca presenca) {
        return presencaRepository.save(presenca);
    }

    public List<Presenca> listarPorAluno(Long idAluno) {
        return presencaRepository.findByIdAluno(idAluno);
    }

    public List<Presenca> listarTodas() {
        return presencaRepository.findAll();
    }
}
