package ua.goit.java.restaurant.DAO.interfaces;

import ua.goit.java.restaurant.model.PreparedDish;

import java.util.List;

public interface PreparedDishDAO {
    void save(PreparedDish preparedDish);
    void remove(PreparedDish preparedDish);

    PreparedDish findById(Integer id);
    List<PreparedDish> findByName(String name);
    List<PreparedDish> findAll();
}
