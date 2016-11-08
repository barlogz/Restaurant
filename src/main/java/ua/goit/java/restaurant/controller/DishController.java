package ua.goit.java.restaurant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.java.restaurant.model.Dish;
import ua.goit.java.restaurant.model.DishCategory;
import ua.goit.java.restaurant.model.Ingredient;
import ua.goit.java.restaurant.service.interfaces.DishService;
import ua.goit.java.restaurant.service.interfaces.IngredientService;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private IngredientService ingredientService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DishController.class);

    @RequestMapping(value = "/admin/dishes/list", method = RequestMethod.GET)
    public String dishesCtrl(Model model) {
        model.addAttribute("dish", dishService.findAll());
        return "/admin/dishes/list";
    }

    @RequestMapping(value = "/admin/dishes/list", method = RequestMethod.POST)
    public String saveOrUpdateDish(@ModelAttribute("dishForm") @Validated Dish dish, BindingResult result) {
        if (result.hasErrors()) {
            return "/admin/dishes/dishform";
        }
        try {
            if (dish.getId()!=null) {
                Dish updatedDish = dishService.findById(dish.getId());

                updatedDish.setIngredients(updatedDish.getIngredients());
                updatedDish.setName(dish.getName());
                updatedDish.setDishCategory(dish.getDishCategory());
                updatedDish.setWeight(dish.getWeight());
                updatedDish.setPrice(dish.getPrice());
                updatedDish.setDescription(dish.getDescription());
                updatedDish.setMenu(dish.getMenu());
                updatedDish.setOrder(dish.getOrder());

                dishService.save(updatedDish);

            } else {
                dishService.save(dish);
            }
        }catch (Exception ex) {
            throw new RuntimeException("There is a dish with such name already!");
        }

        return "redirect:/admin/dishes/list";
    }

    @RequestMapping(value = "/admin/dishes/show/{id}", method = RequestMethod.GET)
    public ModelAndView showDish(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Dish dish = dishService.findById(id);

        modelAndView.addObject("dish", dish);
        modelAndView.addObject("ingredients", dish.getIngredients());
        modelAndView.addObject("ingredient", new Ingredient());

        modelAndView.setViewName("/admin/dishes/show");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/dishes/{id}/delete", method = RequestMethod.GET)
    public String deleteDishCtrl(@PathVariable("id") Integer id) {
        Dish dish = dishService.findById(id);
        dishService.remove(dish);
        return "redirect:/admin/dishes/list";
    }

    @RequestMapping(value = "/admin/dishes/add", method = RequestMethod.GET)
    public String showAddDishForm(Model model) {
        model.addAttribute("listOfDishCategory", DishCategory.values());
        Dish dish = new Dish();
        model.addAttribute("dishForm", dish);
        return "/admin/dishes/dishform";
    }

    @RequestMapping(value = "/admin/dishes/{id}/update", method = RequestMethod.GET)
    public String showAddDishForm(@PathVariable("id") Integer id, Model model) {
        LOGGER.debug("showUpdateDishForm() : {}", id);
        Dish dish = dishService.findById(id);
        model.addAttribute("dishForm", dish);
        return "/admin/dishes/dishform";
    }

    @RequestMapping(value = "/admin/dish/{id}/addIngredient", method = RequestMethod.POST)
    public String addIngredientToDish(@PathVariable("id") Integer id, @ModelAttribute("ingredient") Ingredient ingredient) {
        String ingredientName = ingredient.getName();
        Ingredient thisIngredient= ingredientService.findByName(ingredientName);
        Dish dish = dishService.findById(id);
        dish.getIngredients().add(thisIngredient);
        dishService.save(dish);
        return "redirect:/admin/dishes/show/" + dish.getId();
    }

    @RequestMapping(value = "/admin/dishes/{dishId}/deleteIngredient/{ingredientId}", method = RequestMethod.GET)
    public String deleteIngredientFromDish(@PathVariable("dishId") Integer dishId, @PathVariable("ingredientId") Integer ingredientId) {
        Dish dish = dishService.findById(dishId);
        List<Ingredient> ingredients = dish.getIngredients();
        Iterator<Ingredient> ingredientIterator = ingredients.iterator();
        while (ingredientIterator.hasNext()) {
            Ingredient ingredient = ingredientIterator.next();
            if (ingredient.getId()==ingredientId) {
                ingredientIterator.remove();
                break;
            }
        }
        dishService.save(dish);
        return "redirect:/admin/dishes/show/" + dish.getId();
    }

    @ModelAttribute("ingredientNames")
    public List<String> getIngredientNames() {
        return ingredientService.findAll().stream().map(Ingredient::getName).collect(Collectors.toList());
    }
}
