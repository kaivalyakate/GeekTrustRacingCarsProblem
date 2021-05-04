package com.geektrust.racingcars.DataProcessing;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.geektrust.racingcars.dto.Car;
import com.geektrust.racingcars.dto.Part;
import com.geektrust.racingcars.dto.Team;

public class CsvProcessing {

    private static String teamCsv = "F:/Books/Crio.do_Internship/GeekTrust/RacingCars-GeekTrust/racingcars-geektrust/src/main/resources/Data/Teams.csv";
    private static String carCsv = "F:/Books/Crio.do_Internship/GeekTrust/RacingCars-GeekTrust/racingcars-geektrust/src/main/resources/Data/Cars.csv";
    private static String partsCsv = "F:/Books/Crio.do_Internship/GeekTrust/RacingCars-GeekTrust/racingcars-geektrust/src/main/resources/Data/Parts.csv";

    private CsvMapper GetCsvMapper(){
        CsvMapper csvMapper = new CsvMapper();
        return csvMapper;
    }

    public MappingIterator<Team> GetTeamCsvData() throws IOException{
        CsvMapper csvMapper = GetCsvMapper();
        CsvSchema teamSchema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Team> teams = csvMapper.readerFor(Team.class)
        .with(teamSchema)
        .readValues(new File(teamCsv));
        return teams;
    }

    public MappingIterator<Car> GetCarCsvData() throws IOException {
        CsvMapper csvMapper = GetCsvMapper();
        CsvSchema carSchema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Car> cars = csvMapper.readerFor(Car.class).with(carSchema).readValues(new File(
                "F:/Books/Crio.do_Internship/GeekTrust/RacingCars-GeekTrust/racingcars-geektrust/src/main/resources/Data/Teams.csv"));
        return cars;
    }

    public MappingIterator<Part> GetPartCsvData() throws IOException {
        CsvMapper csvMapper = GetCsvMapper();
        CsvSchema partSchema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Part> parts = csvMapper.readerFor(Part.class).with(partSchema).readValues(new File(
                "F:/Books/Crio.do_Internship/GeekTrust/RacingCars-GeekTrust/racingcars-geektrust/src/main/resources/Data/Teams.csv"));
        return parts;
    }

}
