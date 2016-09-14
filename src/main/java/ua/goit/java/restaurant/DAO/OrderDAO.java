package ua.goit.java.restaurant.DAO;

import ua.goit.java.restaurant.model.Orders;

import java.util.List;

public interface OrderDAO {

    void save(Orders orders);

    List<Orders> findAllOrders();
}
