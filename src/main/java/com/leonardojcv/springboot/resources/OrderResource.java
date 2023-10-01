package com.leonardojcv.springboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonardojcv.springboot.entities.Order;
import com.leonardojcv.springboot.services.OrderService;

//Recurso Web -> implementação do RestController
//RequestMapping para atribuição do caminho do recurso
//Controlador web que responde no caminho /orders

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	//retorna a resposta de requisições web
	@GetMapping
	public ResponseEntity<List<Order>>findAll(){
		List<Order>list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Endpoint do método findById
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order>findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
