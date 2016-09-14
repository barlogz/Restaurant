package ua.goit.java.restaurant.DAO.hibernate;

import org.hibernate.SessionFactory;
import ua.goit.java.restaurant.DAO.OrderDAO;
import ua.goit.java.restaurant.model.Orders;

import java.util.List;

public class HOrderDAO implements OrderDAO{

    private SessionFactory sessionFactory;

    @Override
    public void save(Orders orders) {
        sessionFactory.getCurrentSession().save(orders);
    }

    @Override
    public List<Orders> findAllOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
