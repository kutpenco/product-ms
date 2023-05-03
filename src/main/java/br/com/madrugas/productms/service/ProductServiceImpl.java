package br.com.madrugas.productms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.madrugas.productms.config.MapperConfig;
import br.com.madrugas.productms.dto.ProductDTO;
import br.com.madrugas.productms.model.Product;
import br.com.madrugas.productms.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Optional<ProductDTO> create(ProductDTO request){
		//ModelMapper mapper = new ModelMapper();
		Product product = mapper.map(request, Product.class);
		/*esse cara faz a mesma coisa que:
		
		Product product = new Product();
		product.setName(request.getName());
		product.setPrice(request.getPrice());
		product.setDescription(request.getDescription());
		product.setAvailable(request.isAvailable());
		
		*/
		repository.saveAndFlush(product);
		
		ProductDTO response = mapper.map(request, ProductDTO.class);
		/* Esse Cara faz a mesma coisa que:
		 
		ProductDTO response = new ProductDTO();
		response.setName(product.getName());
		response.setPrice(product.getPrice());
		response.setDescription(product.getDescription());
		response.setAvailable(product.isAvailable());
		
		*/
		
		return Optional.of(response);
	}
	@Override
	public List<ProductDTO> getAll() {
		//ModelMapper mapper = new ModelMapper();
		List<Product> products = repository.findAll();
		List<ProductDTO> responses = new ArrayList<>();
		
		/*for (Product product : products) {
			ProductDTO response = mapper.map(product, ProductDTO.class);
			responses.add(response);
			
		}*/
		
		products.forEach(product -> {
			ProductDTO response = mapper.map(product, ProductDTO.class);
			responses.add(response);
		});
		return responses;
	}
	@Override
	public Optional<ProductDTO> getById(Long Id) {
		Optional<Product> product = repository.findById(Id);
		/* ALTERNATIVA DO PROCESSO ABAIXO
	
		if (product.isPresent()) {
			return Optional.of(mapper.map(product.get(), ProductDTO.class));
		}
		return Optional.empty();
		
		*/
		return product.map(value -> mapper.map(value, ProductDTO.class));
		
	}
	@Override
	public Optional<ProductDTO> update(ProductDTO request) {
		Product product = mapper.map(request, Product.class);
		repository.saveAndFlush(product);
		ProductDTO response = mapper.map(request, ProductDTO.class);
		return Optional.of(response);
	}
	@Override
	public Optional<ProductDTO> inactive(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	@Override
	public Optional<ProductDTO> inactive(ProductDTO request) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
}
