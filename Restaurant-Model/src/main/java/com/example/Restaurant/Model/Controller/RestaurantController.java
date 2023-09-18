package com.example.Restaurant.Model.Controller;

import com.example.Restaurant.Model.Model.Restaurant;
import com.example.Restaurant.Model.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/{Id}")
    public Restaurant getRestaurantById(@PathVariable Long Id) {
        return restaurantService.findById(Id);
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.findAll();
    }

    @PostMapping
    public String addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.save(restaurant);
    }
    @PutMapping("/{Id}")
    public String updateRestaurant(@PathVariable Long Id, @RequestBody Restaurant updateRestaurant) {
        Restaurant restaurant = restaurantService.findById(Id);
        if (restaurant != null) {
            restaurant.setSpecialty(updateRestaurant.getSpecialty());

            return restaurantService.save(restaurant);
        }
        return "Restaurant not Found";
    }
    public String deleteRestaurant(@PathVariable Long Id){
        return restaurantService.delete(Id);
    }
}
