package com.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.dto.OrderTable;
import com.example.entity.dto_utils.FilteredOrder;

@Repository
public interface OrderRepository extends JpaRepository<OrderTable, Integer> {
  @Query("SELECT o FROM OrderTable o " +
      "LEFT JOIN PaymentMethod pm ON o.paymentMethod.id=pm.id WHERE " +
      "(:#{#filteredOrder.id} IS NULL OR o.id=:#{#filteredOrder.id}) AND " +
      "(:#{#filteredOrder.customerId} IS NULL OR o.customerId=:#{#filteredOrder.customerId}) AND " +
      "(:#{#filteredOrder.fromOrderDate} IS NULL OR o.orderDate>=:#{#filteredOrder.fromOrderDate}) AND " +
      "(:#{#filteredOrder.toOrderDate} IS NULL OR o.orderDate<=:#{#filteredOrder.toOrderDate}) AND " +
      "(:#{#filteredOrder.status} IS NULL OR o.status=:#{#filteredOrder.status}) AND" +
      "(:#{#filteredOrder.fromTotalAmount} IS NULL OR o.totalAmount>=:#{#filteredOrder.fromTotalAmount}) AND " +
      "(:#{#filteredOrder.toTotalAmount} IS NULL OR o.totalAmount<=:#{#filteredOrder.toTotalAmount}) AND " +
      "(:#{#filteredOrder.paymentMethodName} IS NULL OR :#{#filteredOrder.paymentMethodName}=o.paymentMethod.id)")
  List<OrderTable> getByFilter(@Param("filteredOrder") FilteredOrder filteredOrder);
}
