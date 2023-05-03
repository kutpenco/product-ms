package br.com.madrugas.productms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.madrugas.productms.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
