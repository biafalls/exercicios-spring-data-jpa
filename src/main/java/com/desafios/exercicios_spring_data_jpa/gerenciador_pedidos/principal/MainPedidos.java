package com.desafios.exercicios_spring_data_jpa.gerenciador_pedidos.principal;

import com.desafios.exercicios_spring_data_jpa.gerenciador_pedidos.models.Categoria;
import com.desafios.exercicios_spring_data_jpa.gerenciador_pedidos.models.Pedido;
import com.desafios.exercicios_spring_data_jpa.gerenciador_pedidos.models.Produto;
import com.desafios.exercicios_spring_data_jpa.gerenciador_pedidos.repository.CategoriaRepository;
import com.desafios.exercicios_spring_data_jpa.gerenciador_pedidos.repository.PedidoRepository;
import com.desafios.exercicios_spring_data_jpa.gerenciador_pedidos.repository.ProdutoRepository;

import java.time.LocalDate;

public class MainPedidos {
    private ProdutoRepository produtoRepositorio;
    private PedidoRepository pedidoRepositorio;
    private CategoriaRepository categoriaRepositorio;

    public MainPedidos(ProdutoRepository produtoRepositorio,
                       PedidoRepository pedidoRepositorio,
                       CategoriaRepository categoriaRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
        this.pedidoRepositorio = pedidoRepositorio;
        this.categoriaRepositorio = categoriaRepositorio;
    }

    public void exibirMenu() {
        Produto produto1 = new Produto("Televisão", 1299.99);
        Categoria categoria1 = new Categoria(1L,"Eletrônicos");
        Pedido pedido1 = new Pedido(1L, LocalDate.now());

        produtoRepositorio.save(produto1);
        categoriaRepositorio.save(categoria1);
        pedidoRepositorio.save(pedido1);

    }
}
