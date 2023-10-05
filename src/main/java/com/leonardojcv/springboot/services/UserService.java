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
	
	//Operação básica para inserção do objeto "user"
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	//Operação básica para deleção do objeto "user"
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	//Operação básica para atualização do objeto "user"
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	//Método auxiliar para atualização dos dados do usuario
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}
