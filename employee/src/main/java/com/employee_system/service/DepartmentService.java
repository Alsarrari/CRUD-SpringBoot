package com.employee_system.service;

import com.employee_system.exception.DepartmentNotFoundException;
import com.employee_system.model.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    List<Department> departments =new ArrayList<>();

    public void addDepartment(Department department){
        departments.add(department);
    }
    public List<Department> getAllDepartment(){
        return departments;
    }
    public Department getDepartmentById(int id){
        for (Department d : departments){
            if (d.getId()==id){
                return d;
            }
        }
        throw new DepartmentNotFoundException("Department By id");
    }
    public Department updateDepartment(int id , Department department){
        for (Department d : departments){
            if (d.getId()==id){
                d.setName(department.getName());
                d.setLocation(department.getLocation());
                d.setManagerName(department.getManagerName());
                return d;
            }
        }
        throw new DepartmentNotFoundException("Department not found");
    }
    public Department deleteDepartmentById(int id ){
        for (Department d : departments){
            if (d.getId()==id){
                departments.remove(d);
                return d;
            }
        }
        throw new DepartmentNotFoundException("Department not found");
    }
  public List<Department> getDepartmentByName(String name) {
        List<Department> dep =new ArrayList<>();
        for (Department d : departments) {
            if (d.getName().equalsIgnoreCase(name)) {
                dep.add(d);
            }
        }
        if (dep.isEmpty()) {
            throw new DepartmentNotFoundException("Department Name not found");
        }
        return dep;
    }
    public List<Department> getDepartmentByLocation(String location){
        List<Department> dep =new ArrayList<>();
        for (Department d : departments){
            if (d.getLocation().equalsIgnoreCase(location)){
                dep.add(d);
            }
        }
        if (dep.isEmpty()){
            throw new DepartmentNotFoundException("Department Location not found");
        }
        return dep;
    }
    public List<Department>  SearchDepartmentByManagerName(String managerName){
        List<Department> dep =new ArrayList<>();
        for (Department d : departments){
            if (d.getManagerName().equalsIgnoreCase(managerName)){
                dep.add(d);
            }
        }
        if (dep.isEmpty()){
            throw new DepartmentNotFoundException("Department managerName not found");
        }
        return dep;
    }
}
