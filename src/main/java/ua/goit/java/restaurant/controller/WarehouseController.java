package ua.goit.java.restaurant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.goit.java.restaurant.model.Ingredient;
import ua.goit.java.restaurant.model.Measure;
import ua.goit.java.restaurant.model.Warehouse;
import ua.goit.java.restaurant.service.interfaces.IngredientService;
import ua.goit.java.restaurant.service.interfaces.WarehouseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private IngredientService ingredientService;

    private static final Logger LOGGER = LoggerFactory.getLogger(Warehouse.class);

    @RequestMapping(value = "/admin/warehouses/list", method = RequestMethod.GET)
    public String warehouseCtrl(Model model) {
        List<Warehouse> warehouses = warehouseService.findAll();
        /*for (Warehouse warehouse : warehouses) {
            System.out.println(warehouse.toString());
        }*/
        model.addAttribute("warehouses", warehouses);
        return "/admin/warehouses/list";
    }

    @RequestMapping(value = "/admin/warehouses/list", method = RequestMethod.POST)
    public String saveOrUpdateWarehouse(@ModelAttribute("warehouseForm") @Validated Warehouse warehouse, BindingResult result) {
        if (result.hasErrors()) {
            return "/admin/warehouses/warehouseform";
        }
        String ingrName = warehouse.getIngredient().getName();
        Ingredient actualIngredient = ingredientService.findByName(ingrName);
        warehouse.setIngredient(actualIngredient);
        warehouseService.save(warehouse);
        return "redirect:/admin/warehouses/list";
    }

    @RequestMapping(value = "/admin/warehouses/add", method = RequestMethod.GET)
    public String showAddWarehouseForm(ModelMap modelMap) {

        Warehouse warehouse = new Warehouse();

        modelMap.addAttribute("warehouseForm", warehouse);

        Map<Ingredient, String> ingredientMap = new HashMap<>();
        for (Ingredient item : ingredientService.findAll()) {
            ingredientMap.put(item, item.getName());
        }
        modelMap.addAttribute("ingredientNameList", ingredientMap);

        return "/admin/warehouses/warehouseform";
    }


    @RequestMapping(value = "/admin/warehouses/{id}/update", method = RequestMethod.GET)
    public String showAddWarehouseForm(@PathVariable("id") Integer id, ModelMap modelMap) {
        LOGGER.debug("showUpdateWarehouseForm() : {}", id);
        modelMap.addAttribute("measures", Measure.values());
        Warehouse warehouse = warehouseService.load(id);
        modelMap.addAttribute("warehouseForm", warehouse);
        return "/admin/warehouses/warehouseformupdate";
    }


    @RequestMapping(value = "/admin/warehouses/{id}/delete", method = RequestMethod.GET)
    public String deleteWarehouseCtrl(@PathVariable("id") Integer id) {
        warehouseService.remove(warehouseService.load(id));
        return "redirect:/admin/warehouses/list";
    }

    @RequestMapping(value = "/admin/warehouses/search", method = RequestMethod.GET)
    public String searchByName(@RequestParam("name") String name, ModelMap modelMap) {
        if (name==null || name=="") {
            return "redirect:/admin/warehouses/list";
        } else {
            Warehouse warehouse = warehouseService.findByName(name);
            modelMap.addAttribute("warehouse", warehouse);
            return "/admin/warehouses/search";
        }
    }
}
