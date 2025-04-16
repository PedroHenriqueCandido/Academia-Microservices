package com.academia.financialservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.financialservice.model.Fatura;
import com.academia.financialservice.service.FaturaService;

@RestController
@RequestMapping("/faturas")
public class FaturaController {

	@Autowired
    private final FaturaService faturaService;

 
    public FaturaController(FaturaService faturaService) {
        this.faturaService = faturaService;
    }

    @PostMapping
    public Fatura criarFatura(@RequestBody Fatura fatura) {
        return faturaService.salvar(fatura);
    }

    @GetMapping("/aluno/{id}")
    public List<Fatura> buscarPorAluno(@PathVariable("id") Long idAluno) {
        return faturaService.buscarPorAluno(idAluno);
    }

    @GetMapping
    public List<Fatura> listarTodas() {
        return faturaService.listarTodas();
    }
}