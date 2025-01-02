package com.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.dto.Product;
import com.example.entity.dto_utils.FilteredProduct;
import com.inventory.repository.ProductRepository;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public Optional<Product> getById(Integer id) {
    return this.productRepository.findById(id);
  }

  public List<Product> getAllById(Iterable<Integer> ids) {
    return this.productRepository.findAllById(ids);
  }

  public List<Product> getByFilter(FilteredProduct filteredProduct) {
    return this.productRepository.getByFilter(filteredProduct);
  }

  public Product save(Product entity) {
    Product newProduct = productRepository.save(entity);
    return newProduct;
  }
}
