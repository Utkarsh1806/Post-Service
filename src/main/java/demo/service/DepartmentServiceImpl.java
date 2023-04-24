package demo.service;

import demo.entity.Department;
import demo.error.DepartmentNotFoundException;
import demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException {

       Optional<Department> department = departmentRepository.findById(id);
       if(!department.isPresent()) {
           throw new DepartmentNotFoundException("Department not Available");
       }
       return department.get();
    }
    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartmentById(Long id, Department department) {
        Department dep = departmentRepository.findById(id).get();
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            dep.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            dep.setDepartmentName(department.getDepartmentName());

        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            dep.setDepartmentAddress(department.getDepartmentAddress());

        }
        return departmentRepository.save(dep);
    }

    @Override
    public Department fetchDepartmentByName(String name) {
//        Department db= departmentRepository.findBydepartmentName(name);
//        if(db!=null) return db;
        return departmentRepository.findBydepartmentNameIgnoreCase(name);
    }


}
