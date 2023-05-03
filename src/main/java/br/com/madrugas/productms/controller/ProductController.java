package br.com.madrugas.productms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.madrugas.productms.dto.ProductDTO;
import br.com.madrugas.productms.service.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@PostMapping
	public ResponseEntity<ProductDTO> create(@RequestBody @Valid ProductDTO request){
		Optional<ProductDTO> response = productService.create(request);
		
		/* Alternativa
		
		if (response.isPresent()) {
			return new ResponseEntity<>(response.get(), HttpStatus.CREATED);
		} else {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		*/
		
		return response.map(productDTO -> new ResponseEntity<>(response.get(), HttpStatus.CREATED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAll(){
		return ResponseEntity.ok(productService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getById(@PathVariable ("id") Long id){
		Optional<ProductDTO> response = productService.getById(id);
		
		/* ALTERNATIVA
		
		if (response.isPresent()) {
			return ResponseEntity.ok(response.get());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		*/
		//return ResponseEntity.ok(productService.getById(id));
		
		return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> updateById(@PathVariable ("id") Long id, @RequestBody @Valid ProductDTO request){
		Optional<ProductDTO> response = productService.update(request);
		
		return response.map(productDTO -> new ResponseEntity<>(response.get(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
	}
	
	@DeleteMapping("/{id}")
	public boolean inactive (@PathVariable ("id") Long id){
		Optional<ProductDTO> inactive = productService.inactive(id);
		//operador ternario 
		//return inactive ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return false;
	}
	
}
