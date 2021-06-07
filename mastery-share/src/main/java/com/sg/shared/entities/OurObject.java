package com.sg.shared.entities;

import java.util.Objects;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
@Entity
@Table(schema="object_dbTest", name="our_object")
public class OurObject {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    
    @Column
    @NotBlank(message = "Property1 cannot be null")
    private String property1;
    
    @Column
    @Min(value = 5, message = "Property2 should not be less than 5")
    @Max(value = 100, message = "Property2 should not be greater than 100")
    private int property2 = 0;
    
    @Column
    @Size(min = 5, max = 20, message = "Property3 must be between 5 and 20 characters")
    private String property3;

    @Column
    @Email
    private String property4;    
}
