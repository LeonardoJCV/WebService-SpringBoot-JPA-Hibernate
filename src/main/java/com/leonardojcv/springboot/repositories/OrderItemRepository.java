package com.leonardojcv.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardojcv.springboot.entities.OrderItem;

//interface Repositorio de Item de Pedido extendendo o respositorio JPA.
//Já existe uma implementação padrão devido ao JPARespository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}
