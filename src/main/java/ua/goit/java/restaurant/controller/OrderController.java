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
import org.springframework.web.servlet.ModelAndView;
import ua.goit.java.restaurant.model.Dish;
import ua.goit.java.restaurant.model.Employee;
import ua.goit.java.restaurant.model.Order;
import ua.goit.java.restaurant.model.OrderStatus;
import ua.goit.java.restaurant.service.interfaces.DishService;
import ua.goit.java.restaurant.service.interfaces.EmployeeService;
import ua.goit.java.restaurant.service.interfaces.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrderController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DishService dishService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/orders/list", method = RequestMethod.GET)
    public String orderCtrl(ModelMap modelMap) {
        List<Order> orders = orderService.findAll();
        modelMap.addAttribute("ordersAttr", orders);
        return "/orders/list";
    }
//    public String orderCtrl(Model model) {
//        model.addAttribute("ordersAttr", orderService.findAll());
//        return "/orders/list";
//    }

    @RequestMapping(value = "/orders/list", method = RequestMethod.POST)
    public String saveOrUpdateOrder(@ModelAttribute("orderForm") @Validated Order order, BindingResult result) {
        if (result.hasErrors()) {
            return "/orders/orderform";
        }

        if(order.getId()!=null) {
            Order updatedOrder = orderService.findById(order.getId());

            Employee waiter = employeeService.findByName(updatedOrder.getWaiter().getFirstName());
            updatedOrder.setWaiter(waiter);
            updatedOrder.setTableNumber(order.getTableNumber());
            updatedOrder.setOrderDate(order.getOrderDate());
            updatedOrder.setOrderStatus(order.getOrderStatus());

//            System.out.println(updatedOrder.toString());
            orderService.save(updatedOrder);
        } else {
            Employee waiter = employeeService.findByName(order.getWaiter().getFirstName());
            order.setWaiter(waiter);
            orderService.save(order);
        }
        return "redirect:/orders/list";
    }

    @RequestMapping(value = "/orders/{id}/delete")
    public String deleteCtrl(@PathVariable("id") Integer id) {
        Order order = orderService.findById(id);
        orderService.remove(order);
        return "redirect:/orders/list";
    }

    @RequestMapping(value = "/orders/show/{id}", method = RequestMethod.GET)
    public ModelAndView showOrder(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Order order = orderService.findById(id);
        modelAndView.addObject("order", order);

        List<Dish> dishList = order.getDishes();
        modelAndView.addObject("dishList", dishList);

        modelAndView.addObject("dish", new Dish());


        modelAndView.setViewName("/orders/show");

        return modelAndView;
    }

    @RequestMapping(value = "/orders/{id}/addDish", method = RequestMethod.POST)
    public String addDishToOrder(@PathVariable("id") Integer id, @ModelAttribute("dish") Dish dish) {
//        String dishName = dish.getName();
//        Dish thisDish = dishService.findByName(dishName);
//        Order order = orderService.findById(id);
//        order.getDishes().add(thisDish);

        Order order = orderService.findById(id);
        String dishName = dish.getName();
        Dish thisDish = dishService.findByName(dishName);
        List<Dish> dishes = order.getDishes();
        dishes.add(thisDish);
        order.setDishes(dishes);

        orderService.save(order);
        return "redirect:/orders/show/" + order.getId();
    }

    @RequestMapping(value = "/orders/{orderId}/deleteDish/{dishId}", method = RequestMethod.GET)
    public String deleteDishFromOrder(@PathVariable("orderId") Integer orderId, @PathVariable("dishId") Integer dishId) {
        Order order = orderService.findById(orderId);
        List<Dish> dishes = order.getDishes();
        Dish thisDish = dishService.findById(dishId);
        if (dishes.contains(thisDish)) {
            dishes.remove(dishes.lastIndexOf(thisDish));
        }
        orderService.save(order);
        return "redirect:/orders/show/" + order.getId();
    }

    @RequestMapping(value = "/orders/add", method = RequestMethod.GET)
    public String addOrder(ModelMap modelMap) {
        Order order = new Order();

        modelMap.addAttribute("orderForm", order);
        modelMap.addAttribute("listOfOrderStatus", OrderStatus.values());

        return "/orders/orderform";
    }

    @RequestMapping(value = "/orders/{id}/update", method = RequestMethod.GET)
    public String updateOrder(@PathVariable("id") Integer id, ModelMap modelMap) {
        Order order = orderService.findById(id);
        List<Dish> dishes = order.getDishes();

        //redirectAttributes.addFlashAttribute("updatedDishes", dishes);
        modelMap.addAttribute("updatedDishes", dishes);
        modelMap.addAttribute("orderForm", order);

        return "/orders/orderform";
    }


    @ModelAttribute("waiterNames")
    public List<String> getWaiterNames() {
        return employeeService.findAll().stream().map(Employee::getFirstName).collect(Collectors.toList());
    }

    @ModelAttribute("dishNames")
    public List<String> getDishNames() {
        return dishService.findAll().stream().map(Dish::getName).collect(Collectors.toList());
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
