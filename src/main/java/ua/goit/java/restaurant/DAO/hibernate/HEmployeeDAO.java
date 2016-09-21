package ua.goit.java.restaurant.DAO.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ua.goit.java.restaurant.model.Employee;
import ua.goit.java.restaurant.DAO.interfaces.EmployeeDAO;

import java.util.List;

public class  HEmployeeDAO implements EmployeeDAO {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    @Override
    public void removeAll() { sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee").executeUpdate(); }

    @Override
    @Transactional
    public Employee findBySurname(String lastName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT e FROM Employee e WHERE e.lastName LIKE :lastName");
        query.setParameter("lastName", lastName);
        return (Employee) query.uniqueResult();
    }

    @Override
    @Transactional
    public Employee findByName(String firstName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT e FROM Employee e WHERE e.firstName LIKE :firstName");
        query.setParameter("firstName", firstName);
        return (Employee) query.uniqueResult();
    }

    @Override
    @Transactional
    public Employee findByNameAndSurname(String firstName, String lastName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT e FROM Employee e WHERE e.firstName LIKE :firstName " +
                "AND e.lastName LIKE :lastName");
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        return (Employee) query.uniqueResult();
    }

    @Override
    @Transactional
    public Employee findByID(Integer id) {
        Employee result = sessionFactory.getCurrentSession().get(Employee.class, id);
        if (result==null) {
            throw new RuntimeException("There is no such Employee with id = " + id);
        }
        return result;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from Employee e").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
