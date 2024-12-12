package com.example.entity.dto_utils;

import java.util.List;

import com.example.entity.dto.OrderTable;
import com.example.entity.dto.OrderDetail;

public class SaveOrderResult {
  public OrderTable newOrder;
  public List<OrderDetail> newOrderDetails;

  public SaveOrderResult(OrderTable newOrder, List<OrderDetail> newOrderDetails) {
    this.newOrder = newOrder;
    this.newOrderDetails = newOrderDetails;
  }
}
