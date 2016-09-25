package ua.goit.java.restaurant.service.impl;

import ua.goit.java.restaurant.DAO.interfaces.PreparedDishDAO;
import ua.goit.java.restaurant.model.PreparedDish;
import ua.goit.java.restaurant.service.interfaces.PreparedDishService;

import java.util.List;

public class PreparedDishServiceImpl implements PreparedDishService{

    private PreparedDishDAO preparedDishDAO;

    @Override
    public void save(PreparedDish preparedDish) {
        preparedDishDAO.save(preparedDish);
    }

    @Override
    public void remove(PreparedDish preparedDish) {
        preparedDishDAO.remove(preparedDish);
    }

    @Override
    public PreparedDish findById(Integer id) {
        return preparedDishDAO.findById(id);
    }

    @Override
    public List<PreparedDish> findByName(String name) {
        return preparedDishDAO.findByName(name);
    }


    @Override
    public List<PreparedDish> findAll() {
        return preparedDishDAO.findAll();
    }

    public void setPreparedDishDAO(PreparedDishDAO preparedDishDAO) {
        this.preparedDishDAO = preparedDishDAO;
    }
}
