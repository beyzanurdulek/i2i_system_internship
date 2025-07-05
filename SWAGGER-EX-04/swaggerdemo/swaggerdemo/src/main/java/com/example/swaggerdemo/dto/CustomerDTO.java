package com.example.swaggerdemo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter, toString, equals vs. otomatik oluşturur
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    @Schema(description = "Unique ID of the customer", example = "1")
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Schema(description = "Full name of the customer", example = "John Doe")
    private String name;

    @Email(message = "Email should be valid")
    @Schema(description = "Email address", example = "john.doe@example.com")
    private String email;
}
