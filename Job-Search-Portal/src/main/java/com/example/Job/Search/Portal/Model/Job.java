package com.example.Job.Search.Portal.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.lang.reflect.Type;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    private String description;

    private String location;

    @Min(value = 20000, message = "Salary should be above 20,000")
    private double salary;

    @Email
    private String companyEmail;

    private String companyName;

    private String employerName;


    @Enumerated(EnumType.STRING)
    private JobType jobType;

    private LocalDate appliedDate;

}
