package com.employee_system.controller;

import com.employee_system.api.ApiResponse;
import com.employee_system.model.Employee;
import com.employee_system.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addEmployee(@Valid @RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse("Employee added successfully",employee));
    }
    @GetMapping
    public ResponseEntity<ApiResponse> getAllEmployee(){
       List<Employee> employee= employeeService.getAllEmployee();
        return ResponseEntity.ok(new ApiResponse("Employee successfully",employee));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getEmployeeById(@PathVariable int id){
        Employee employee=employeeService.getEmployeeById(id);
        return ResponseEntity.ok(new ApiResponse("Employee successfully",employee));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateEmployee(@PathVariable int id,@Valid @RequestBody Employee employee){
        Employee updateEmployee=employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(new ApiResponse("Employee updated  successfully",updateEmployee));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable int id){
       Employee deleteEmployee= employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok(new ApiResponse("Employee deleted  successfully",deleteEmployee));
    }
    
   
    //Employee
    @GetMapping("/name/{name}")
    public ResponseEntity<ApiResponse> searchEmployeeByName(@PathVariable String name){
        List<Employee> result = employeeService.searchByName(name);
        return ResponseEntity.ok(new ApiResponse("Employee successfully",result));
    }
    @GetMapping("/department/{departmentId}")
    public ResponseEntity<ApiResponse> searchByDepartment(@PathVariable int departmentId){
        List<Employee> result = employeeService.searchByDepartment(departmentId);
        return ResponseEntity.ok(new ApiResponse("Employee ID successfully",result));
    }
    @GetMapping("/salary")
    public ResponseEntity<ApiResponse> searchBySalaryGreaterThan(@RequestParam int  salary){
        List<Employee> result = employeeService.searchBySalaryGreaterThan(salary);
        return ResponseEntity.ok(new ApiResponse("Employee Salary successfully",result));
    }
    @GetMapping("/age")
    public ResponseEntity<ApiResponse> searchBetweenAges(@RequestParam int minAge,@RequestParam int maxAge){
        List<Employee> result=employeeService.searchBetweenAges(minAge, maxAge);
        return ResponseEntity.ok(new ApiResponse("Employee Age successfully ",result));
    }
    @GetMapping("/position")
    public ResponseEntity<ApiResponse> searchByPosition(@PathVariable String position ){
        List<Employee> result=employeeService.searchByPosition(position);
        return ResponseEntity.ok(new ApiResponse("Employee position successfully",result));
    }
    @PutMapping("/{id}/increase")
    public ResponseEntity<ApiResponse> increaseSalary(@PathVariable int id, @RequestParam double increase ){
    Employee result=employeeService.increaseSalary(id, increase);
    return ResponseEntity.ok(new ApiResponse("Employee increase successfully",result));
    }
    @PutMapping("/{id}/discount")
    public ResponseEntity<ApiResponse> DecreaseEmployeeSalary(@PathVariable int id,@RequestParam double percentage){
        Employee result=employeeService.DecreaseEmployeeSalary(id, percentage);
        return ResponseEntity.ok(new ApiResponse("Employee discount successfully",result));
    }
    @PutMapping("/{employeeId}/transfer")
    public ResponseEntity<ApiResponse> transferEmployee(@PathVariable int employeeId,@RequestParam int department){
     Employee result =employeeService.transferEmployee(employeeId, department);
     return ResponseEntity.ok(new ApiResponse("Employee transfer successfully",result));
    }
    @GetMapping("/highest-salary")
    public ResponseEntity<ApiResponse> highestSalary() {

        Employee result = employeeService.highestSalary();

        return ResponseEntity.ok(
                new ApiResponse("Highest salary employee", result));
    }
    @GetMapping("/lowest-salary")
    public ResponseEntity<ApiResponse> lowestSalary() {
        Employee result = employeeService.lowestSalary();
        return ResponseEntity.ok(
                new ApiResponse("Lowest salary employee", result));
    }







}
