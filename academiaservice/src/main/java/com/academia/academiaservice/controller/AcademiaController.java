package com.academia.academiaservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.academiaservice.model.Academia;
import com.academia.academiaservice.service.AcademiaService;

@RestController
@RequestMapping("/academias")
public class AcademiaController {

	@Autowired
	private AcademiaService academiaService;
	
	@PostMapping
	public ResponseEntity<Academia> criarAcademia (@RequestBody Academia academia){
		Academia novaAcademia = academiaService.criarAcademia(academia);
		return new ResponseEntity<>(novaAcademia, HttpStatus.CREATED);
	}
	
	@GetMapping
    public ResponseEntity<List<Academia>> listarAcademias() {
        List<Academia> academias = academiaService.listarAcademias();
        return new ResponseEntity<>(academias, HttpStatus.OK);
    }

    // Buscar academia por ID
    @GetMapping("/{id}")
    public ResponseEntity<Academia> buscarAcademiaPorId(@PathVariable Long id) {
        Optional<Academia> academia = academiaService.buscarAcademiaPorId(id);
        return academia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar uma academia existente
    @PutMapping("/{id}")
    public ResponseEntity<Academia> atualizarAcademia(@PathVariable Long id, @RequestBody Academia academia) {
        try {
            Academia academiaAtualizada = academiaService.atualizarAcademia(id, academia);
            return new ResponseEntity<>(academiaAtualizada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Deletar uma academia
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAcademia(@PathVariable Long id) {
        try {
            academiaService.deletarAcademia(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
}
