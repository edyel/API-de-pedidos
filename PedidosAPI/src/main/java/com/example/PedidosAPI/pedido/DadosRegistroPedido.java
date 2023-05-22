package com.example.PedidosAPI.pedido;

import java.util.List;

import com.example.PedidosAPI.produto.*;

public record DadosRegistroPedido(Long id, List<DadosListaProduto> produtos) {

}
