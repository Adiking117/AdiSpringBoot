package com.adi.payroll.controller;

import com.adi.payroll.entity.Employee;
import com.adi.payroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String initializeEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "emp";
    }

    @PostMapping
    public String saveEmployeeData(@ModelAttribute Employee employee, Model model) {
        try {
            employeeService.saveEmployee(employee);
            model.addAttribute("message", "Employee Saved Successfully!");
        } catch (Exception e) {
            model.addAttribute("message", "Error: " + e.getMessage());
        }
        return "emp";
    }

    // @GetMapping(value="getAllEmployees",produces="application/json")
    @GetMapping("/getAllEmployees")
    @ResponseBody
    public Collection<Employee> getAllEmployees(@ModelAttribute Employee employee) {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getAllEmployeesPage")
    public String getAllEmployeesPage(@ModelAttribute Employee employee,Model model) {
        model.addAttribute("employees",employeeService.getAllEmployees());
        return "allemps";
    }

}
