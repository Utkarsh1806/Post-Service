package demo.controller;

import demo.entity.Department;
import demo.error.DepartmentNotFoundException;
import demo.service.DepartmentService;
import demo.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment( @Valid @RequestBody Department department)
    {
        logger.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()
    {
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id")Long id) throws DepartmentNotFoundException {
        logger.info("inside FetchDepartment by iD");
        return departmentService.fetchDepartmentById(id);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id")Long id)
    {
        departmentService.deleteDepartmentById(id);
        return "Department deleted successfully";
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long id, @RequestBody Department department)
    {
        return departmentService.updateDepartmentById(id, department);
    }

    @GetMapping("/departments/name/{name}")
   public Department fetchDepartmentByName(@PathVariable("name") String name)
   {
       return departmentService.fetchDepartmentByName(name);
   }
}
