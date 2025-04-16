package com.academia.academiaservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academia.academiaservice.model.Academia;
import com.academia.academiaservice.repository.AcademiaRepository;

@Service
public class AcademiaService {

	@Autowired
	private AcademiaRepository academiaRepository;
	
	@Transactional
	public Academia criarAcademia(Academia academia) {
		return academiaRepository.save(academia);
	}
	
	 public List<Academia> listarAcademias() {
	        return academiaRepository.findAll();
	    }

	    // Buscar Academia por ID
	    public Optional<Academia> buscarAcademiaPorId(Long id) {
	        return academiaRepository.findById(id);
	    }

	    // Atualizar Academia
	    @Transactional
	    public Academia atualizarAcademia(Long id, Academia academia) {
	        if (academiaRepository.existsById(id)) {
	            academia.setId(id);
	            return academiaRepository.save(academia);
	        } else {
	            throw new RuntimeException("Academia não encontrada para atualizar");
	        }
	    }

	    // Deletar Academia
	    @Transactional
	    public void deletarAcademia(Long id) {
	        if (academiaRepository.existsById(id)) {
	            academiaRepository.deleteById(id);
	        } else {
	            throw new RuntimeException("Academia não encontrada para deletar");
	        }
	    }
}
