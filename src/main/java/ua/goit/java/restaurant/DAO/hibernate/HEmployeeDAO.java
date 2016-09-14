package ua.goit.java.restaurant.DAO.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ua.goit.java.restaurant.model.Employee;
import ua.goit.java.restaurant.DAO.EmployeeDAO;

import java.util.List;
import java.util.Queue;

public class  HEmployeeDAO implements EmployeeDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(HEmployeeDAO.class);

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void add(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }

    @Override
    public void deleteById(int id) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteByNameAndSurname(String firstName, String lastName) {
        throw new NotImplementedException();

    }

    @Override
    public Employee findByNameAndSurname(String firstName, String lastName) {
        throw new NotImplementedException();

    }

    @Override
    public Employee findByName(String firstName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.firstName like :first_name");
        query.setParameter("first_name", firstName);
        return (Employee) query.uniqueResult();
    }

    @Override
    public Employee findByID(int id) {
        throw new NotImplementedException();

    }

    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from Employee e").list();
    }

    @Override
    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
