package com.leonardojcv.springboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonardojcv.springboot.entities.User;
import com.leonardojcv.springboot.services.UserService;

//Recurso Web -> implementação do RestController
//RequestMapping para atribuição do caminho do recurso
//Controlador web que responde no caminho /users

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	//retorna a resposta de requisições web
	@GetMapping
	public ResponseEntity<List<User>>findAll(){
		List<User>list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Endpoint do método findById
	@GetMapping(value = "/{id}")
	public ResponseEntity<User>findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
