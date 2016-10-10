package ua.goit.java.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.goit.java.restaurant.model.*;
import ua.goit.java.restaurant.service.interfaces.DishService;
import ua.goit.java.restaurant.service.interfaces.EmployeeService;
import ua.goit.java.restaurant.service.interfaces.PreparedDishService;
import ua.goit.java.restaurant.service.interfaces.WarehouseService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PreparedDishController {

    @Autowired
    private PreparedDishService preparedDishService;
    @Autowired
    private DishService dishService;
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private WarehouseService warehouseService;

    @RequestMapping(value = "/prepared/list", method = RequestMethod.GET)
    public String preparedDishCtrl(ModelMap modelMap) {
        List<PreparedDish> preparedDishes = preparedDishService.findAll();
        modelMap.addAttribute("preparedDishes", preparedDishes);
        return "/prepared/list";
    }

    @RequestMapping(value = "/prepared/list", method = RequestMethod.POST)
    public String saveOrUpdatePreparedDish(@ModelAttribute("preparedDishForm") @Validated PreparedDish preparedDish, BindingResult result) {
        if (result.hasErrors()) {
            return "/prepared/prepareddishform";
        }
        String dishName = preparedDish.getDish().getName();
        Dish dish = dishService.findByName(dishName);
        preparedDish.setDish(dish);

        String cookerName = preparedDish.getCook().getFirstName();
        Employee cooker = employeeService.findByName(cookerName);
        preparedDish.setCook(cooker);

        if (preparedDish.getId() == null) {
            List<Ingredient> ingredientList = preparedDish.getDish().getIngredients();
            for (Ingredient ingredient : ingredientList) {
                Warehouse warehouse = warehouseService.findByName(ingredient.getName());
                double quantityOfIngredientInWarehouse = warehouse.getQuantity() - 1.0;
                warehouse.setQuantity(quantityOfIngredientInWarehouse);
                warehouseService.save(warehouse);
            }
        }

        preparedDishService.save(preparedDish);
        return "redirect:/prepared/list";

    }


    @RequestMapping(value = "/prepared/{id}/delete", method = RequestMethod.GET)
    public String deletePreparedDish(@PathVariable("id") Integer id) {
        PreparedDish preparedDish = preparedDishService.findById(id);
        preparedDishService.remove(preparedDish);
        return "redirect:/prepared/list";
    }

    @RequestMapping(value = "/prepared/add", method = RequestMethod.GET)
    public String addPreparedDish(ModelMap modelMap) {
        PreparedDish preparedDish = new PreparedDish();
        modelMap.addAttribute("preparedDishForm", preparedDish);
        modelMap.addAttribute("listOfDishCategory", DishCategory.values());
        return "/prepared/prepareddishform";

    }

    @RequestMapping(value = "/prepared/{id}/update", method = RequestMethod.GET)
    public String updatePreparedDish(@PathVariable("id") Integer id, ModelMap modelMap) {
        PreparedDish preparedDish = preparedDishService.findById(id);
        modelMap.addAttribute("preparedDishForm", preparedDish);
        return "/prepared/prepareddishform";
    }


    @ModelAttribute("cookerNames")
    public List<String> getCookerNames() {
        return employeeService.findAll().stream().map(Employee::getFirstName).collect(Collectors.toList());
    }

    @ModelAttribute("dishNames")
    public List<String> getDishNames() {
        return dishService.findAll().stream().map(Dish::getName).collect(Collectors.toList());
    }

    public void setPreparedDishService(PreparedDishService preparedDishService) {
        this.preparedDishService = preparedDishService;
    }

    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
