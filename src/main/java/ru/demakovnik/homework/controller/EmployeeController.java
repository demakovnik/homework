package ru.demakovnik.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.demakovnik.homework.domain.Employee;
import ru.demakovnik.homework.repository.EmployeeRepository;

import java.util.Comparator;
import java.util.stream.Collectors;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public String employeeList(Model model) {
        model.addAttribute("items", employeeRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getFullName))
                .collect(Collectors.toList()));
        return "employeeList";
    }

    @GetMapping("/employee/{employee}")
    public String ProjectEditForm(@PathVariable Employee employee, Model model) {
        model.addAttribute("employee", employee);
        return "employeeEdit";
    }

    @PostMapping("/addemployee")
    public String saveEmployee(@RequestParam("employeeId") Employee employee,
                              @RequestParam String fullName,
                              Model model
    ) {
        if (employee == null) {
            employee = new Employee("");
        }
        employee.setFullName(fullName);
        employeeRepository.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/addemployee")
    public String addEmployee(Model model) {
        Employee employee = new Employee("");
        model.addAttribute("employee", employee);
        return "employeeAdd";
    }

    @GetMapping("/employee/delete")
    public String deleteEmployee(@RequestParam("employeeId") Employee employee) {
        employeeRepository.deleteById(employee.getId());
        return "redirect:/employee";
    }


}
