package ua.goit.java.restaurant.DAO.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.restaurant.DAO.interfaces.IngredientDAO;
import ua.goit.java.restaurant.model.Ingredient;

import java.util.List;

public class HIngredientDAO implements IngredientDAO{

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Ingredient ingredient) {
        sessionFactory.getCurrentSession().saveOrUpdate(ingredient);
    }

    @Override
    @Transactional
    public void remove(Ingredient ingredient) {
        sessionFactory.getCurrentSession().delete(ingredient);
    }

    @Override
    @Transactional
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Ingredient").executeUpdate();
    }

    @Override
    @Transactional
    public Ingredient findById(Integer id) {
        Ingredient result = sessionFactory.getCurrentSession().get(Ingredient.class, id);
        if (result==null) {
            throw new RuntimeException("There is no such Ingredient with id = " + id);
        }
        return result;
    }

    @Override
    @Transactional
    public Ingredient findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select i from Ingredient i where i.name like :name");
        query.setParameter("name", name);
        return (Ingredient) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Ingredient> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select i from Ingredient i").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
