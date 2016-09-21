package ua.goit.java.restaurant.DAO.hibernate;

import org.hibernate.SessionFactory;
import ua.goit.java.restaurant.DAO.interfaces.OrderDAO;
import ua.goit.java.restaurant.model.Order;

import java.util.List;

public class HOrderDAO implements OrderDAO{

    private SessionFactory sessionFactory;

    @Override
    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public List<Order> findAllOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
