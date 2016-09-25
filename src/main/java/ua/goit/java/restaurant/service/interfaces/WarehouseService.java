package ua.goit.java.restaurant.service.interfaces;

import ua.goit.java.restaurant.model.Warehouse;

import java.util.List;

public interface WarehouseService {
    void save(Warehouse warehouse);
    void remove(Warehouse warehouse);
    void removeAll();
    Warehouse load(Integer id);
    Warehouse findByName(String ingredientName);
    List<Warehouse> findAll();
    void changeQuantityOfIngredient(String ingredientName, Double quantity);
    List<Warehouse> findIngredientQuantityLessThan();
}
