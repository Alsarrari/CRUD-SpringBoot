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
   
public List<Employee> searchBySalaryGreaterThan(int salary){
        List<Employee> result=new ArrayList<>();
        for (Employee e : employees){
            if (e.getSalary()>=salary){
                result.add(e);
            }
        }
        if (result.isEmpty()){
            throw new EmployeeNotFoundException("Employee not found");
        }
       return result;
    }
    public List<Employee> searchBetweenAges(int minAge , int maxAge){
        List<Employee> result=new ArrayList<>();
        for (Employee e : employees){
            if (e.getAge()>=minAge && e.getAge()<=maxAge){
                result.add(e);
            }
        }
        if (result.isEmpty()){
            throw new EmployeeNotFoundException("Employee not found");
        }
      return result;
    }
    public List<Employee> searchByPosition(String position){
        List<Employee> result=new ArrayList<>();
    for (Employee e : employees){
        if (e.getPosition().equals(position)){
            result.add(e);
        }
    }
    if (result.isEmpty()){
        throw new EmployeeNotFoundException("Employee not found");
    }
   return result;
    }
    public Employee increaseSalary(int id , double percentage){
        for (Employee e : employees){
            if (e.getId()==id){
              double increase  = e.getSalary()*percentage/100;
              e.setSalary(e.getSalary()+increase);
              return e;
            }
        }
        throw new EmployeeNotFoundException("Employee not found");
    }
    public Employee DecreaseEmployeeSalary(int id , double percentage){
        for (Employee e : employees){
            if (e.getId()==id){
                double discount = e.getSalary()*percentage%100;
                e.setSalary(e.getSalary()-discount);
                return e;
            }
        }
        throw new EmployeeNotFoundException("Employee not found");
    }
    public Employee transferEmployee(int employeeId, int departmentId) {

        for (Employee e : employees) {

            if (e.getId() == employeeId) {

                e.setDepartmentId(departmentId);

                return e;
            }
        }

        throw new EmployeeNotFoundException("Employee not found");
    }
    public Employee highestSalary() {
        if (employees.isEmpty()) {
            throw new EmployeeNotFoundException("Employees not found");
        }
        Employee highest = employees.get(0);
        for (Employee e : employees) {
            if (e.getSalary() > highest.getSalary()) {
                highest = e;
            }
        }
        return highest;
    }
    public Employee lowestSalary(){
        if (employees.isEmpty()){
            throw new EmployeeNotFoundException("Employees not found");
        }
        Employee lowest = employees.get(0);
        for (Employee e : employees){
            if (e.getSalary()< lowest.getSalary()){
                lowest=e;
            }
        }
        return lowest;
    }



}
