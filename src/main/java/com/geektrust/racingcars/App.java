package com.geektrust.racingcars;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.geektrust.racingcars.DataProcessing.CsvProcessing;
import com.geektrust.racingcars.DtoEntity.CarEntity;
import com.geektrust.racingcars.Service.RacingCarWinnerRepository;
import com.geektrust.racingcars.Service.RacingCarWinnerRepositoryImpl;
import com.geektrust.racingcars.dto.Car;
import com.geektrust.racingcars.dto.Team;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        // MappingIterator<Team> teams = new CsvProcessing().GetTeamCsvData();
        // while(teams.hasNext()){
        //     System.out.println(teams.next().getFunds());
        // }
        RacingCarWinnerRepository racingCarWinnerRepository = new RacingCarWinnerRepositoryImpl();
        List<Car> cars = new ArrayList<>();
        List<CarEntity> carsEntityList = racingCarWinnerRepository.GetCarEntityList(cars);
        for(CarEntity carsEntity: carsEntityList){
            System.out.println(carsEntity.getCarId());
        }
    }
}

// F:\Books\Crio.do_Internship\GeekTrust\RacingCars-GeekTrust\racingcars-geektrust\src\main\resources\Data\Teams.csv