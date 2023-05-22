package com.example.PedidosAPI.produto;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "catalogo_produtos")
@Entity(name = "Produto")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal valor;
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	public Produto(DadosCadastroProduto produto) {
		this.nome = produto.nome();
		this.valor = produto.valor();
		this.descricao = produto.descricao();
		this.categoria = produto.categoria();
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", valor=" + valor + ", descricao=" + descricao + ", categoria="
				+ categoria + "]";
	}

}
