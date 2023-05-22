package com.example.PedidosAPI.produto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProduto(
		@NotBlank
		String nome, 
		@NotNull
		BigDecimal valor, 
		String descricao, 
		Categoria categoria) {

}
