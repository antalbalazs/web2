package com.example.RentGames.model.game;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<GameEntity,Long> {

    @Query("SELECT max(g.id) FROM GameEntity g")
    Long getBiggestId();
}
