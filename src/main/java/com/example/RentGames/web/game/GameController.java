package com.example.RentGames.web.game;

import com.example.RentGames.model.game.GameEntity;
import com.example.RentGames.model.game.GameRepository;
import com.example.RentGames.web.game.converters.GameRequestToGameEntityConverter;
import com.example.RentGames.web.game.domain.request.GameRequest;
import com.example.RentGames.web.game.domain.response.GameResponse;
import com.example.RentGames.web.game.converters.GameEntityToGameResponseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GameController {

   @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameEntityToGameResponseConverter gameEntityToGameResponseConverter;

    @Autowired
    private GameRequestToGameEntityConverter gameRequestToGameEntityConverter;

    @ResponseBody
    @RequestMapping(path = "/games",method = RequestMethod.GET)
    public List<GameResponse> getAllGames(){
        List<GameResponse> games = new ArrayList<>();
        gameRepository.findAll().forEach(game -> games.add(gameEntityToGameResponseConverter.convert(game)));
        return games;
    }

    @RequestMapping(path = "/games/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteGame(@PathVariable long id){
        try {
            gameRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }catch(EmptyResultDataAccessException e){
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/addGame", method = RequestMethod.POST)
    public String addNewGame(@RequestBody GameRequest gameRequest){
        GameEntity gameEntity = gameRequestToGameEntityConverter.convert(gameRequest);
        gameEntity.setId(getNextId());
        gameRepository.save(gameEntity);
        return gameEntity.getId().toString();
    }

    private Long getNextId(){
        Long currentId = gameRepository.getBiggestId();
        if(currentId == null){
            return 1l;
        }else{
            return currentId + 1;
        }
    }

    @RequestMapping(path = "/updateGame", method = RequestMethod.PUT)
    public ResponseEntity updateGameData(@RequestBody GameRequest gameRequest){
        GameEntity gameEntity = gameRequestToGameEntityConverter.convert(gameRequest);
        gameEntity.setId(gameRequest.getId());
        gameRepository.save(gameEntity);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
