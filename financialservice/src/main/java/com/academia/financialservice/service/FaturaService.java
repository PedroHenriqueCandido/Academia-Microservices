package com.academia.financialservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.financialservice.model.Fatura;
import com.academia.financialservice.repository.FaturaRepository;

@Service
public class FaturaService {
	@Autowired
	private final FaturaRepository faturaRepository;

    
    public FaturaService(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    public Fatura salvar(Fatura fatura) {
        return faturaRepository.save(fatura);
    }

    public List<Fatura> buscarPorAluno(Long idAluno) {
        return faturaRepository.findByIdAluno(idAluno);
    }

    public List<Fatura> listarTodas() {
        return faturaRepository.findAll();
    }
}
