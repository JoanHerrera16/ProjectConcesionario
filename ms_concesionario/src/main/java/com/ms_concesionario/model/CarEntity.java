package com.ms_concesionario.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarEntity {
    private int id;
    private String name;
    private int stock;
    private double price;
    private boolean status;
}
