package demo.service;

import demo.entity.Department;
import demo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);

   public List<Department> fetchDepartmentList();

   public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

   public void deleteDepartmentById(Long id);

   public Department updateDepartmentById(Long id, Department department);


  public Department fetchDepartmentByName(String name);
}
