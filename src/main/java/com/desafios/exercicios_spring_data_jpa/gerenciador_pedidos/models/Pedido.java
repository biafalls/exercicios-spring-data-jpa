package com.desafios.exercicios_spring_data_jpa.gerenciador_pedidos.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    private Long id;

    private LocalDate data;

    public Pedido(Long id, LocalDate data) {
        this.id = id;
        this.data = data;
    }

    public Pedido(LocalDate data) {
        this.data = data;
    }

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
