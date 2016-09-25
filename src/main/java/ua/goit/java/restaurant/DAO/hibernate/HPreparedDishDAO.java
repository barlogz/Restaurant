package ua.goit.java.restaurant.DAO.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.restaurant.DAO.interfaces.PreparedDishDAO;
import ua.goit.java.restaurant.model.PreparedDish;

import java.util.List;

public class HPreparedDishDAO implements PreparedDishDAO {
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(PreparedDish preparedDish) {
        sessionFactory.getCurrentSession().saveOrUpdate(preparedDish);
    }

    @Override
    @Transactional
    public void remove(PreparedDish preparedDish) {
        sessionFactory.getCurrentSession().delete(preparedDish);
    }

    @Override
    @Transactional
    public PreparedDish findById(Integer id) {
        return sessionFactory.getCurrentSession().get(PreparedDish.class, id);
    }


    @Override
    @Transactional
    public List<PreparedDish> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from PreparedDish p where p.dish.name like :name");
        query.setParameter("name", name);
        return query.list();
    }

    @Override
    @Transactional
    public List<PreparedDish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select p from PreparedDish p").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
