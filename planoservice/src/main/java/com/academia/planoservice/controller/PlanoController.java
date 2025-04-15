package com.academia.planoservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.planoservice.DTO.PlanoRequestDTO;
import com.academia.planoservice.DTO.PlanoResponseDTO;
import com.academia.planoservice.service.PlanoService;

@RestController
@RequestMapping("/planos")
public class PlanoController {

	private final PlanoService planoService;

	public PlanoController(PlanoService planoService) {
		this.planoService = planoService;
	}

	@PostMapping
	public ResponseEntity<PlanoResponseDTO> criar(@RequestBody PlanoRequestDTO dto) {
		return ResponseEntity.ok(planoService.criarPlano(dto));
	}

	@GetMapping
	public ResponseEntity<List<PlanoResponseDTO>> listarTodos() {
		return ResponseEntity.ok(planoService.listarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PlanoResponseDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(planoService.buscarPorId(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<PlanoResponseDTO> atualizar(@PathVariable Long id, @RequestBody PlanoRequestDTO dto) {
		return ResponseEntity.ok(planoService.atualizarPlano(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		planoService.deletarPlano(id);
		return ResponseEntity.noContent().build();
	}
}
