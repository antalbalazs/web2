package com.example.RentGames.web.game.converters;

import com.example.RentGames.model.game.GameEntity;
import com.example.RentGames.web.game.domain.request.GameRequest;
import com.example.RentGames.web.game.domain.response.GameResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GameRequestToGameEntityConverter {

    public GameEntity convert(GameRequest gameRequest){
        GameEntity gameEntity = new GameEntity();
        gameEntity.setTitle(gameRequest.getTitle());
        gameEntity.setReleaseDate(gameRequest.getReleaseDate().length() == 0 ? "Unknown" : gameRequest.getReleaseDate());
        gameEntity.setGenres(getStringAsList(gameRequest.getGenreList()));
        gameEntity.setAvailableQuantity(gameRequest.getQuantity());
        gameEntity.setAvailable(gameRequest.getQuantity() > 0);
        gameEntity.setPlatforms(getStringAsList(gameRequest.getPlatformList()));

        return gameEntity;
    }

    private List<String> getStringAsList(String list){
        if(list.length() == 0){
            return new ArrayList<>();
        }

        List<String> stringAsList = Arrays.asList(list.split(","));
        return stringAsList;
    }
}
