package ua.goit.java.restaurant.DAO.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.restaurant.DAO.interfaces.WarehouseDAO;
import ua.goit.java.restaurant.model.Warehouse;

import java.util.List;

public class HWarehouseDAO implements WarehouseDAO {
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Warehouse warehouse) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(warehouse);
        } catch (Exception e) {
            throw new RuntimeException("Ingredient already exists!");
        }
    }

    @Override
    @Transactional
    public void remove(Warehouse warehouse) {
        sessionFactory.getCurrentSession().delete(warehouse);
    }

    @Override
    @Transactional
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Warehouse").executeUpdate();
    }

    @Override
    @Transactional
    public Warehouse load(Integer id) {
        Warehouse result = sessionFactory.getCurrentSession().get(Warehouse.class, id);
        if (result == null) {
            throw new RuntimeException("There is no such Warehouse with id: " + "\"" + id + "\"");
        }
        return result;
    }

    @Override
    @Transactional
    public Warehouse findByName(String ingredientName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select w from Warehouse w where w.ingredient.name like :name");
        //Query query = session.createQuery("from Warehouse w inner join Ingredient i on w.ingredient.name  = i.id where w.ingredient.name = ingredientName");
        query.setParameter("name", "%" + ingredientName + "%");
        return (Warehouse) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Warehouse> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select w from Warehouse w").list();
    }

    @Override
    @Transactional
    public void changeQuantityOfIngredient(String ingredientName, Double quantity) {
        Query query = sessionFactory.getCurrentSession().createQuery("update Warehouse w set w.quantity = :quantity where w.name = :ingredientName");
        query.setParameter("quantity", quantity);
        query.setParameter("ingredientName", ingredientName);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public List<Warehouse> findIngredientQuantityLessThan() {
        return sessionFactory.getCurrentSession().createQuery("select w from Warehouse w where w.quantity < 10").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}