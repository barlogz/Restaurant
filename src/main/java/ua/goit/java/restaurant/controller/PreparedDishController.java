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

    @RequestMapping(value = "/admin/prepared/list", method = RequestMethod.GET)
    public String preparedDishCtrl(ModelMap modelMap) {
        List<PreparedDish> preparedDishes = preparedDishService.findAll();
        modelMap.addAttribute("preparedDishes", preparedDishes);
        return "/admin/prepared/list";
    }

    @RequestMapping(value = "/admin/prepared/list", method = RequestMethod.POST)
    public String saveOrUpdatePreparedDish(@ModelAttribute("preparedDishForm") @Validated PreparedDish preparedDish, BindingResult result) {
        if (result.hasErrors()) {
            return "/admin/prepared/prepareddishform";
        }
        String dishName = preparedDish.getDish().getName();
        Dish dish = dishService.findByName(dishName);
        preparedDish.setDish(dish);

        String cookerName = preparedDish.getCook().getFirstName();
        Employee cooker = employeeService.findByName(cookerName);
        preparedDish.setCook(cooker);

        System.out.println("we are in the ADD method");
        System.out.println(preparedDish.getId());

        try {
            if (preparedDish.getId() == null) {
                List<Ingredient> ingredientList = preparedDish.getDish().getIngredients();
                for (Ingredient ingredient : ingredientList) {
                    Warehouse warehouse = warehouseService.findByName(ingredient.getName());
                    double quantityOfIngredientInWarehouse = warehouse.getQuantity() - 1.0;
                    warehouse.setQuantity(quantityOfIngredientInWarehouse);
                    warehouseService.save(warehouse);
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("Not enough ingredients to prepare this dish");
        }

        preparedDishService.save(preparedDish);
        return "redirect:/admin/prepared/list";

    }


    @RequestMapping(value = "/admin/prepared/{id}/delete", method = RequestMethod.GET)
    public String deletePreparedDish(@PathVariable("id") Integer id) {
        PreparedDish preparedDish = preparedDishService.findById(id);
        preparedDishService.remove(preparedDish);
        return "redirect:/admin/prepared/list";
    }

    @RequestMapping(value = "/admin/prepared/add", method = RequestMethod.GET)
    public String addPreparedDish(ModelMap modelMap) {
        System.out.println("we are in the ADD method");
        PreparedDish preparedDish = new PreparedDish();
        modelMap.addAttribute("preparedDishForm", preparedDish);
        modelMap.addAttribute("listOfDishCategory", DishCategory.values());
        return "/admin/prepared/prepareddishform";

    }

    @RequestMapping(value = "/admin/prepared/{id}/update", method = RequestMethod.GET)
    public String updatePreparedDish(@PathVariable("id") Integer id, ModelMap modelMap) {
        PreparedDish preparedDish = preparedDishService.findById(id);
        modelMap.addAttribute("preparedDishForm", preparedDish);
        return "/admin/prepared/prepareddishform";
    }


    @ModelAttribute("cookerNames")
    public List<String> getCookerNames() {
        return employeeService.findAllCooks().stream().map(Employee::getFirstName).collect(Collectors.toList());
    }

    @ModelAttribute("dishNames")
    public List<String> getDishNames() {
        return dishService.findAll().stream().map(Dish::getName).collect(Collectors.toList());
    }
}
