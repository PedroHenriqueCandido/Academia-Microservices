package com.academia.financialservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.financialservice.model.Fatura;

public interface FaturaRepository extends JpaRepository<Fatura, Long>{
	 List<Fatura> findByIdAluno(Long idAluno);
}
