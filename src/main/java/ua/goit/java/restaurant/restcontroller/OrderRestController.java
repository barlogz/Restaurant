package ua.goit.java.restaurant.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.goit.java.restaurant.model.Order;
import ua.goit.java.restaurant.service.interfaces.OrderService;

import java.util.List;

@RestController
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/get-json-order", method = RequestMethod.GET)
    public List<Order> order() {
        return orderService.findAll();
    }

    @RequestMapping(value = "/get-json-orderById/{id}", method = RequestMethod.GET)
    public Order orderById(@PathVariable("id") Integer id) {
        return orderService.findById(id);
    }

    @RequestMapping(value = "/get-json-openedOrder", method = RequestMethod.GET)
    public List<Order> openedOrders() {
        return orderService.findAllOpenedOrders();
    }

    @RequestMapping(value = "/get-json-closedOrder", method = RequestMethod.GET)
    public List<Order> closedOrders() {
        return orderService.findAllClosedOrders();
    }
}
