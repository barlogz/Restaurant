package ua.goit.java.restaurant.service.impl;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.restaurant.DAO.interfaces.IngredientDAO;
import ua.goit.java.restaurant.model.Ingredient;
import ua.goit.java.restaurant.service.interfaces.IngredientService;

import java.util.List;

public class IngredientServiceImpl implements IngredientService{

    private IngredientDAO ingredientDAO;

    @Override
    @Transactional
    public void save(Ingredient ingredient) {
        ingredientDAO.save(ingredient);
    }

    @Override
    @Transactional
    public void remove(Ingredient ingredient) {
        ingredientDAO.remove(ingredient);
    }

    @Override
    @Transactional
    public void removeAll() {
        ingredientDAO.removeAll();
    }

    @Override
    @Transactional
    public Ingredient findById(Integer id) {
        return ingredientDAO.findById(id);
    }

    @Override
    @Transactional
    public Ingredient findByName(String name) {
        return ingredientDAO.findByName(name);
    }

    @Transactional
    @Override
    public List<Ingredient> findByNonExactName(String name) {
        return ingredientDAO.findByNonExactName(name);
    }

    @Override
    @Transactional
    public List<Ingredient> findAll() {
        return ingredientDAO.findAll();
    }

    public void setIngredientDAO(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }
}
