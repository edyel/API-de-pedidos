package com.example.PedidosAPI.pedido;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Table(name = "pedidos")
@Entity(name = "Pedido")
@EqualsAndHashCode(of = "id")
public class Pedido {

	@Id
	private Long id;
	private BigDecimal valorTotal;

	public Pedido() {

	}

	public Pedido(Long id, BigDecimal valorTotal) {
		this.id = id;
		this.valorTotal = valorTotal;
	}

}
