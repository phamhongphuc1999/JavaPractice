package com.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Serialization;
import com.example.AppKafka.KafkaProducerFactory;
import com.example.config.KafkaConstance;
import com.example.entity.dto.OrderDetail;
import com.example.entity.dto.OrderTable;
import com.example.entity.dto_utils.FilteredOrder;
import com.example.entity.dto_utils.FilteredOrderDetail;
import com.example.entity.dto_utils.NewOrder;
import com.example.entity.dto_utils.NewOrderDetail;
import com.example.entity.dto_utils.SaveOrderResult;
import com.order.repository.OrderDetailRepository;
import com.order.repository.OrderRepository;

@Service
public class OrderService {
  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private OrderDetailRepository orderDetailRepository;

  public List<OrderTable> getByFilter(FilteredOrder filteredOrder) {
    return orderRepository.getByFilter(filteredOrder);
  }

  public SaveOrderResult getOrderById(Integer orderId) {
    Optional<OrderTable> orderTable = orderRepository.findById(orderId);
    FilteredOrderDetail filteredOrderDetail = new FilteredOrderDetail();
    filteredOrderDetail.setOrderId(orderId);
    List<OrderDetail> orderDetails = orderDetailRepository.getByFilter(filteredOrderDetail);
    return new SaveOrderResult(orderTable.get(), orderDetails);
  }

  public SaveOrderResult save(NewOrder newOrder) {
    OrderTable entity = new OrderTable(newOrder);
    OrderTable newEntity = orderRepository.save(entity);
    List<OrderDetail> list = new ArrayList<>();
    for (NewOrderDetail item : newOrder.getOrderDetails()) {
      list.add(new OrderDetail(item, newEntity.getId()));
    }
    KafkaProducer<String, String> producer = KafkaProducerFactory.getEntity();
    String sData = Serialization.toJson(newOrder);
    ProducerRecord<String, String> producerRecord = new ProducerRecord<>(KafkaConstance.ORDER_CREATED_TOPIC, sData);
    producer.send(producerRecord);
    producer.flush();
    List<OrderDetail> newOrderDetails = orderDetailRepository.saveAll(list);
    return new SaveOrderResult(newEntity, newOrderDetails);
  }
}
