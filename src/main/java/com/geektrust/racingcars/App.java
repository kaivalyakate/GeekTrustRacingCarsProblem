package com.geektrust.racingcars;

import java.io.IOException;

import com.fasterxml.jackson.databind.MappingIterator;
import com.geektrust.racingcars.DataProcessing.CsvProcessing;
import com.geektrust.racingcars.dto.Team;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        MappingIterator<Team> teams = new CsvProcessing().GetTeamCsvData();
        while(teams.hasNext()){
            System.out.println(teams.next().getFunds());
        }
    }
}

// F:\Books\Crio.do_Internship\GeekTrust\RacingCars-GeekTrust\racingcars-geektrust\src\main\resources\Data\Teams.csv