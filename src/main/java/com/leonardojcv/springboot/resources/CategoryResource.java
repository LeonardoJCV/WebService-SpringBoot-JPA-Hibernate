package com.leonardojcv.springboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonardojcv.springboot.entities.Category;
import com.leonardojcv.springboot.services.CategoryService;

//Recurso Web -> implementação do RestController
//RequestMapping para atribuição do caminho do recurso
//Controlador web que responde no caminho /categories

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	//retorna a resposta de requisições web
	@GetMapping
	public ResponseEntity<List<Category>>findAll(){
		List<Category>list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Endpoint do método findById
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category>findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
