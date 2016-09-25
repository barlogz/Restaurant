package ua.goit.java.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.java.restaurant.DAO.interfaces.*;
import ua.goit.java.restaurant.model.*;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitDB {
    @Autowired
    private DishDAO dishDAO;
    @Autowired
    private EmployeeDAO employeeDAO;
//    @Autowired
//    private OrderDAO orderDAO;
    @Autowired
    private MenuDAO menuDAO;
//    @Autowired
//    private IngredientDAO ingredientDAO;
//    @Autowired
//    private WarehouseDAO warehouseDAO;
//    @Autowired
//    private PreparedDishDAO preparedDishDAO;

    @PostConstruct
    public void init() {
        System.out.println("*** INIT DB START ***");

        Employee moreno = new Employee();
        moreno.setFirstName("Antonio");
        moreno.setLastName("Moreno");
        moreno.setBirthday(Date.valueOf("1970-01-01"));
        moreno.setPhoneNumber("+38(099)999-00-01");
        moreno.setPosition(Position.DIRECTOR);
        moreno.setSalary(400000);
        employeeDAO.save(moreno);

        Employee kipko = new Employee();
        kipko.setFirstName("Sergiy");
        kipko.setLastName("Kipko");
        kipko.setBirthday(Date.valueOf("1981-02-02"));
        kipko.setPhoneNumber("+38(099)999-00-02");
        kipko.setPosition(Position.ACCOUNTANT);
        kipko.setSalary(300000);
        employeeDAO.save(kipko);


        Employee iryna = new Employee();
        iryna.setFirstName("Sydorenko");
        iryna.setLastName("Iryna");
        iryna.setBirthday(Date.valueOf("1992-01-11"));
        iryna.setPhoneNumber("+38(099)999-00-11");
        iryna.setPosition(Position.WAITER);
        iryna.setSalary(160000);
        employeeDAO.save(iryna);

        /**NOT IMPLEMENTED CLASS YET**/
//        Cook volodymyr = new Cook();
//        volodymyr.setFirstName("Petrenko");
//        volodymyr.setLastName("Volodymyr");
//        volodymyr.setBirthday(Date.valueOf("1981-01-02"));
//        volodymyr.setPhoneNumber("+38(099)999-00-08");
//        volodymyr.setPosition(Position.COOK);
//        volodymyr.setSalary(200000);
//        employeeDAO.save(volodymyr);

        Dish margarita = new Dish();
        margarita.setName("MARGARITA");
        margarita.setDishCategory(DishCategory.PIZZA);
        margarita.setPrice(158);
        margarita.setWeight(1250);
        dishDAO.save(margarita);

        List<Dish> pizzaDishes = new ArrayList<>();
        pizzaDishes.add(margarita);


        Menu pizza = new Menu();
        pizza.setName("PIZZA");
        pizza.setDishes(pizzaDishes);
        menuDAO.save(pizza);

        System.out.println("*** INIT DB DONE ***");

    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void setDishDAO(DishDAO dishDAO) {
        this.dishDAO = dishDAO;
    }

    public void setMenuDAO(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }
}
