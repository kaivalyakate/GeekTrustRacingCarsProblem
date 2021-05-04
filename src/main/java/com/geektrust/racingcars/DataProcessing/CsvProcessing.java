package com.geektrust.racingcars.DataProcessing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Team> GetTeamCsvData() throws IOException{
        CsvMapper csvMapper = GetCsvMapper();
        CsvSchema teamSchema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Team> teams = csvMapper.readerFor(Team.class)
        .with(teamSchema)
        .readValues(new File(teamCsv));
        List<Team> teamList = new ArrayList<>();
        while(teams.hasNext()){
            teamList.add(teams.next());
        }
        return teamList;
    }

    public List<Car> GetCarCsvData() throws IOException {
        CsvMapper csvMapper = GetCsvMapper();
        CsvSchema carSchema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Car> cars = csvMapper.readerFor(Car.class)
        .with(carSchema)
        .readValues(new File(carCsv));
        List<Car> carList = new ArrayList<>();
        while (cars.hasNext()) {
            carList.add(cars.next());
        }
        return carList;
    }

    public List<Part> GetPartCsvData() throws IOException {
        CsvMapper csvMapper = GetCsvMapper();
        CsvSchema partSchema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Part> parts = csvMapper.readerFor(Part.class)
        .with(partSchema)
        .readValues(new File(partsCsv));
        List<Part> partList = new ArrayList<>();
        while (parts.hasNext()) {
            partList.add(parts.next());
        }
        return partList;
    }

}
