package com.employee_system.model;

import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @Positive(message = "id must be positive")
    private int id;
    @NotBlank(message = "name must be null")
    @Size(min = 2,max = 15,message = "name must be small")
    private String name;
    @Min(value = 20,message = "age must be big")
    @Max(value = 65,message = "age must be small")
    private int age;
    @PositiveOrZero(message = "salary must be positive")
    private double salary;
    @Email
    private String email;
    @NotNull
    private int departmentId;
}
