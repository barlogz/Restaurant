package ua.goit.java.restaurant.service.interfaces;

import ua.goit.java.restaurant.model.Employee;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);

    void remove(Employee employee);

    void removeAll();

    Employee findByID(Integer id);

    Employee findByName(String firstName);

    Employee findBySurname(String lastName);

    Employee findByNameAndSurname(String firstName, String lastName);

    List<Employee> findAll();

    List<Employee> findAllCooks();

    List<Employee> findAllWaiters();
}
