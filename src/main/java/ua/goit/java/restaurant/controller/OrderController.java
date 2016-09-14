package ua.goit.java.restaurant.controller;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.restaurant.DAO.DishDAO;
import ua.goit.java.restaurant.DAO.EmployeeDAO;
import ua.goit.java.restaurant.DAO.OrderDAO;
import ua.goit.java.restaurant.model.Dish;
import ua.goit.java.restaurant.model.Orders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import java.sql.Date;

public class OrderController {

    private EmployeeDAO employeeDAO;
    private DishDAO dishDAO;
    private OrderDAO orderDAO;

    @Transactional
    public void createOrder(String waiterName, List<String> dishes, int tableNumber) {
        Orders orders = new Orders();
        orders.setWaiter(employeeDAO.findByName(waiterName));
        orders.setDishes(createDishes(dishes));
        orders.setTableNumber(tableNumber);
        orders.setOrderDate(new Date());

        orderDAO.save(orders);
    }

    @Transactional
    public List<Orders> getAllOrders() {
        return orderDAO.findAllOrders();
    }

    @Transactional
    public void printAllOrders() {
        getAllOrders().forEach(System.out::println);
    }

    private List<Dish> createDishes(List<String> dishes) {
        List<Dish> result = new ArrayList<>();
        for (String dishName : dishes) {
            result.add(dishDAO.findByName(dishName));
        }
        return result;
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void setDishDAO(DishDAO dishDAO) {
        this.dishDAO = dishDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
}
