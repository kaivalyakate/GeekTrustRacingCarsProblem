package com.geektrust.racingcars.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
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
        MappingIterator<Part> partsData = new CsvProcessing().GetPartCsvData();
        List<Part> partsList = new ArrayList<>();
        while(partsData.hasNext()){
            Part part = partsData.next();
            if(partListId.equals(part.getPartListId())){
                partsList.add(part);
            }
        }
        return partsList;
    }

    @Override
    public List<TeamEntity> GetTeamEntityList(List<Team> teams) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CarEntity> GetCarEntityList(List<Car> cars) throws IOException {
        // TODO Auto-generated method stub
        MappingIterator<Car> carsData = new CsvProcessing().GetCarCsvData();
        List<CarEntity> carsEntityList = new ArrayList<>();
        while(carsData.hasNext()){
            Car car = carsData.next();
            carsEntityList.add(new 
                CarEntity(
                    car.getCarId(), 
                    car.getCarName(), 
                    car.getBaseSpeed(), 
                    car.getTopSpeed(), 
                    car.getPartListId(), 
                    this.GetPartsList(car.getPartListId())));
        }
        return carsEntityList;
    }
    
}
