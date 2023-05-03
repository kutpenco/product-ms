package br.com.madrugas.productms.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {

	private String name;
	@Size(min = 50)
	private String description;
	@Positive
	private double price;
	private boolean available;
}
