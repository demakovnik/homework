package ru.demakovnik.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.demakovnik.homework.domain.Employee;
import ru.demakovnik.homework.domain.Project;
import ru.demakovnik.homework.repository.EmployeeRepository;
import ru.demakovnik.homework.repository.ProjectRepository;

import java.util.*;
import java.util.stream.Collectors;

@Controller

public class ProjectController {


    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {

        return "greeting";
    }

    @GetMapping("/project")
    public String projectList(Model model) {
        model.addAttribute("items", projectRepository
                .findAll()
                .stream()
                .sorted(Comparator.comparing(Project::getTitle))
                .collect(Collectors.toList()));
        return "projectList";
    }

    @GetMapping("/project/{project}")
    public String ProjectEditForm(@PathVariable Project project, Model model) {
        model.addAttribute("project", project);
        model.addAttribute("allemployees", employeeRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getFullName))
                .collect(Collectors.toList()));
        model.addAttribute("myemployees", project.getEmployees());
        return "projectEdit";
    }

    @PostMapping("/addproject")
    public String saveProject(@RequestParam("projectId") Project project,
                              @RequestParam String projectTitle,
                              Model model,
                              @RequestParam Map<String,String> form
    ) {
        Project projectFromDbByTitle = projectRepository.findByTitle(projectTitle);

        if (project != null) {
            project.setTitle(projectTitle);
        }
        else if (project == null) {
            if (projectFromDbByTitle != null ) {
                project = new Project("");
                model.addAttribute("project", project);
                model.addAttribute("message", "A project with the same title already exists!");
                return "projectAdd";

            } else {
                project = new Project(projectTitle);
            }
        }

        project.setEmployees(new HashSet<Employee>());
        Set<Employee> employees = project.getEmployees();
        List<Employee> allEmployees = employeeRepository.findAll();
        Set<String> employeesFromForm = form.keySet();
        for (Employee employee: allEmployees) {
            if (employeesFromForm.contains(employee.getFullName())) {
                employees.add(employee);
            }
        }
        projectRepository.save(project);
        return "redirect:/project";
    }

    @GetMapping("/addproject")
    public String addProject(Model model) {
        Project project = new Project("");
        model.addAttribute("project", project);
        return "projectAdd";
    }

    @GetMapping("/project/delete")
    public String deleteProject(@RequestParam("projectId") Project project) {
        projectRepository.deleteById(project.getId());
        return "redirect:/project";
    }


}
