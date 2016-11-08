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
import ua.goit.java.restaurant.model.Menu;
import ua.goit.java.restaurant.service.interfaces.DishService;
import ua.goit.java.restaurant.service.interfaces.MenuService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private DishService dishService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);

    @RequestMapping(value = "/admin/menus/list", method = RequestMethod.GET)
    public String menuCtrl(Model model) {
        model.addAttribute("menus", menuService.findAll());
        return "/admin/menus/list";
    }

    @RequestMapping(value = "/admin/menus/list", method = RequestMethod.POST)
    public String saveOrUpdateMenu(@ModelAttribute("menuForm") @Validated Menu menu, BindingResult result) {
        if (result.hasErrors()) {
            return "/admin/menus/menuform";
        }
        menuService.save(menu);
        return "redirect:/admin/menus/list";
    }

    @RequestMapping(value = "/admin/menus/show/{id}", method = RequestMethod.GET)
    public ModelAndView showMenu(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();

        Menu menu = menuService.findById(id);
        modelAndView.addObject("menu", menu);

        List<Dish> dishList = menu.getDishes();
        modelAndView.addObject("dishList", dishList);
        modelAndView.addObject("dish", new Dish());

        Map<Dish, String> dishNameList = new HashMap<>();
        for (Dish dish : dishService.findAll()) {
            dishNameList.put(dish, dish.getName());
        }
        modelAndView.addObject("dishNameList", dishNameList);

        modelAndView.setViewName("/admin/menus/show");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/menus/{id}/addDish", method = RequestMethod.POST)
    public String addDishToMenu(@PathVariable("id") Integer menuId, @ModelAttribute("dish") Dish dish) {
        String dishName = dish.getName();
        Dish thisDish = dishService.findByName(dishName);
        Menu menu = menuService.findById(menuId);
        menuService.addDishToMenu(menu, thisDish);
//        menu.getDishes().add(thisDish);
        menuService.save(menu);

        return "redirect:/admin/menus/show/" + menu.getId();
    }

    @RequestMapping(value = "/admin/menus/{menuId}/deleteDish/{dishId}", method = RequestMethod.GET)
    public String deleteDishFromOrder(@PathVariable("menuId") Integer menuId, @PathVariable("dishId") Integer dishId) {
        Menu menu = menuService.findById(menuId);
        List<Dish> dishes = menu.getDishes();
        Iterator<Dish> iterator = dishes.iterator();
        while (iterator.hasNext()) {
            Dish dish = iterator.next();
            if(dish.getId()==dishId) {
                iterator.remove();
                break;
            }
        }
        menuService.save(menu);
        return "redirect:/admin/menus/show/" + menu.getId();
    }


    @RequestMapping(value = "/admin/menus/{id}/delete", method = RequestMethod.GET)
    public String deleteMenu(@PathVariable("id") Integer id) {
        menuService.remove(menuService.findById(id));
        return "redirect:/admin/menus/list";
    }

    @RequestMapping(value = "/admin/menus/add", method = RequestMethod.GET)
    public String showAddMenuForm(Model model) {
        Menu menu = new Menu();
        model.addAttribute("menuForm", menu);
        return "/admin/menus/menuform";
    }

    @RequestMapping(value = "/admin/menus/{id}/update", method = RequestMethod.GET)
    public String updateMenu(@PathVariable Integer id, Model model) {
        Menu menu = menuService.findById(id);
        model.addAttribute("menuForm",menu);
        return "/admin/menus/menuform";
    }
}
