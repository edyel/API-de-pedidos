package com.example.PedidosAPI.produto;

import java.math.BigDecimal;
import java.math.BigInteger;

public record DadosListaProduto(Long id, BigDecimal valor, BigInteger quantidade) {

}
