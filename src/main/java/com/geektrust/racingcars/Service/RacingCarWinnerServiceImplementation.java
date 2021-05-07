package com.geektrust.racingcars.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.geektrust.racingcars.DataProcessing.CsvProcessing;
import com.geektrust.racingcars.DtoEntity.CarEntity;
import com.geektrust.racingcars.DtoEntity.TeamEntity;
import com.geektrust.racingcars.DtoEntity.WinningTeamEntity;
import com.geektrust.racingcars.Repository.RacingCarWinnerRepository;
import com.geektrust.racingcars.Repository.RacingCarWinnerRepositoryImpl;
import com.geektrust.racingcars.dto.Part;

public class RacingCarWinnerServiceImplementation implements RacingCarWinnerService {

    private int GetTotalPrice(List<Part> partList) {
        int priceAdded = 0;
        for (Part part : partList) {
            priceAdded += part.getPrice();
        }
        return priceAdded;
    }

    private int GetSpeedAchieved(List<Part> partList) {
        int speedAchieved = 0;
        for (Part part : partList) {
            speedAchieved += part.getSpeedBoost();
        }
        return speedAchieved;
    }

    private CarEntity getCarEntityForGivenID(List<CarEntity> carEntities, String ID) {
        for (CarEntity x : carEntities) {
            if (x.getCarId().equals(ID)) {
                return x;
            }
        }
        return null;
    }

    @Override
    public List<Part> GetSpeedBoostPartList(List<Part> partList, int funds, int speedToBeAchieved) {
        // TODO Auto-generated method stub
        Collections.sort(partList, new Comparator<Part>() {

            @Override
            public int compare(Part o1, Part o2) {
                // TODO Auto-generated method stub
                if (o1.getSpeedBoost() > o2.getSpeedBoost()) {
                    return -1;
                } else {
                    return 1;
                }
            }

        });
        List<Part> newPartList = new ArrayList<>();
        int fundSpent = 0;
        int speedBoost = 0;
        for (int i = 0; i < partList.size(); i++) {
            Part part = partList.get(i);
            if ((fundSpent + part.getPrice()) <= funds && (speedBoost + part.getSpeedBoost()) <= speedToBeAchieved) {
                newPartList.add(part);
                fundSpent += part.getPrice();
                speedBoost += part.getSpeedBoost();
            } else if (fundSpent == funds || speedBoost == speedToBeAchieved) {
                break;
            }
        }

        return newPartList;
    }

    @Override
    public CarEntity GetMaximumSpeedBoostCarForTeam(List<CarEntity> carList, int funds) {
        // TODO Auto-generated method stub
        Map<String, Integer> partSpeedMap = new LinkedHashMap<>();
        for (CarEntity x : carList) {
            List<Part> addedPartList = GetSpeedBoostPartList(x.getAddablePartsList(), funds,
                    x.getTopSpeed() - x.getBaseSpeed());
            partSpeedMap.put(x.getCarId(), GetSpeedAchieved(addedPartList));
        }
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(partSpeedMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                // TODO Auto-generated method stub
                return o1.getValue().compareTo(o2.getValue());
            }

        });

        Map<String, Integer> temp = new HashMap<>();
        for (Map.Entry<String, Integer> x : list) {
            temp.put(x.getKey(), x.getValue());
        }
        Map.Entry<String, Integer> entry = temp.entrySet().iterator().next();
        CarEntity carEntity = getCarEntityForGivenID(carList, entry.getKey());
        carEntity.setAddablePartsList(GetSpeedBoostPartList(carEntity.getAddablePartsList(), funds,
                carEntity.getTopSpeed() - carEntity.getBaseSpeed()));
        return carEntity;
    }

    @Override
    public WinningTeamEntity GetRaceWinner(List<TeamEntity> teams) {
        // TODO Auto-generated method stub
        WinningTeamEntity winningTeam = new WinningTeamEntity();
        int max = 0;
        for (TeamEntity x : teams) {
            CarEntity winningCarOfTheTeam = GetMaximumSpeedBoostCarForTeam(x.getCars(), x.getFunds());
            int speedAchieved = GetSpeedAchieved(winningCarOfTheTeam.getAddablePartsList());
            if (speedAchieved > max) {
                max = speedAchieved;
                winningTeam = new WinningTeamEntity(x.getTeamName(), winningCarOfTheTeam.getCarName(), speedAchieved,
                        GetTotalPrice(winningCarOfTheTeam.getAddablePartsList()),
                        winningCarOfTheTeam.getAddablePartsList());
            }
        }
        return winningTeam;
    }

    public static void main(String[] args) throws IOException {
        RacingCarWinnerRepository racingCarPart = new RacingCarWinnerRepositoryImpl();
        CsvProcessing csvProcessing = new CsvProcessing();
        WinningTeamEntity winningCar = new RacingCarWinnerServiceImplementation().GetRaceWinner(
                racingCarPart.GetTeamEntityList(csvProcessing.GetTeamCsvData(), csvProcessing.GetCarCsvData()));
        System.out.println(
                winningCar.getCarName() + " " + winningCar.getFundsSpent() + " " + winningCar.getSpeedAchieved());
    }

}
