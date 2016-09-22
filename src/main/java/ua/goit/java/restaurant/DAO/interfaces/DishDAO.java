package ua.goit.java.restaurant.DAO.interfaces;

import ua.goit.java.restaurant.model.Dish;

import java.util.List;

public interface DishDAO {

    void save(Dish dish);

    void remove(Dish dish);

    void removeAll();

    Dish findById(Integer id);

    Dish findByName(String name);

    List<Dish> findAll();
}
