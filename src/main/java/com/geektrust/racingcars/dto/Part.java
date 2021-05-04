package com.geektrust.racingcars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Part {
    
    @JsonProperty("part_list_id")
    private String partListId;

    @JsonProperty("part_id")
    private String partId;

    @JsonProperty("price")
    private int price;

    @JsonProperty("speed_boost")
    private int speedBoost;
}
