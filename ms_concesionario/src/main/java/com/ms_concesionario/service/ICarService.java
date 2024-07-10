package com.ms_concesionario.service;

import com.ms_concesionario.model.CarEntity;
import org.springframework.http.ResponseEntity;

public interface ICarService {
    ResponseEntity<CarEntity> save(CarEntity carEntity);
    ResponseEntity<?> get(int i);
}
