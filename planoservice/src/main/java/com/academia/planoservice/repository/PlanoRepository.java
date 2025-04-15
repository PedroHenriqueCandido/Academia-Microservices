package com.academia.planoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.planoservice.models.Plano;

public interface PlanoRepository extends JpaRepository<Plano ,Long> {

}
