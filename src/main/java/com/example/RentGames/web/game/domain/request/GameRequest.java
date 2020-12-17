package com.example.RentGames.web.game.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameRequest {

    private Long id;
    private String title;
    private String genreList;
    private String releaseDate;
    private String platformList;
    private int quantity;

}
