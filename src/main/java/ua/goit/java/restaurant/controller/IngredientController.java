package ua.goit.java.restaurant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.goit.java.restaurant.model.Ingredient;
import ua.goit.java.restaurant.service.interfaces.IngredientService;

import java.util.List;

@Controller
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;
    private static final Logger LOGGER = LoggerFactory.getLogger(IngredientController.class);


    @RequestMapping(value = "/admin/ingredients/list", method = RequestMethod.GET)
    public String ingredientCtrl(ModelMap modelMap) {
        modelMap.addAttribute("ingredients", ingredientService.findAll());
        return "/admin/ingredients/list";
    }

    @RequestMapping(value = "/admin/ingredients/list", method = RequestMethod.POST)
    public String saveOrUpdateIngredient(@ModelAttribute("ingredientForm") @Validated Ingredient ingredient,
                                         BindingResult result) {
        if (result.hasErrors()) {
            return "/admin/ingredients/ingredientform";
        }
        ingredientService.save(ingredient);
        return "redirect:/admin/ingredients/list";
    }

    @RequestMapping(value = "/admin/ingredients/add", method = RequestMethod.GET)
    public String showAddIngredientForm(ModelMap modelMap) {
        Ingredient ingredient = new Ingredient();
        modelMap.addAttribute("ingredientForm", ingredient);
        return "/admin/ingredients/ingredientform";
    }

    @RequestMapping(value = "/admin/ingredients/{id}/delete", method = RequestMethod.GET)
    public String deleteIngredient(@PathVariable("id") Integer id) {
        Ingredient ingredient = ingredientService.findById(id);
        ingredientService.remove(ingredient);
        return "redirect:/admin/ingredients/list";
    }

    @RequestMapping(value = "/admin/ingredients/{id}/update", method = RequestMethod.GET)
    public String updateIngredient(@PathVariable("id") Integer id, ModelMap modelMap) {
        LOGGER.debug("showUpdateIngredientForm() : {}", id);
        Ingredient ingredient = ingredientService.findById(id);
        modelMap.addAttribute("ingredientForm", ingredient);
        return "/admin/ingredients/ingredientform";
    }

    @RequestMapping(value = "/admin/ingredients/search", method = RequestMethod.GET)
    public String searchByName(@RequestParam("name") String name, ModelMap modelMap) {
        if (name == null || name == "") {
            return "redirect:/admin/ingredients/list";
        } else {
            System.out.println("before creating ingredients");
            List<Ingredient> ingredientsList = ingredientService.findByNonExactName(name);
            System.out.println("after creating ingredients");
            modelMap.addAttribute("ingredients", ingredientsList);
            System.out.println("after modelMap.addAttribute");
            return "/admin/ingredients/search";
        }
    }
}
