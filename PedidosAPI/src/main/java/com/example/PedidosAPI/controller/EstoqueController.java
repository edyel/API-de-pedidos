package com.example.PedidosAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PedidosAPI.estoque.DadosRegistroEstoque;
import com.example.PedidosAPI.estoque.Estoque;
import com.example.PedidosAPI.estoque.EstoqueRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
	
	@Autowired
	private EstoqueRepository repository;
	
	@PostMapping
	@Transactional
	public void registrar(@RequestBody @Valid DadosRegistroEstoque estoque) {
		repository.save(new Estoque(estoque));
	}

}
