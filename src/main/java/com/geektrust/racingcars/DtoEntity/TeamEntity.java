package com.geektrust.racingcars.DtoEntity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamEntity {
    
    @NonNull
    private int teamId;

    @NonNull
    private String teamName;

    @NonNull
    private List<CarEntity> cars;

    @NonNull
    private int funds;
}
