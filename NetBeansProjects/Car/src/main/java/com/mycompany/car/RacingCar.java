/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.car;

/**
 *
 * @author Last_
 */
public class RacingCar extends Car{
    private float maxSpeed;
    private boolean hoodband;
    
    public RacingCar (String make, String model, String year, String transmision, String color, String engine, String vinNumber, float maxSpeed, boolean hoodband) {
        super(make, model, year, transmision, color, engine, vinNumber);
        this.hoodband = hoodband;
        this.maxSpeed = maxSpeed;
    }
}
