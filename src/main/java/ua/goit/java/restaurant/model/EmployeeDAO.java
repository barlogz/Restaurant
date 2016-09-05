package ua.goit.java.restaurant.model;

import java.util.List;

/**
 * Created by Roman D. on 05.09.2016.
 */
public interface EmployeeDAO {
    Employee add(Employee employee);
//int id, int positionId, String lastName, String firstName, LocalDate birthday, int salary
    Employee deleteById(int id);

    Employee deleteByNameAndSurname(String firstName, String lastName);

    Employee findByNameAndSurname(String firstName, String lastName);

    Employee findByName(String firstName);

    List<Employee> findAll();


    /**добавлять сотрудников
    удалять сотрудников
    искать сотрудников по имени
    выводить на экран список всех сотрудников*/

}
