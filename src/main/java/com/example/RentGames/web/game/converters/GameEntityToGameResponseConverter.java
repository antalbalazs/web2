package com.example.RentGames.web.game.converters;

import com.example.RentGames.model.game.GameEntity;
import com.example.RentGames.web.game.domain.response.GameResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameEntityToGameResponseConverter  {

    public GameResponse convert(GameEntity gameEntity) {
        return GameResponse.builder()
                .id(gameEntity.getId())
                .title(gameEntity.getTitle())
                .quantity(gameEntity.getAvailableQuantity())
                .releaseDate(gameEntity.getReleaseDate())
                .platformList(getListAsString(gameEntity.getPlatforms()))
                .genreList(getListAsString(gameEntity.getGenres()))
                .build();
    }

    private String getListAsString(List<String> inputList){
        if(inputList == null || inputList.isEmpty()){
            return "";
        }

        String listAsString = "";
        for(String platform: inputList){
            listAsString += platform + ",";
        }

        return listAsString.substring(0,listAsString.length()-1);
    }

}
