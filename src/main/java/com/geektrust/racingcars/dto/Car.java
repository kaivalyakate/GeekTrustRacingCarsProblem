package com.geektrust.racingcars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    
    @JsonProperty("car_id")
    private String carId;

    @JsonProperty("car_name")
    private String carName;

    @JsonProperty("base_speed")
    private int baseSpeed;

    @JsonProperty("top_speed")
    private int topSpeed;

    @JsonProperty("part_list_id")
    private String partListId;
    
}
