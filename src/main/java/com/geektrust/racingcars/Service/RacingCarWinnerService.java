package com.geektrust.racingcars.Service;

import java.util.List;

import com.geektrust.racingcars.DtoEntity.CarEntity;
import com.geektrust.racingcars.DtoEntity.TeamEntity;
import com.geektrust.racingcars.DtoEntity.WinningTeamEntity;
import com.geektrust.racingcars.dto.Part;

public interface RacingCarWinnerService {
    
       public List<Part> GetSpeedBoostPartList(List<Part> partList, int funds, int speedToBeAchieved);

       public CarEntity GetMaximumSpeedBoostCarForTeam(List<CarEntity> carList, int funds);

       public WinningTeamEntity GetRaceWinner(List<TeamEntity> teams);
}
