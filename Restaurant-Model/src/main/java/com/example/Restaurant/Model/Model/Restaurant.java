package com.example.Restaurant.Model.Model;

import lombok.Data;

@Data
public class Restaurant {
    private Long Id;
    private String Name;
    private String Address;
    private String PhoneNumber;
    private String Specialty;
    private String TotalStaff;
}
