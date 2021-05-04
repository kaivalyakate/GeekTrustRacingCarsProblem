package com.geektrust.racingcars;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.geektrust.racingcars.dto.Team;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        CsvSchema teamSchema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<Team> teams = csvMapper.readerFor(Team.class)
        .with(teamSchema)
        .readValues(new File("F:/Books/Crio.do_Internship/GeekTrust/RacingCars-GeekTrust/racingcars-geektrust/src/main/resources/Data/Teams.csv"));
        while(teams.hasNext()){
            System.out.println(teams.next().getFunds());
        }
    }
}

// F:\Books\Crio.do_Internship\GeekTrust\RacingCars-GeekTrust\racingcars-geektrust\src\main\resources\Data\Teams.csv