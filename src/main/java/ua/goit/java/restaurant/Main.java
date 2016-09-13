package ua.goit.java.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.restaurant.controller.DishController;
import ua.goit.java.restaurant.controller.EmployeeController;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private EmployeeController employeeController;
    private DishController dishController;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        context.getBean(Main.class).start();
    }

    private void start() {
        employeeController.addEmployee();
        dishController.addDish();

        employeeController.getAllEmployees().forEach(System.out::println);
        dishController.getAllDishes().forEach(System.out::println);

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
}
