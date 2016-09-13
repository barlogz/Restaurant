package ua.goit.java.restaurant.controller;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.restaurant.DAO.DishDAO;
import ua.goit.java.restaurant.model.Dish;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DishController {

    private DishDAO dishDAO;

    @Transactional
    public void addDish() {
        Dish plov = new Dish();
        plov.setName("Plov");
        plov.setCategoryId(1);
        plov.setPrice(5);
        plov.setWeight(300);

        Dish salad = new Dish();
        salad.setName("Salad");
        salad.setCategoryId(2);
        salad.setPrice(2);
        salad.setWeight(200);

        Dish potato = new Dish();
        potato.setName("Potato");
        potato.setCategoryId(3);
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

    public void setDishDAO(DishDAO dishDAO) {
        this.dishDAO = dishDAO;
    }
}
