package ua.goit.java.restaurant.service.interfaces;

import ua.goit.java.restaurant.model.Dish;

import java.util.List;

public interface DishService {

    void save(Dish dish);

    void remove(Dish dish);

    void removeAll();

    Dish findById(Integer id);

    Dish findByName(String name);

    List<Dish> findAll();
}
