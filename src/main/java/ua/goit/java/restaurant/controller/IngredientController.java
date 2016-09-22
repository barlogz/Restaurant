package ua.goit.java.restaurant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.goit.java.restaurant.model.Ingredient;
import ua.goit.java.restaurant.service.interfaces.IngredientService;

@Controller
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    private static final Logger LOGGER = LoggerFactory.getLogger(IngredientController.class);


    @RequestMapping(value = "/ingredients/list", method = RequestMethod.GET)
    private String ingredientCtrl(ModelMap modelMap) {
        modelMap.addAttribute("ingredients", ingredientService.findAll());
        return "/ingredients/list";
    }

    @RequestMapping(value = "ingredients/list", method = RequestMethod.POST)
    public String saveOrUpdateIngredient(@ModelAttribute("ingredientForm") @Validated Ingredient ingredient,
                                         BindingResult result) {
        if (result.hasErrors()) {
            return "ingredients/ingredientform";
        }
        ingredientService.save(ingredient);
        return "redirect:/ingredients/list";
    }

    @RequestMapping(value = "/ingredients/add", method = RequestMethod.GET)
    public String showAddIngredientForm(ModelMap modelMap) {
        Ingredient ingredient = new Ingredient();
        modelMap.addAttribute("ingredientForm", ingredient);
        return "/ingredients/ingredientform";
    }

    @RequestMapping(value = "/ingredients/{id}/delete", method = RequestMethod.GET)
    public String deleteIngredient(@PathVariable("id") Integer id) {
        Ingredient ingredient = ingredientService.findById(id);
        ingredientService.remove(ingredient);
        return "redirect:/ingredients/list";
    }

    @RequestMapping(value = "/ingredients/{id}/update", method = RequestMethod.GET) //POST
    public String updateIngredient(@PathVariable("id") Integer id, ModelMap modelMap) {
        Ingredient ingredient = ingredientService.findById(id);
        modelMap.addAttribute("ingredientForm", ingredient);
        return "/ingredients/ingredientform";
    }


}
