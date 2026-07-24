package com.employee_system.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {
    @Positive(message = "id must be positive")
    private int id;
    @NotBlank(message = "name must be null")
    @Size(min = 2,max = 15,message = "name must be big")
    private String name;
    @NotBlank(message = "managerName not null")
    @Size(min = 2,max = 15,message = "managerName must be big")
    private String managerName;
    @NotBlank(message = "location is exist")
    private String location;
}
