package com.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.dto.Product;
import com.example.entity.dto_utils.FilteredProduct;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
  List<Product> getByFilter(@Param("filteredProduct") FilteredProduct filteredProduct);
}
