package com.leonardojcv.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardojcv.springboot.entities.Order;

//interface Repositorio de pedido extendendo o respositorio JPA.
//Já existe uma implementação padrão devido ao JPARespository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
