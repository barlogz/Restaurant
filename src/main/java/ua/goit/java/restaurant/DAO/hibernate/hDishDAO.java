package ua.goit.java.restaurant.DAO.hibernate;

import org.hibernate.SessionFactory;
import ua.goit.java.restaurant.DAO.DishDAO;
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

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
