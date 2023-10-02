package com.leonardojcv.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardojcv.springboot.entities.Product;

//interface Repositorio de produto extendendo o respositorio JPA.
//Já existe uma implementação padrão devido ao JPARespository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
