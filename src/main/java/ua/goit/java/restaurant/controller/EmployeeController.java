package ua.goit.java.restaurant.controller;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import ua.goit.java.restaurant.model.Employee;
import ua.goit.java.restaurant.model.EmployeeDAO;

import java.util.List;

/**
 * Created by Roman D. on 05.09.2016.
 */
public class EmployeeController {

    private PlatformTransactionManager txManager;
    private EmployeeDAO employeeDAO;

    public List<Employee> findAllEmployees() {
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));
        try {
            List<Employee> result = employeeDAO.findAll();
            txManager.commit(status);
            return result;
        } catch (Exception e) {
            txManager.rollback(status);
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public Employee findEmployeeByName(String name) {
        return employeeDAO.findByName(name);}

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
}
