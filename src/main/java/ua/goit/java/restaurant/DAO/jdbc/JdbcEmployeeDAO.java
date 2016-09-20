//package ua.goit.java.restaurant.DAO.jdbc;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//import sun.reflect.generics.reflectiveObjects.NotImplementedException;
//import ua.goit.java.restaurant.model.Employee;
//import ua.goit.java.restaurant.DAO.interfaces.EmployeeDAO;
//
//import javax.sql.DataSource;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Roman D. on 05.09.2016.
// */
//public class JdbcEmployeeDAO implements EmployeeDAO {
//
//    private DataSource dataSource;
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcEmployeeDAO.class);
//
//    @Override
//    public void save(Employee employee) {
//        throw new NotImplementedException();
//    }
//
//
//    @Override
//    public void deleteById(int id) {
//        throw new NotImplementedException();
//    }
//
//    @Override
//    public void deleteByNameAndSurname(String firstName, String lastName) {
//        throw new NotImplementedException();
//    }
//
//    @Override
//    public Employee findBySurname(String firstName, String lastName) {
//        throw new NotImplementedException();
//    }
//
//    @Override
//    public Employee findByName(String firstName) {
//
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE FIRST_NAME = ?")) {
//            statement.setString(1, firstName);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                return createEmployee(resultSet);
//            } else {
//                throw new RuntimeException("cannot find employee with name " + firstName);
//            }
//        } catch (SQLException e) {
//            LOGGER.error("Exception occurred while connecting to BD " + /*url, */e);
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public Employee findByID(int id) {
//        throw new NotImplementedException();
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.MANDATORY)
//    public List findAll() {
//        List<Employee> result = new ArrayList<>();
//        try (Connection connection = dataSource.getConnection();
//             Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
//
//            while (resultSet.next()) {
//                Employee employee = createEmployee(resultSet);
//                result.add(employee);
//            }
//        } catch (SQLException e) {
//            LOGGER.error("Exception occurred while connecting to BD " + /*url,*/ e);
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//
//    private Employee createEmployee(ResultSet resultSet) throws SQLException {
//        Employee employee = new Employee();
//        employee.setId(resultSet.getInt("ID"));
//        employee.setPositionId(resultSet.getInt("POSITION_ID"));
//        employee.setLastName(resultSet.getString("LAST_NAME"));
//        employee.setFirstName(resultSet.getString("FIRST_NAME"));
//        employee.setBirthday(resultSet.getDate("BIRTHDAY"));
//        employee.setSalary(resultSet.getInt("SALARY"));
//        return employee;
//    }
//
//    @Override
//    public void remove(Employee employee) {
//        throw new NotImplementedException();
//    }
//
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//}
