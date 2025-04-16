package com.academia.presencaservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.presencaservice.model.Presenca;

public interface PresencaRepository extends JpaRepository<Presenca, Long> {
	 List<Presenca> findByIdAluno(Long idAluno);
}
