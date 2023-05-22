package com.example.PedidosAPI.estoque;

import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;

@Table(name = "estoque")
@Entity(name = "Estoque")
@EqualsAndHashCode(of = "idproduto")
public class Estoque {
	@Id
	@NotNull
	private Long idProduto;
	@NotNull
	private BigInteger quantidade;

	public Estoque() {

	}

	public Estoque(DadosRegistroEstoque dados) {
		this.idProduto = dados.idProduto();
		this.quantidade = dados.quantidade();
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public BigInteger getQuantidade() {
		return quantidade;
	}

	@Override
	public String toString() {
		return " id = " + this.idProduto + " - quantidade Em estoque: " + this.quantidade;
	}
}
