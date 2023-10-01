package com.leonardojcv.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardojcv.springboot.entities.Category;
import com.leonardojcv.springboot.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	//Operação na camada de serviço que repassa a chamada para o repository
	public List<Category>findAll(){
		return repository.findAll();
	}
	
	//Método que retorna usuario por Id
	public Category findById(Long id) {
		Optional<Category>obj = repository.findById(id);
		return obj.get();
	}
	
}
