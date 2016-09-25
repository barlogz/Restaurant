package ua.goit.java.restaurant.service.impl;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.restaurant.DAO.interfaces.OrderDAO;
import ua.goit.java.restaurant.model.Order;
import ua.goit.java.restaurant.service.interfaces.OrderService;

import java.sql.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService{

    private OrderDAO orderDAO;

    @Override
    @Transactional
    public void save(Order order) {
        orderDAO.save(order);
    }

    @Override
    @Transactional
    public void remove(Order order) {
        orderDAO.remove(order);
    }

    @Override
    @Transactional
    public void removeAll() {
        orderDAO.removeAll();
    }

    @Override
    @Transactional
    public Order findById(Integer id) {
        return orderDAO.findById(id);
    }

    @Override
    @Transactional
    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    @Override
    @Transactional
    public void closeOrder(Order order) {
        orderDAO.closeOrder(order);
    }

    @Override
    @Transactional
    public List<Order> findByWaiterName(String waiterName) {
        return orderDAO.findByWaiterName(waiterName);
    }

    @Override
    @Transactional
    public List<Order> findByDate(Date date) {
        return orderDAO.findByDate(date);
    }

    @Override
    @Transactional
    public List<Order> findByTableNumber(Integer tableNumber) {
        return orderDAO.findByTableNumber(tableNumber);
    }

    @Override
    @Transactional
    public List<Order> findAllOpenedOrders() {
        return orderDAO.findAllOpenedOrders();
    }

    @Override
    @Transactional
    public List<Order> findAllClosedOrders() {
        return orderDAO.findAllClosedOrders();
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
}
