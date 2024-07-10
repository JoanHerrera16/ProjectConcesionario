package com.ms_concesionario.service.impl;

import com.ms_concesionario.model.CarEntity;
import com.ms_concesionario.service.ICarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class CarServiceImpl implements ICarService {

    public List<CarEntity> carEntities = new ArrayList<>();

    @Override
    public ResponseEntity<CarEntity> save(CarEntity carEntity) {
        var existCar = carEntities
                .stream()
                .anyMatch(
                        p -> p.getName().equalsIgnoreCase(carEntity.getName())
                );

        if(existCar){
            for (CarEntity entity : carEntities) {
                if (Objects.equals(entity.getName(), carEntity.getName())) {
                    carEntity.setStock(
                            entity.getStock() + 1
                    );
                }
            }
        }else{
            carEntity.setStock(1);
        }

        //Random random = new Random();
        carEntity.setId(carEntities.size()+1);
        this.carEntities.add(carEntity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(carEntity);
    }

    @Override
    public ResponseEntity<?> get(int id) {
        for (int i = 0; i<carEntities.size(); i++){
            if(carEntities.get(i).getId() == id){
                carEntities.get(i);
            }
        }
        return ResponseEntity.ok(carEntities);
    }


}
