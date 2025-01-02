package com.inventory.RecordFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.Serialization;
import com.example.AppKafka.KafkaProducerFactory;
import com.example.config.Constance.OrderStatus;
import com.example.config.KafkaConstance;
import com.example.entity.dto.Product;
import com.example.entity.dto_utils.NewOrderDetail;
import com.example.entity.dto_utils.SavedNewOrder;
import com.inventory.service.ProductService;

public class ProductSimulation {
  @Autowired
  private ProductService productService;

  public void saveNewOrders(List<SavedNewOrder> newOrders) {
    Map<Integer, Boolean> map = new HashMap<>();
    for (SavedNewOrder item : newOrders) {
      for (NewOrderDetail detail : item.getOrderDetails()) {
        if (!map.containsKey(detail.getProductId()))
          map.put(detail.getProductId(), true);
      }
    }
    List<Integer> ids = new ArrayList<>(map.keySet());
    List<Product> products = productService.getAllById(ids);
    Map<Integer, Product> mapProducts = new HashMap<>();
    for (Product product : products) {
      mapProducts.put(product.getId(), product);
    }
    List<RecordResult> result = new ArrayList<>();
    for (SavedNewOrder order : newOrders) {
      OrderStatus status = OrderStatus.ORDER_OK;
      for (NewOrderDetail detail : order.getOrderDetails()) {
        Integer quantity = detail.getQuantity();
        Integer productId = detail.getProductId();
        Product availableProduct = mapProducts.get(productId);
        Integer availableQuantity = availableProduct.getQuantity();
        if (availableQuantity < quantity) {
          status = OrderStatus.FULL_ORDER;
          break;
        } else
          availableProduct.setQuantity(availableQuantity - quantity);
      }
      result.add(new RecordResult(order.getCustomerId(), order.getOrderId(), status));
      KafkaProducer<String, String> producer = KafkaProducerFactory.getEntity();
      for (RecordResult item : result) {
        String sData = Serialization.toJson(item);
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(KafkaConstance.CONFIRM_ORDER_TOPIC, sData);
        producer.send(producerRecord);
        producer.flush();
      }
    }
  }
}
