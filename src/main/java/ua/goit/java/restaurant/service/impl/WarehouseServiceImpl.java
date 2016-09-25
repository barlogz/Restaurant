package ua.goit.java.restaurant.service.impl;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.restaurant.DAO.interfaces.WarehouseDAO;
import ua.goit.java.restaurant.model.Warehouse;
import ua.goit.java.restaurant.service.interfaces.WarehouseService;

import java.util.List;

public class WarehouseServiceImpl implements WarehouseService {
    private WarehouseDAO warehouseDAO;

    @Override
    @Transactional
    public void save(Warehouse warehouse) {
        warehouseDAO.save(warehouse);
    }

    @Override
    @Transactional
    public void remove(Warehouse warehouse) {
        warehouseDAO.remove(warehouse);
    }

    @Override
    @Transactional
    public void removeAll() {
        warehouseDAO.removeAll();
    }

    @Override
    @Transactional
    public Warehouse load(Integer id) {
        return warehouseDAO.load(id);
    }

    @Override
    @Transactional
    public Warehouse findByName(String ingredientName) {
        return warehouseDAO.findByName(ingredientName);
    }

    @Override
    @Transactional
    public List<Warehouse> findAll() {
        return warehouseDAO.findAll();
    }

    @Override
    @Transactional
    public void changeQuantityOfIngredient(String ingredientName, Double quantity) {
        warehouseDAO.changeQuantityOfIngredient(ingredientName, quantity);
    }

    @Override
    @Transactional
    public List<Warehouse> findIngredientQuantityLessThan() {

        return warehouseDAO.findIngredientQuantityLessThan();
    }

    public void setWarehouseDAO(WarehouseDAO warehouseDAO) {
        this.warehouseDAO = warehouseDAO;
    }
}