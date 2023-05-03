package br.com.madrugas.productms.service;

import java.util.List;
import java.util.Optional;

import br.com.madrugas.productms.dto.ProductDTO;

public interface ProductService {

	
	Optional<ProductDTO> create(ProductDTO request);
	
	Optional<ProductDTO> update(ProductDTO request);
	
	Optional<ProductDTO> inactive(Long id);

	List<ProductDTO> getAll();
	
	Optional<ProductDTO> getById(Long Id);

	Optional<ProductDTO> inactive(ProductDTO request);
	
}
