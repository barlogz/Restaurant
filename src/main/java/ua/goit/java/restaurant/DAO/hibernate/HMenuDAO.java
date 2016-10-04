package ua.goit.java.restaurant.DAO.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.restaurant.DAO.interfaces.MenuDAO;
import ua.goit.java.restaurant.model.Dish;
import ua.goit.java.restaurant.model.Menu;

import javax.persistence.TypedQuery;
import java.util.List;

public class HMenuDAO implements MenuDAO {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Menu menu) {
        sessionFactory.getCurrentSession().saveOrUpdate(menu);
    }

    @Override
    @Transactional
    public void addDishToMenu(Menu menu, Dish dish) {
        if (!menu.getDishes().contains(dish)) {
            menu.getDishes().add(dish);
            sessionFactory.getCurrentSession().saveOrUpdate(menu);
        } else {
            throw new RuntimeException("Dish already exist in menu: " + "\"" + menu.getName() + "\"");
        }
    }

    @Override
    @Transactional
    public void remove(Menu menu) {
        sessionFactory.getCurrentSession().delete(menu);
    }

    @Override
    @Transactional
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Menu").executeUpdate();
    }

    @Override
    @Transactional
    public Menu findById(Integer id) {
//        Menu result = sessionFactory.getCurrentSession().get(Menu.class, id);
        Query query = sessionFactory.getCurrentSession().createQuery("select m from Menu m where m.id = :id");
        query.setParameter("id", id);
        Menu result = (Menu) query.uniqueResult();
        if (result == null) {
            throw new RuntimeException("There is no such Menu with id: " + "\"" + id + "\"");
        }
        return result;
    }

    @Override
    @Transactional
    public Menu findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select m from Menu m where m.name like :name");
        query.setParameter("name", name);
        return (Menu) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Menu> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select m from Menu m").list();
    }

    @Override
    @Transactional
    public List<Dish> findAllDishesByMenuId(Integer id) {
        TypedQuery query = sessionFactory.getCurrentSession().createQuery(
                "from Menu m join m.dishes d where m.id =: menuId", Dish.class);
        query.setParameter("menuId", id);
        return (List<Dish>) query.getResultList();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
