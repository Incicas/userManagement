package com.springapp.userManagement.service;


import com.springapp.userManagement.api.CarDTO;
import com.springapp.userManagement.api.UserDTO;
import com.springapp.userManagement.dao.CarRepository;
import com.springapp.userManagement.exception.CarNotFoundException;
import com.springapp.userManagement.exception.UserDoesNotHaveCarsException;
import com.springapp.userManagement.exception.UserNotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CarService {

    private CarRepository carRepository;
    private UserService userService;

    @Autowired
    public CarService(CarRepository carRepository, UserService userService){
        this.carRepository = carRepository;
        this.userService = userService;
    }

    public List<CarDTO> getAllCars(long user_id)  {
        List<CarDTO> cars = new ArrayList<>();
        List<CarDTO> userCars = new ArrayList<>();
        checkUserId(user_id);

        for (Map.Entry<Long, CarDTO> entry : carRepository.getAllCars().entrySet()) {
            cars.add(entry.getValue());
        }
        for (CarDTO car : cars) {
            if (car.getUser_id() == user_id) {
                userCars.add(car);
            }
        }
        if (cars.isEmpty()) {
            throw new UserDoesNotHaveCarsException("This user with id " + user_id + " does not have any car.");
        }
        return cars;
    }

    public CarDTO getCarById(long id, long user_id){
        CarDTO car = carRepository.getCarById(id);
        if (car == null){
            throw new CarNotFoundException("The car with id "+id+" does not exist.");
        }
        UserDTO user = userService.getUserById(user_id);
        if (car.getUser_id() != user_id){
            throw new UserNotFoundException("This user does not exist.");
        }
        return car;
    }

    public CarDTO createCar(CarDTO newCar){
        checkUserId(newCar.getUser_id());
        carRepository.createCar(newCar);
        return newCar;
    }

    public CarDTO updateCar(long id, CarDTO carUpdated) {
        CarDTO car = carRepository.getCarById(id);
        if (car == null) {
            throw new CarNotFoundException("The car with id " + id + " does not exist.");
        }
        checkUserId(car.getUser_id());
        carRepository.deleteCar(id);
        carRepository.updateCar(carUpdated);
        return carUpdated;
    }
    public void deleteCar(long id, long user_id){
        checkUserId(user_id);
        CarDTO car = carRepository.getCarById(id);
        if (car == null){
            throw new CarNotFoundException("The car with id " + id + " does not exist.");
        }
        carRepository.deleteCar(id);
    }
    private void checkUserId(long user_id){
        userService.getUserById(user_id);
    }

}
