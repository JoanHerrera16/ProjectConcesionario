package com.ms_concesionario.controller;

import com.ms_concesionario.model.CarEntity;
import com.ms_concesionario.service.ICarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/concesionario")
public class CarController {
     private final ICarService iCarService;

    public CarController(ICarService iCarService) {
        this.iCarService = iCarService;
    }

    @PostMapping
    public ResponseEntity<CarEntity> create(@RequestBody CarEntity carEntity){// request body es para que se mande por el body de la consulta
        return this.iCarService.save(carEntity);
    }

    @GetMapping()
    public ResponseEntity get(int id){
        return this.iCarService.get(id);
    }


    //@DeleteMapping

}
