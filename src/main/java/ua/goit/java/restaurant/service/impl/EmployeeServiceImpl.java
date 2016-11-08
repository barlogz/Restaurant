package ua.goit.java.restaurant.service.impl;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.restaurant.DAO.interfaces.EmployeeDAO;
import ua.goit.java.restaurant.model.Employee;
import ua.goit.java.restaurant.service.interfaces.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void remove(Employee employee) {
        employeeDAO.remove(employee);
    }

    @Override
    @Transactional
    public void removeAll() {
        employeeDAO.removeAll();
    }

    @Override
    @Transactional
    public Employee findByID(Integer id) {
        return employeeDAO.findByID(id);
    }

    @Override
    @Transactional
    public Employee findByName(String firstName) {
        return employeeDAO.findByName(firstName);
    }

    @Override
    @Transactional
    public Employee findBySurname(String lastName) {
        return employeeDAO.findBySurname(lastName);
    }

    @Override
    public Employee findByNameAndSurname(String firstName, String lastName) {
        return employeeDAO.findByNameAndSurname(firstName, lastName);
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public List<Employee> findAllCooks() {
        return employeeDAO.findAllCooks();
    }

    @Override
    @Transactional
    public List<Employee> findAllWaiters() {
        return employeeDAO.findAllWaiters();
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
}
