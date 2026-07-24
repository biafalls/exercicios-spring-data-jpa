package com.desafios.exercicios_spring_data_jpa;

import com.desafios.exercicios_spring_data_jpa.aula1.MainAula1;
import com.desafios.exercicios_spring_data_jpa.gerenciador_pedidos.principal.MainPedidos;
import com.desafios.exercicios_spring_data_jpa.gerenciador_pedidos.repository.CategoriaRepository;
import com.desafios.exercicios_spring_data_jpa.gerenciador_pedidos.repository.PedidoRepository;
import com.desafios.exercicios_spring_data_jpa.gerenciador_pedidos.repository.ProdutoRepository;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExerciciosSpringDataJpaApplication implements CommandLineRunner {

	@Autowired
	private ProdutoRepository produtoRepositorio;

	@Autowired
	private PedidoRepository pedidoRepositorio;

	@Autowired
	private CategoriaRepository categoriaRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(ExerciciosSpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		MainAula1 aula1 = new MainAula1();
//		aula1.exibirMenu();

		MainPedidos gerenciadorPedidos = new MainPedidos(produtoRepositorio,
				pedidoRepositorio, categoriaRepositorio);
		gerenciadorPedidos.exibirMenu();
	}
}
