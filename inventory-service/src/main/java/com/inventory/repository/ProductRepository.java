package com.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.dto.Product;
import com.example.entity.dto_utils.FilteredProduct;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
  @Query("SELECT p from Product p " +
      "LEFT JOIN Supplier s ON p.supplier.id=s.id WHERE " +
      "(:#{#filteredProduct.id} IS NULL OR p.id=:#{#filteredProduct.id}) AND " +
      "(:#{#filteredProduct.name} IS NULL OR p.name=:#{#filteredProduct.name}) AND " +
      "(:#{#filteredProduct.fromQuantity} IS NULL OR p.quantity>=:#{#filteredProduct.fromQuantity}) AND " +
      "(:#{#filteredProduct.toQuantity} IS NULL OR p.quantity<=:#{#filteredProduct.toQuantity}) AND " +
      "(:#{#filteredProduct.fromCreateAt} IS NULL OR p.createAt>=:#{#filteredProduct.fromCreateAt}) AND " +
      "(:#{#filteredProduct.toCreateAt} IS NULL OR p.createAt<=:#{#filteredProduct.toCreateAt}) AND " +
      "(:#{#filteredProduct.fromUpdateAt} IS NULL OR p.updateAt>=:#{#filteredProduct.fromUpdateAt}) AND " +
      "(:#{#filteredProduct.toUpdateAt} IS NULL OR p.updateAt<=:#{#filteredProduct.toUpdateAt})")
  List<Product> getByFilter(@Param("filteredProduct") FilteredProduct filteredProduct);
}
