package com.leonardojcv.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardojcv.springboot.entities.User;

//interface Repositorio de usuario extendendo o respositorio JPA.
//Já existe uma implementação padrão devido ao JPARespository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
