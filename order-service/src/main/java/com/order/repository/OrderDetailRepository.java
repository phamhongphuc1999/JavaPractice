package com.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.dto.OrderDetail;
import com.example.entity.dto_utils.FilteredOrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
  @Query("SELECT od FROM OrderDetail od WHERE " +
      "(:#{#filteredOrderDetail.id} IS NULL OR :#{#filteredOrderDetail.id}=od.id) AND " +
      "(:#{#filteredOrderDetail.orderId} IS NULL OR :#{#filteredOrderDetail.orderId}=od.orderId) AND " +
      "(:#{#filteredOrderDetail.productId} IS NULL OR od.productId=:#{#filteredOrderDetail.productId}) AND " +
      "(:#{#filteredOrderDetail.fromQuantity} IS NULL OR od.quantity>=:#{#filteredOrderDetail.fromQuantity}) AND " +
      "(:#{#filteredOrderDetail.toQuantity} IS NULL OR od.quantity<=:#{#filteredOrderDetail.toQuantity}) AND " +
      "(:#{#filteredOrderDetail.fromPrice} IS NULL OR od.price>=:#{#filteredOrderDetail.fromPrice}) AND " +
      "(:#{#filteredOrderDetail.toPrice} IS NULL OR od.price<=:#{#filteredOrderDetail.toPrice})")
  List<OrderDetail> getByFilter(@Param("filteredOrderDetail") FilteredOrderDetail filteredOrderDetail);
}
