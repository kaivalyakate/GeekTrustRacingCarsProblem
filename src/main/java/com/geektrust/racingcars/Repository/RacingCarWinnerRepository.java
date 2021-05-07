package com.geektrust.racingcars.Repository;

import java.io.IOException;
import java.util.List;

import com.geektrust.racingcars.DtoEntity.CarEntity;
import com.geektrust.racingcars.DtoEntity.TeamEntity;
import com.geektrust.racingcars.dto.Car;
import com.geektrust.racingcars.dto.Part;
import com.geektrust.racingcars.dto.Team;

/**
 * All the Operations Related to Fetching the right data from the dataset
 */
public interface RacingCarWinnerRepository {
    
    public List<Part> GetPartsList(String partListId) throws IOException;

    public List<TeamEntity> GetTeamEntityList(List<Team> teams, List<Car> cars) throws IOException;

    public List<CarEntity> GetCarEntityList(List<Car> cars, List<String> teamCars) throws IOException;

}
