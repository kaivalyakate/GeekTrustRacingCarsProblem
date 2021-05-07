package com.geektrust.racingcars;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.geektrust.racingcars.DataProcessing.CsvProcessing;
import com.geektrust.racingcars.DtoEntity.CarEntity;
import com.geektrust.racingcars.DtoEntity.TeamEntity;
import com.geektrust.racingcars.Repository.RacingCarWinnerRepository;
import com.geektrust.racingcars.Repository.RacingCarWinnerRepositoryImpl;
import com.geektrust.racingcars.dto.Car;

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
        List<TeamEntity> teams = racingCarWinnerRepository.GetTeamEntityList(new CsvProcessing().GetTeamCsvData(), new CsvProcessing().GetCarCsvData());
        System.out.println(teams.get(0).getTeamName());
    }
}

// F:\Books\Crio.do_Internship\GeekTrust\RacingCars-GeekTrust\racingcars-geektrust\src\main\resources\Data\Teams.csv