package com.example.PedidosAPI.pedido;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.example.PedidosAPI.produto.Produto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal precoUnidade;
	private BigInteger quantidade;
	private Long produto_id;
	private Long pedido_id;

	public ItemPedido() {
		
	}

	public ItemPedido(BigDecimal precoUnidade, BigInteger quantidade, Long produto_id, Long pedido_id) {
		this.precoUnidade = precoUnidade;
		this.quantidade = quantidade;
		this.produto_id = produto_id;
		this.pedido_id = pedido_id;
	}
	
	
}
