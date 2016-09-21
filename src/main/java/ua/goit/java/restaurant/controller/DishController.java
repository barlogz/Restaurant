package ua.goit.java.restaurant.controller;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.restaurant.DAO.interfaces.DishDAO;
import ua.goit.java.restaurant.model.Dish;
import ua.goit.java.restaurant.model.DishCategory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DishController {

    private DishDAO dishDAO;

    @Transactional
    public void addDish() {
        Dish plov = new Dish();
        plov.setName("Plov");
        plov.setDishCategory(DishCategory.FIRST_DISHES);
        plov.setPrice(5);
        plov.setWeight(300);

        Dish salad = new Dish();
        salad.setName("Salad");
        salad.setDishCategory(DishCategory.SALADS);
        salad.setPrice(2);
        salad.setWeight(200);

        Dish potato = new Dish();
        potato.setName("Potato");
        potato.setDishCategory(DishCategory.FIRST_DISHES);
        potato.setPrice(3);
        potato.setWeight(100);
        Set<Dish> dishes = new HashSet<>(dishDAO.findAll());
        if (!dishes.contains(plov)) {
            dishDAO.save(plov);
        }
        if (!dishes.contains(salad)) {
            dishDAO.save(salad);
        }
        if (!dishes.contains(potato)){
            dishDAO.save(potato);
        }
    }

    @Transactional
    public List<Dish> getAllDishes() {
        return dishDAO.findAll();
    }

    @Transactional
    public Dish getDishByName(String name) {
        return dishDAO.findByName(name);
    }


    public void setDishDAO(DishDAO dishDAO) {
        this.dishDAO = dishDAO;
    }
}
