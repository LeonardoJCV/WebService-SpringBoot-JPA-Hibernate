package com.leonardojcv.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.leonardojcv.springboot.entities.User;
import com.leonardojcv.springboot.repositories.UserRepository;
import com.leonardojcv.springboot.services.exceptions.DatabaseException;
import com.leonardojcv.springboot.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//Operação básica para inserção do objeto "user"
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	//Operação básica para deleção do objeto "user"
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	//Operação básica para atualização do objeto "user"
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	//Método auxiliar para atualização dos dados do usuario
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}
