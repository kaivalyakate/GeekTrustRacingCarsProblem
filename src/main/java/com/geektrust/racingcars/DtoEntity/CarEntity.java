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
public class CarEntity {
    
    @NonNull
    private String carId;

    @NonNull
    private String carName;

    @NonNull
    private int baseSpeed;

    @NonNull
    private int topSpeed;

    @NonNull
    private String partListId;

    @NonNull
    private List<Part> addablePartsList;
}
