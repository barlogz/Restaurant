package ua.goit.java.restaurant.service.interfaces;

import ua.goit.java.restaurant.model.Dish;
import ua.goit.java.restaurant.model.Menu;

import java.util.List;

public interface MenuService {
    void save(Menu menu);
    void addDishToMenu(Menu menu, Dish dish);
    void remove(Menu menu);
    void removeAll();
    Menu findById(Integer id);
    Menu findByName(String name);
    List<Menu> findAll();
    List<Dish> findAllDishesByMenuId(Integer id);
}
