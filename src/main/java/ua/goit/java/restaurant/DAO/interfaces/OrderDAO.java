package ua.goit.java.restaurant.DAO.interfaces;

import ua.goit.java.restaurant.model.Order;

import java.util.List;

public interface OrderDAO {

    void save(Order order);

    List<Order> findAllOrders();
}
