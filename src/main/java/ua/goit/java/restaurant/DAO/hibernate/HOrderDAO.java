package ua.goit.java.restaurant.DAO.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.restaurant.DAO.interfaces.OrderDAO;
import ua.goit.java.restaurant.model.Order;
import ua.goit.java.restaurant.model.OrderStatus;

import java.sql.Date;
import java.util.List;

public class HOrderDAO implements OrderDAO {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Order order) {
        if (order.getId() == null) {
            order.setOrderStatus(OrderStatus.OPENED);
            order.setOrderDate(new java.util.Date());
        }
        sessionFactory.getCurrentSession().saveOrUpdate(order);
    }

    @Override
    @Transactional
    public void remove(Order order) {
        if (order.getOrderStatus().equals(OrderStatus.OPENED)) {
            sessionFactory.getCurrentSession().delete(order);
        } else {
            throw new RuntimeException("Order is CLOSED and can`t be deleted.");
        }
    }

    @Override
    @Transactional
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Order").executeUpdate();
    }

//    @Override
//    @Transactional
//    public Order findById(Integer id) {
//        Order result = sessionFactory.getCurrentSession().get(Order.class, id);
//        if (result == null) {
//            throw new RuntimeException("There is no such Order with id: " + "\"" + id + "\"");
//        }
//        return result;
//    }

    @Override
    @Transactional
    public Order findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from Order o where o.id = :id");
        query.setParameter("id", id);
        return (Order) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Order> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select o from Order o").list();
    }

    @Override
    @Transactional
    public void closeOrder(Order order) {
        order.setOrderStatus(OrderStatus.CLOSED);
        sessionFactory.getCurrentSession().saveOrUpdate(order);
    }

    @Override
    @Transactional
    public List<Order> findByWaiterName(String waiterName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT o FROM Orders o, Employee e WHERE e.first_name like : waiterName");
        query.setParameter("waiterName", waiterName);
        return (List<Order>) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Order> findByDate(Date date) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from Order o where o.orderDate like :orderDate");
        query.setParameter("orderDate", date);
        return (List<Order>) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Order> findByTableNumber(Integer tableNumber) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from Order o where o.tableNumber like :tableNumber");
        query.setParameter("tableNumber", tableNumber);
        return (List<Order>) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Order> findAllOpenedOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Order o where o.orderStatus='OPENED'").list();
    }

    @Override
    @Transactional
    public List<Order> findAllClosedOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Order o where o.orderStatus='CLOSED'").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
