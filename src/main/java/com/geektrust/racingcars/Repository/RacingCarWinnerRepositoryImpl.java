package com.geektrust.racingcars.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.geektrust.racingcars.DataProcessing.CsvProcessing;
import com.geektrust.racingcars.DtoEntity.CarEntity;
import com.geektrust.racingcars.DtoEntity.TeamEntity;
import com.geektrust.racingcars.dto.Car;
import com.geektrust.racingcars.dto.Part;
import com.geektrust.racingcars.dto.Team;

public class RacingCarWinnerRepositoryImpl implements RacingCarWinnerRepository{

    private List<String> cars(List<Team> teams, int teamId){
        List<String> cars = new ArrayList<>();
        for(Team x: teams){
            if(x.getTeamId()==teamId){
                cars.add(x.getCars());
            }
        }
        return cars;
    }

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
        Map<Integer, TeamEntity> teamMap = new LinkedHashMap<>();
        for(Team team: teams){
            if(!teamMap.containsKey(team.getTeamId())){
                TeamEntity teamEntity = new TeamEntity(team.getTeamId(), team.getTeamName(),
                        this.GetCarEntityList(cars, cars(teams, team.getTeamId())), team.getFunds());
                teamEntityList.add(teamEntity);
                teamMap.put(teamEntity.getTeamId(), teamEntity);
            }
        }
        return teamEntityList;
    }

    @Override
    public List<CarEntity> GetCarEntityList(List<Car> cars, List<String> teamCars) throws IOException {
        // TODO Auto-generated method stub
        List<CarEntity> carsEntityList = new ArrayList<>();
        for(Car car: cars){
            for(String x: teamCars){
                if(x.equals(car.getCarId())){
                    carsEntityList.add(new CarEntity(car.getCarId(), car.getCarName(), car.getBaseSpeed(),
                            car.getTopSpeed(), car.getPartListId(), this.GetPartsList(car.getPartListId())));
                }
            }
        }
        return carsEntityList;
    }
    
}
