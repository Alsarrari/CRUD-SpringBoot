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
    public Department getDepartmentByName( String name){
        for (Department d : departments){
            if (d.getName().equals(name)){
                return d;
            }
        }
        throw new DepartmentNotFoundException("Department not found");
    }
    public Department getCountDepartment(int count){
        for (Department d : departments){
            if (d.getId()==count){
                return d;
            }
        }
        throw new DepartmentNotFoundException("Department not found");
    }

    public Department getRenameDepartment(String department){
        for (Department d : departments){
            if (d.getId()== d.getId()){
                return d;
            }
        }
        throw new DepartmentNotFoundException("Department not found");
    }

}
