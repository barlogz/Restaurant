package ua.goit.java.restaurant.DAO.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.goit.java.restaurant.DAO.interfaces.DishDAO;
import ua.goit.java.restaurant.model.Dish;

import java.util.List;

public class HDishDAO implements DishDAO{

    private SessionFactory sessionFactory;

    @Override
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }

    @Override
    public List<Dish> findAll() {
//        Session session = sessionFactory.getCurrentSession();
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
    }

    @Override
    public Dish findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select d from Dish d where d.name like :name");
        query.setParameter("name", name);
        return (Dish) query.uniqueResult();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
