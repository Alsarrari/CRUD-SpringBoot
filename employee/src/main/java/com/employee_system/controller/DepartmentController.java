package com.employee_system.controller;

import com.employee_system.api.ApiResponse;
import com.employee_system.model.Department;
import com.employee_system.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
@PostMapping
    public ResponseEntity<ApiResponse> addDepartment(@Valid @RequestBody Department department){
        departmentService.addDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse("Department added successfully",department));
    }
    @GetMapping
    public ResponseEntity<ApiResponse> getAllDepartment(){
        List<Department> getDepartment=departmentService.getAllDepartment();
        return ResponseEntity.ok(new ApiResponse("Department successfully",getDepartment));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getDepartmentById(@PathVariable int id){
       Department department= departmentService.getDepartmentById(id);
        return ResponseEntity.ok(new ApiResponse("Department successfully",department));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateDepartment(@PathVariable int id, @Valid @RequestBody Department department){
        Department updateDepartment=departmentService.updateDepartment(id,department);
        return ResponseEntity.ok(new ApiResponse("Department updated successfully" ,updateDepartment));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteDepartmentById(@PathVariable int id){
       Department department= departmentService.deleteDepartmentById(id);
        return ResponseEntity.ok(new ApiResponse("Department deleted successfully",department));
    }
    
    @GetMapping("/search")
    public ResponseEntity<ApiResponse> getDepartmentByName(@RequestParam String name){
        List<Department> result =departmentService.getDepartmentByName(name);
        return ResponseEntity.ok(new ApiResponse("Department Name successfully",result));
    }
    @GetMapping("/search")
    public ResponseEntity<ApiResponse> getDepartmentByLocation(@RequestParam String location){
       List<Department> result=departmentService.getDepartmentByLocation(location);
       return ResponseEntity.ok(new ApiResponse("Department location successfully",result));
    }
    @GetMapping("/search")
    public ResponseEntity<ApiResponse> SearchDepartmentByManagerName(@RequestParam String managerName){
        List<Department> result=departmentService.SearchDepartmentByManagerName(managerName);
        return ResponseEntity.ok(new ApiResponse("Department managerName successfully",result));
    }

}
