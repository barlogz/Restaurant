package ua.goit.java.restaurant.DAO;

import ua.goit.java.restaurant.model.Employee;

import java.util.List;

/**
 * Created by Roman D. on 05.09.2016.
 */
public interface EmployeeDAO {
    void add(Employee employee);
//int id, int positionId, String lastName, String firstName, LocalDate birthday, int salary

    void remove(Employee employee);

    void deleteById(int id);

    void deleteByNameAndSurname(String firstName, String lastName);

    Employee findByNameAndSurname(String firstName, String lastName);

    Employee findByName(String firstName);

    Employee findByID(int id);

    List findAll();


    /**добавлять сотрудников
    удалять сотрудников
    искать сотрудников по имени
    выводить на экран список всех сотрудников*/

}
