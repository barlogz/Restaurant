package ua.goit.java.restaurant.service.interfaces;

import ua.goit.java.restaurant.model.Ingredient;

import java.util.List;

public interface IngredientService {

    void save(Ingredient ingredient);

    void remove(Ingredient ingredient);

    void removeAll();

    Ingredient findById(Integer id);

    Ingredient findByName(String name);

    List<Ingredient> findByNonExactName(String name);

    List<Ingredient> findAll();
}
