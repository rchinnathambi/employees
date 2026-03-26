package com.rchinnat.employees.model;

import jakarta.validation.constraints.*;
import lombok.Data;

public record EmployeeDTO(
        Integer id,
        @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
        String name,
        @NotEmpty(message = "Profession cannot be empty or null")
        String profession,
        @Pattern(regexp = ("^$|[0-9]{10}"), message = "Mobile number must be of length 10 digits")
        String mobile,
        @NotEmpty(message = "Location cannot be empty or null")
        String location,
        @NotEmpty(message = "Email cannot be empty or null")
        @Email(message = "Email address must be valid")
        String email) {
}
