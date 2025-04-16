package com.academia.academiaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.academiaservice.model.Academia;

public interface AcademiaRepository extends JpaRepository<Academia, Long> {

}
