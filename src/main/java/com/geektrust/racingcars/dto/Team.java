package com.geektrust.racingcars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    
    @JsonProperty("team_id")
    private int teamId;

    @JsonProperty("team_name")
    private String teamName;

    @JsonProperty("cars")
    private String cars;
 
    @JsonProperty("funds")
    private int funds;

    public int getFunds(){
        return funds;
    }
}
