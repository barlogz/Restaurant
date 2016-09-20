package ua.goit.java.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.java.restaurant.DAO.interfaces.*;
import ua.goit.java.restaurant.model.*;

import javax.annotation.PostConstruct;
import java.sql.Date;

@Service
public class InitDB {
//    @Autowired
//    private DishDao dishDao;
    @Autowired
    private EmployeeDAO employeeDAO;
//    @Autowired
//    private OrderDao orderDao;
//    @Autowired
//    private MenuDao menuDao;
//    @Autowired
//    private IngredientDao ingredientDao;
//    @Autowired
//    private WarehouseDao warehouseDao;
//    @Autowired
//    private PreparedDishDao preparedDishDao;

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

        System.out.println("*** INIT DB DONE ***");

    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
}
