package com.leonardojcv.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardojcv.springboot.entities.Category;

//interface Repositorio de categoria extendendo o respositorio JPA.
//Já existe uma implementação padrão devido ao JPARespository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
