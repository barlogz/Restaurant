package ua.goit.java.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.restaurant.controller.DishController;
import ua.goit.java.restaurant.controller.EmployeeController;
import ua.goit.java.restaurant.controller.OrderController;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        context.getBean(Main.class).start();
    }

    private void start() {
        employeeController.addEmployee();
        dishController.addDish();

        List<String> dishes1 = new ArrayList<>();
        dishes1.add("Plov");
        dishes1.add("Salad");

        orderController.createOrder("TestFirstName", dishes1, 1);

        List<String> dishes2 = new ArrayList<>();
        dishes2.add("Potato");
        dishes2.add("Salad");

        orderController.createOrder("TestFirstName", dishes2, 2);
        orderController.printAllOrders();

//        employeeController.getAllEmployees().forEach(System.out::println);
//        dishController.getAllDishes().forEach(System.out::println);

//        System.out.println(dishController.getDishByName("Plov"));

//        System.out.println(employeeController.getEmployeeByName("TestFirstName"));

        //System.out.println(employeeController.addEmployee());
//        System.out.println(employeeController.getAllEmployees());

        //        System.out.println(employeeController.findEmployeeByName("Antonio"));
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }
}
