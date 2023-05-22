package com.example.PedidosAPI.service;

import java.util.List;

import com.example.PedidosAPI.estoque.EstoqueRepository;
import com.example.PedidosAPI.produto.DadosListaProduto;

public class ValidacaoEstoqueService {
	
	public boolean validaEstoque(List<DadosListaProduto> produtos, EstoqueRepository estoque) {
			
		for (DadosListaProduto produto : produtos) {
			if(produto.quantidade().compareTo(estoque.getById(produto.id()).getQuantidade()) == 1) {
				return false;
			} 
		}
		
		return true;
	}

}
