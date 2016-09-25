package ua.goit.java.restaurant.service.impl;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.restaurant.DAO.hibernate.HMenuDAO;
import ua.goit.java.restaurant.model.Dish;
import ua.goit.java.restaurant.model.Menu;
import ua.goit.java.restaurant.service.interfaces.MenuService;

import java.util.List;

public class MenuServiceImpl implements MenuService {

    private HMenuDAO menuDAO;

    @Override
    @Transactional
    public void save(Menu menu) {
        menuDAO.save(menu);
    }

    @Override
    @Transactional
    public void addDishToMenu(Menu menu, Dish dish) {
        menuDAO.addDishToMenu(menu, dish);
    }

    @Override
    @Transactional
    public void remove(Menu menu) {
        menuDAO.remove(menu);
    }

    @Override
    @Transactional
    public void removeAll() {
        menuDAO.removeAll();
    }

    @Override
    @Transactional
    public Menu findById(Integer id) {
        return menuDAO.findById(id);
    }

    @Override
    @Transactional
    public Menu findByName(String name) {
        return menuDAO.findByName(name);
    }

    @Override
    @Transactional
    public List<Menu> findAll() {
        return menuDAO.findAll();
    }

    @Override
    @Transactional
    public List<Dish> findAllDishesByMenuId(Integer id) {
        return menuDAO.findAllDishesByMenuId(id);
    }

    public void setMenuDAO(HMenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }
}
