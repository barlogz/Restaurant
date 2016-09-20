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
import ua.goit.java.restaurant.model.Employee;
import ua.goit.java.restaurant.model.Position;
import ua.goit.java.restaurant.service.interfaces.EmployeeService;

import java.sql.Date;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @RequestMapping(value = "employees/list", method = RequestMethod.GET)
    public String listEmployees(Map<String, Object> model) {
        model.put("employees", employeeService.findAll());
        return "/employees/list";
    }

    @RequestMapping(value = "employees/list", method = RequestMethod.POST)
    public String saveOrUpdateEmployee(@ModelAttribute("employeeform")
                                           @Validated Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "employees/employeeform";
        } else {
            employeeService.save(employee);
            // POST/REDIRECT/GET
            // return "redirect:/employee/" + employee.getName();
            return "redirect:/employees/list";

            // POST/FORWARD/GET
            // return "employees/list";
        }
    }

    @RequestMapping(value = "/employees/show/{employeeName}", method = RequestMethod.GET)
    public ModelAndView showEmployee(@PathVariable String employeeName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee", employeeService.findByName(employeeName));
        modelAndView.setViewName("/employee/show");
        return modelAndView;
    }

    @RequestMapping(value = "/employees/{id}/delete", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") Integer id) {
        Employee employee = employeeService.findByID(id);
        employeeService.remove(employee);

        return "redirect:/employees/list";
    }

        @RequestMapping(value = "/employees/add", method = RequestMethod.GET)
    public String showAddEmployeeForm(Model model) {
            model.addAttribute("listOfPositions", Position.values());

            Employee employee = new Employee();

            employee.setFirstName("Best");
            employee.setLastName("Admin");
            employee.setBirthday(Date.valueOf("1901-01-31"));
            employee.setPhoneNumber("+38(099)999-00-01");
            employee.setPosition(Position.ADMINISTRATOR);
            employee.setSalary(1000000);

            model.addAttribute("employeeform", employee);
            return "/employees/employeeform";
    }

    @RequestMapping(value = "/employees/{id}/update", method = RequestMethod.GET)
    public String showUpdateEmployeeform(@PathVariable("id") Integer id, Model model) {

        LOGGER.debug("showUpdateEmployeeform() : {}", id);

        Employee employee = employeeService.findByID(id);
        model.addAttribute("employeeform", employee);
        return "/employees/employeeform";
    }
 }
