package com.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.model.Product;
import com.apirest.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/products")
@Api(value = "API Rest Produtos")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired	
	private ProductRepository productRepository;
	
	@GetMapping
	@ApiOperation(value = "Retorna uma lista de produtos")
	public List<Product> read(){
		return productRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um produto único")
	public Optional<Product> readById(@PathVariable("id")Long id) {
		return productRepository.findById(id);
	}
	
	@PostMapping
	@ApiOperation(value = "Salva um produto")
	public Product create(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um produto")
	public void delete(@PathVariable("id")Long id) {
		productRepository.deleteById(id);
	}
	
	@PutMapping
	@ApiOperation(value = "Atualiza um produto")
	public Product update(@RequestBody Product product) {
		return productRepository.save(product);
	}
}
