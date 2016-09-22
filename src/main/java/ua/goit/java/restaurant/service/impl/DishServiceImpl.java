package ua.goit.java.restaurant.service.impl;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.restaurant.DAO.interfaces.DishDAO;
import ua.goit.java.restaurant.model.Dish;
import ua.goit.java.restaurant.service.interfaces.DishService;

import java.util.List;

public class DishServiceImpl implements DishService{

    private DishDAO dishDAO;

    @Override
    @Transactional
    public void save(Dish dish) {
        dishDAO.save(dish);
    }

    @Override
    @Transactional
    public void remove(Dish dish) {
        dishDAO.remove(dish);
    }

    @Override
    @Transactional
    public void removeAll() {
        dishDAO.removeAll();
    }

    @Override
    @Transactional
    public Dish findById(Integer id) {
        return dishDAO.findById(id);
    }

    @Override
    @Transactional
    public Dish findByName(String name) {
        return dishDAO.findByName(name);
    }

    @Override
    @Transactional
    public List<Dish> findAll() {
        return dishDAO.findAll();
    }

    public void setDishDAO(DishDAO dishDAO) {
        this.dishDAO = dishDAO;
    }
}
