package ua.goit.java.restaurant.DAO.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.restaurant.DAO.interfaces.DishDAO;
import ua.goit.java.restaurant.model.Dish;
import ua.goit.java.restaurant.model.Employee;

import java.util.List;

public class HDishDAO implements DishDAO {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().saveOrUpdate(dish);
    }

    @Override
    @Transactional
    public void remove(Dish dish) {
        sessionFactory.getCurrentSession().delete(dish);
    }

    @Override
    @Transactional
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("DELETE from Dish").executeUpdate();
    }

    @Override
    @Transactional
    public Dish findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select d from Dish d where d.name like :name");
        query.setParameter("name", name);
        return (Dish) query.uniqueResult();
    }

    @Override
    @Transactional
    public Dish findById(Integer id) {
        Dish result = sessionFactory.getCurrentSession().get(Dish.class, id);
        if (result == null) {
            throw new RuntimeException("There is no such Dish with id = " + id);
        }
        return result;
    }

    @Override
    @Transactional
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
