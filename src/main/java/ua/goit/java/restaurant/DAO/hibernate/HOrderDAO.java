package ua.goit.java.restaurant.DAO.hibernate;

import org.hibernate.SessionFactory;
import ua.goit.java.restaurant.DAO.OrderDAO;
import ua.goit.java.restaurant.model.Order;

public class HOrderDAO implements OrderDAO{

    private SessionFactory sessionFactory;

    @Override
    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
