package com.employee_system.service;

import com.employee_system.exception.EmployeeNotFoundException;
import com.employee_system.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
    private List<Employee> employees =new ArrayList<>();

    public void addEmployee(Employee employee){
        employees.add(employee);
    }
    public List<Employee> getAllEmployee(){
        return employees;
    }
    public Employee getEmployeeById(int id){
        for (Employee e : employees){
            if (e.getId()==id){
                return e;
            }
        }
        throw new EmployeeNotFoundException("Employee not found");
    }
    public Employee updateEmployee(int id , Employee employee){
        for (Employee e : employees){
            if (e.getId()==id){
                e.setName(employee.getName());
                e.setAge(employee.getAge());
                e.setSalary(employee.getSalary());
                e.setEmail(employee.getEmail());
                e.setDepartmentId(employee.getDepartmentId());
                return e;
            }
        }
        throw new EmployeeNotFoundException("Employee not found");
    }
    public Employee deleteEmployeeById(int id){
        for (Employee e : employees){
            if (e.getId()==id){
                employees.remove(e);
                return e;
            }
        }
        throw new EmployeeNotFoundException("Employee not found ");
    }
    public List<Employee>  searchByName(String name){
        List<Employee> employees1=new ArrayList<>();
        for (Employee e : employees){
            if (e.getName().equals(name)){
                employees1.add(e);
            }
        }
        if (employees1.isEmpty()){
            throw new EmployeeNotFoundException("Employee not found");
        }
        return employees1;
    }
    public List<Employee> searchByDepartment(int departmentId){
        List<Employee> employees1=new ArrayList<>();
        for (Employee e : employees){
            if (e.getDepartmentId()==departmentId){
                employees1.add(e);
            }
        }
        if (employees1.isEmpty()){
        throw new EmployeeNotFoundException("Employee not found");
    }
        return employees1;
    }
    public Employee searchBySalaryGreaterThan(int salary){
        for (Employee e : employees){
            if (e.getSalary()>=10000){
                return e;
            }
        }
        throw new EmployeeNotFoundException("Employee not found");
    }
    public Employee searchBetweenAges(int age){
        for (Employee e : employees){
            if (e.getAge()>=20 && e.getAge()<=30){
                return e;
            }
        }
        throw new EmployeeNotFoundException("Employee not found");
    }
    public Employee searchByPosition(int department){
    for (Employee e : employees){
        if (e.getDepartmentId()==department){
            return e;
        }
    }
    throw new EmployeeNotFoundException("Employee not found");
    }



}
