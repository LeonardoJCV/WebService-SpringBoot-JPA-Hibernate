package com.leonardojcv.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardojcv.springboot.entities.Order;
import com.leonardojcv.springboot.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	//Operação na camada de serviço que repassa a chamada para o repository
	public List<Order>findAll(){
		return repository.findAll();
	}
	
	//Método que retorna pedido por Id
	public Order findById(Long id) {
		Optional<Order>obj = repository.findById(id);
		return obj.get();
	}
	
}
