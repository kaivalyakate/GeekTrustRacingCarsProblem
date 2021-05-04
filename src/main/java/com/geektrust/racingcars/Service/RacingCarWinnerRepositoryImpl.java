package com.geektrust.racingcars.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.geektrust.racingcars.DataProcessing.CsvProcessing;
import com.geektrust.racingcars.DtoEntity.CarEntity;
import com.geektrust.racingcars.DtoEntity.TeamEntity;
import com.geektrust.racingcars.dto.Car;
import com.geektrust.racingcars.dto.Part;
import com.geektrust.racingcars.dto.Team;

public class RacingCarWinnerRepositoryImpl implements RacingCarWinnerRepository{

    @Override
    public List<Part> GetPartsList(String partListId) throws IOException {
        // TODO Auto-generated method stub
        List<Part> partsData = new CsvProcessing().GetPartCsvData();
        List<Part> partsList = new ArrayList<>();
        for(Part part: partsData){
            if (partListId.equals(part.getPartListId())) {
                partsList.add(part);
            }
        }
        return partsList;
    }

    @Override
    public List<TeamEntity> GetTeamEntityList(List<Team> teams, List<Car> cars) throws IOException {
        // TODO Auto-generated method stub
        List<TeamEntity> teamEntityList = new ArrayList<>();
        for(Team team: teams){
            TeamEntity teamEntity = new TeamEntity(team.getTeamId(), team.getTeamName(), this.GetCarEntityList(cars), team.getFunds());
            teamEntityList.add(teamEntity);
        }
        return teamEntityList;
    }

    @Override
    public List<CarEntity> GetCarEntityList(List<Car> cars) throws IOException {
        // TODO Auto-generated method stub
        List<CarEntity> carsEntityList = new ArrayList<>();
        for(Car car: cars){
            carsEntityList.add(new CarEntity(car.getCarId(), car.getCarName(), car.getBaseSpeed(), car.getTopSpeed(),
                    car.getPartListId(), this.GetPartsList(car.getPartListId())));
        }
        return carsEntityList;
    }
    
}
