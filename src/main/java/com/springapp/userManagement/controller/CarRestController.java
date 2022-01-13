package com.springapp.userManagement.controller;


import com.springapp.userManagement.api.CarDTO;
import com.springapp.userManagement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/users/{user_id}/cars")
public class CarRestController {

    @Autowired
    private CarService carService;


    @GetMapping
    public ResponseEntity<List<CarDTO>> getCars(@PathVariable long user_id){
        List<CarDTO> cars = carService.getAllCars(user_id);

        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable long id, @PathVariable long user_id){
        CarDTO car = carService.getCarById(id, user_id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO newCar){
        CarDTO car = carService.createCar(newCar);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDTO> carUpdate(@PathVariable long id, @RequestBody CarDTO carUpdated){
        CarDTO car = carService.updateCar(id, carUpdated);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCar(@PathVariable long id, @PathVariable long user_id){
        carService.deleteCar(id, user_id);

        return new ResponseEntity(HttpStatus.OK);
    }

}
