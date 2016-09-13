package ua.goit.java.restaurant.controller;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.restaurant.model.Employee;
import ua.goit.java.restaurant.DAO.EmployeeDAO;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeController {

    private EmployeeDAO employeeDAO;

    @Transactional
    public void addEmployee() {
        Set<Employee> allEmployees = new HashSet<>(employeeDAO.findAll());
        Employee employee = new Employee();
//        employee.setId(1);
        employee.setLastName("TestLastName");
        employee.setFirstName("TestFirstName");
        employee.setPositionId(1);
        employee.setSalary(1234567890);
        employee.setBirthday(Date.valueOf("1970-01-01"));
//        employee.setPosition(Position.CHEF);
        if (!allEmployees.contains(employee)) {
            employeeDAO.add(employee);
        }
    }

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    /**FOR JDBC    private PlatformTransactionManager txManager;
 private EmployeeDAO employeeDAO;

 public List<EmployeeOLD_FOR_JDBC> findAllEmployees() {
 TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));
 try {
 List<EmployeeOLD_FOR_JDBC> result = employeeDAO.findAll();
 txManager.commit(status);
 return result;
 } catch (Exception e) {
 txManager.rollback(status);
 throw new RuntimeException(e);
 }
 }

 @Transactional public EmployeeOLD_FOR_JDBC findEmployeeByName(String name) {
 return employeeDAO.findByName(name);}

 public void setTxManager(PlatformTransactionManager txManager) {
 this.txManager = txManager;
 }

 public void setEmployeeDAO(EmployeeDAO employeeDAO) {
 this.employeeDAO = employeeDAO;
 }
 **/

}
