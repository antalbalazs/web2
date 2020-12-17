package com.example.RentGames.model.game;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "game")
public class GameEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "genres")
    @ElementCollection
    private List<String> genres;

    @Column(name = "platforms")
    @ElementCollection
    private List<String> platforms;

    @Column(name = "available")
    private boolean available;

    @Column(name = "available_quantity")
    private int availableQuantity;
}
