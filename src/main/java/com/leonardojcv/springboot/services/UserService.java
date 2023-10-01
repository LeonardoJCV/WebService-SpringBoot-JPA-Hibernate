package com.leonardojcv.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardojcv.springboot.entities.User;
import com.leonardojcv.springboot.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	//Operação na camada de serviço que repassa a chamada para o repository
	public List<User>findAll(){
		return repository.findAll();
	}
	
	//Método que retorna usuario por Id
	public User findById(Long id) {
		Optional<User>obj = repository.findById(id);
		return obj.get();
	}
	
}
