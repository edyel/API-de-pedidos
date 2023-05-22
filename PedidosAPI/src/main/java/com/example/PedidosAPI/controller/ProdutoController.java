package com.example.PedidosAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PedidosAPI.produto.DadosCadastroProduto;
import com.example.PedidosAPI.produto.Produto;
import com.example.PedidosAPI.produto.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroProduto dadosProduto) {
	    repository.save(new Produto(dadosProduto));
	}


}
