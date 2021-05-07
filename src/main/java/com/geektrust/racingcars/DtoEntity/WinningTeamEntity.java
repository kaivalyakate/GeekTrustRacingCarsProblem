package com.geektrust.racingcars.DtoEntity;

import java.util.List;

import com.geektrust.racingcars.dto.Part;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WinningTeamEntity {
    
    @NonNull
    private String teamName;

    @NonNull
    private String carName;

    @NonNull
    private int speedAchieved;

    @NonNull
    private int fundsSpent;

    @NonNull
    private List<Part> partList;
}
