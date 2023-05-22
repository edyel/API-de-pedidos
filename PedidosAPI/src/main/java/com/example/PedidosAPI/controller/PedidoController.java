package com.example.PedidosAPI.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PedidosAPI.estoque.DadosRegistroEstoque;
import com.example.PedidosAPI.estoque.Estoque;
import com.example.PedidosAPI.estoque.EstoqueRepository;
import com.example.PedidosAPI.pedido.DadosRegistroPedido;
import com.example.PedidosAPI.pedido.ItemPedido;
import com.example.PedidosAPI.pedido.ItemPedidoRepository;
import com.example.PedidosAPI.pedido.Pedido;
import com.example.PedidosAPI.pedido.PedidoRepository;
import com.example.PedidosAPI.produto.DadosListaProduto;
import com.example.PedidosAPI.service.ValidacaoEstoqueService;


@RestController
@RequestMapping("/pedido")
public class PedidoController {

	private ValidacaoEstoqueService validacao = new ValidacaoEstoqueService();
	@Autowired
	private PedidoRepository repository;
	@Autowired
	private EstoqueRepository estoqueRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
	@PostMapping
	@Transactional
	public void registra(@RequestBody DadosRegistroPedido dados) {
		boolean temNoEstoque = validacao.validaEstoque(dados.produtos(), estoqueRepository);
		if(temNoEstoque) {
			
			repository.save(new Pedido(dados.id(), somaValorTotal(dados)));
			rabbitTemplate.send("pedido.realizado", new Message(("Pedido criado! Numero do pedido: " + dados.id()).getBytes()));
			
			for (DadosListaProduto produto : dados.produtos()) {
				itemPedidoRepository.save(new ItemPedido(produto.valor(), produto.quantidade(), produto.id(), dados.id()));		
			}
		} else { 
			throw new RuntimeErrorException(null, "Estoque do produto insuficiente!");
		}
}
	
	public static BigDecimal somaValorTotal(DadosRegistroPedido listaDados) {
		BigDecimal total = BigDecimal.ZERO;
		for (DadosListaProduto produto : listaDados.produtos()) {
			total = total.add(produto.valor().multiply(new BigDecimal(produto.quantidade())));
		}
		return total;
	}
	

}
