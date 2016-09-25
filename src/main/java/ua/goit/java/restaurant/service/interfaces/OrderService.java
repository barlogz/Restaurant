package ua.goit.java.restaurant.service.interfaces;

import ua.goit.java.restaurant.model.Order;

import java.sql.Date;
import java.util.List;

public interface OrderService {
    void save(Order order);

    void remove(Order order);

    void removeAll();

    Order findById(Integer id);

    List<Order> findAll();

    void closeOrder(Order order);

    List<Order> findByWaiterName(String waiterName);

    List<Order> findByDate(Date date);

    List<Order> findByTableNumber(Integer tableNumber);

    List<Order> findAllOpenedOrders();

    List<Order> findAllClosedOrders();
}
