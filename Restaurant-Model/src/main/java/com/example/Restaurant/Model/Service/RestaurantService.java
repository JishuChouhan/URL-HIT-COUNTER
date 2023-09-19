package com.example.Restaurant.Model.Service;

import com.example.Restaurant.Model.Model.Restaurant;
import com.example.Restaurant.Model.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant findById(Long id) {
        return restaurantRepository.findById(id);
    }

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    public String save(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return "Restaurant Saved";
    }

    public String delete(Long id) {
        restaurantRepository.delete(id);
        return "Restaurant Deleted";
    }
}
