package ua.goit.java.restaurant.model.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ua.goit.java.restaurant.model.Employee;
import ua.goit.java.restaurant.model.EmployeeDAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman D. on 05.09.2016.
 */
public class JdbcEmployeeDAO implements EmployeeDAO {

    private DataSource dataSource;

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcEmployeeDAO.class);

    @Override
    public Employee add(Employee employee) {
        throw new NotImplementedException();
    }


    @Override
    public Employee deleteById(int id) {
        throw new NotImplementedException();
    }

    @Override
    public Employee deleteByNameAndSurname(String firstName, String lastName) {
        throw new NotImplementedException();
    }

    @Override
    public Employee findByNameAndSurname(String firstName, String lastName) {
        throw new NotImplementedException();
    }

    @Override
    public Employee findByName(String firstName) {
        throw new NotImplementedException();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Employee> findAll() {
        List<Employee> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");

            while (resultSet.next()) {
                Employee employee = createEmployee(resultSet);
                result.add(employee);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to BD " + /*url,*/ e);
            throw new RuntimeException(e);
        }
        return result;
    }

    private Employee createEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("ID"));
        employee.setPositionId(resultSet.getInt("POSITION_ID"));
        employee.setLastName(resultSet.getString("LAST_NAME"));
        employee.setFirstName(resultSet.getString("FIRST_NAME"));
        employee.setBirthday(resultSet.getDate("BIRTHDAY"));
        employee.setSalary(resultSet.getInt("SALARY"));
        return employee;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
