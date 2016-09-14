package ua.goit.java.restaurant.DAO;

import ua.goit.java.restaurant.model.Dish;

import java.util.List;

public interface DishDAO {

    void save(Dish dish);

    List<Dish> findAll();

    Dish findByName(String name);
}
