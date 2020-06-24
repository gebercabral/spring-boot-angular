package com.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
