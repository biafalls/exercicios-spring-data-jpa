package com.desafios.exercicios_spring_data_jpa.gerenciador_pedidos.repository;

import com.desafios.exercicios_spring_data_jpa.gerenciador_pedidos.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
