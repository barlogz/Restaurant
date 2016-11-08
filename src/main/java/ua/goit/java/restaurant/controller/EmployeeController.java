package ua.goit.java.restaurant.controller;

import org.apache.commons.codec.binary.Base64;
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

import java.io.UnsupportedEncodingException;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @RequestMapping(value = "/admin/employees/list", method = RequestMethod.GET)
    public String listEmployees(Map<String, Object> model) {
        model.put("employees", employeeService.findAll());
        return "/admin/employees/list";
    }

    @RequestMapping(value = "/admin/employees/list", method = RequestMethod.POST)
    public String saveOrUpdateEmployee(@ModelAttribute("employeeForm")
                                           @Validated Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "/admin/employees/employeeform";
        } else {
            employeeService.save(employee);
            return "redirect:/admin/employees/list";

        }
    }

    @RequestMapping(value = "/admin/employees/show/{id}", method = RequestMethod.GET)
    public ModelAndView showEmployee(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Employee employee = employeeService.findByID(id);
        modelAndView.addObject("employee", employee);

        if (employee.getContent() != null) {
            byte[] encoded = Base64.encodeBase64(employeeService.findByID(id).getContent());
            try {
                String encodedString = new String(encoded, "UTF-8");
                modelAndView.addObject("photo", encodedString);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("Can't display image!");
            }
        }

        modelAndView.setViewName("/admin/employees/show");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/employees/{id}/delete", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") Integer id) {
        Employee employee = employeeService.findByID(id);
        employeeService.remove(employee);

        return "redirect:/admin/employees/list";
    }

    @RequestMapping(value = "/admin/employees/add", method = RequestMethod.GET)
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("listOfPositions", Position.values());

        Employee employee = new Employee();

        model.addAttribute("employeeForm", employee);
        return "/admin/employees/employeeform";
    }

    @RequestMapping(value = "/admin/employees/{id}/update", method = RequestMethod.GET)
    public String showUpdateEmployeeForm(@PathVariable("id") Integer id, Model model) {

        LOGGER.debug("showUpdateEmployeeForm() : {}", id);

        Employee employee = employeeService.findByID(id);
        model.addAttribute("employeeForm", employee);
        return "/admin/employees/employeeform";
    }
}
