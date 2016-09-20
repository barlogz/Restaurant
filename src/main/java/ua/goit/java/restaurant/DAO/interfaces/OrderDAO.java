package ua.goit.java.restaurant.DAO.interfaces;

import ua.goit.java.restaurant.model.Orders;

import java.util.List;

public interface OrderDAO {

    void save(Orders orders);

    List<Orders> findAllOrders();
}
