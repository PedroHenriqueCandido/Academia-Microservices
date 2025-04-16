package com.academia.presencaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.presencaservice.model.Presenca;
import com.academia.presencaservice.service.PresencaService;

@RestController
@RequestMapping("/presencas")
public class PresencaController {

    @Autowired
    private PresencaService presencaService;

    @PostMapping
    public Presenca registrarPresenca(@RequestBody Presenca presenca) {
        return presencaService.registrarPresenca(presenca);
    }

    @GetMapping("/aluno/{id}")
    public List<Presenca> listarPorAluno(@PathVariable Long id) {
        return presencaService.listarPorAluno(id);
    }

    @GetMapping
    public List<Presenca> listarTodas() {
        return presencaService.listarTodas();
    }
}