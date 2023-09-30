package com.leonardojcv.springboot.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.leonardojcv.springboot.entities.User;

//Recurso Web -> implementação do RestController
//RequestMapping para atribuição do caminho do recurso
//Controlador web que responde no caminho /users

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//retorna a resposta de requisições web
	@GetMapping
	public ResponseEntity<User>findAll(){
		User u = new User(1L, "Maria", "Maria@gmail.com", "99999999", "12345");
		return ResponseEntity.ok().body(u);
	}	
}
