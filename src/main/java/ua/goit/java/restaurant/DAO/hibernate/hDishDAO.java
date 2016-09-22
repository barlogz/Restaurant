package ua.goit.java.restaurant.DAO.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.goit.java.restaurant.DAO.interfaces.DishDAO;
import ua.goit.java.restaurant.model.Dish;
import ua.goit.java.restaurant.model.Employee;

import java.util.List;

public class HDishDAO implements DishDAO{

    private SessionFactory sessionFactory;

    @Override
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }

    @Override
    public void remove(Dish dish) {
        sessionFactory.getCurrentSession().delete(dish);
    }

    @Override
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("DELETE from Dish").executeUpdate();
    }

    @Override
    public Dish findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select d from Dish d where d.name like :name");
        query.setParameter("name", name);
        return (Dish) query.uniqueResult();
    }

    @Override
    public Dish findById(Integer id) {
        Dish result = sessionFactory.getCurrentSession().get(Dish.class, id);
        if (result==null) {
            throw new RuntimeException("There is no such Dish with id = " + id);
        }
        return result;
    }

    @Override
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
