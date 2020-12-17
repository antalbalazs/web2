package com.example.RentGames.web.game.domain.response;


import lombok.*;

@Getter
@Setter
@Builder
public class GameResponse {

    private Long id;

    private String title;

    private String genreList;

    private String releaseDate;

    private String platformList;

    private int quantity;
}
