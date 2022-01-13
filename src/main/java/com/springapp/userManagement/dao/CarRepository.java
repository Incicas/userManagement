package com.springapp.userManagement.dao;

import com.springapp.userManagement.api.CarDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CarRepository {

    private static final Map<Long, CarDTO> cars = new HashMap<>();

    public CarRepository(){
        CarDTO car1 = new CarDTO(1, "bmw", "320",1 );
        CarDTO car2 = new CarDTO(2, "vw", "passat", 2);
        CarDTO car3 = new CarDTO(3, "opel", "astra j", 3);

        cars.put(car1.getUser_id(), car1);
        cars.put(car2.getUser_id(), car2);
        cars.put(car3.getUser_id(), car3);

    }

    public Map<Long, CarDTO> getAllCars(){
        return cars;
    }
    public CarDTO getCarById(long id){
        CarDTO car = cars.get(id);
        return car;
    }
    public CarDTO createCar(CarDTO newCar){
        CarDTO car = cars.put(newCar.getUser_id(), newCar);
        return car;
    }
    public CarDTO updateCar(CarDTO carUpdated){
        CarDTO car = cars.put(carUpdated.getUser_id(), carUpdated);
        return car;
    }
   public void deleteCar(long id){
        cars.remove(id);
   }


}
