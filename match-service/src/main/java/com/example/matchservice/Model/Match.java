package com.example.matchservice.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    @Id
    @Column(name = "id_match", unique = true, updatable = false)
    private Integer idMatch;

    @Column(name = "name_stadium", nullable = false)
    private String nameStadium;

    @Column(name = "city_stadium")
    private String cityStadium;

    @Column(name = "datetime_match", nullable = false)
    private Date datetimeMatch;

    @Column(name = "status_match", nullable = false, columnDefinition = "VARCHAR(5) DEFAULT 'NS'")
    private String statusMatch;

    @Column(name = "id_league", nullable = false)
    private Integer idLeague;

    @Column(name = "name_league", nullable = false)
    private String nameLeague;

    @Column(name = "id_home_team", nullable = false)
    private Integer idHomeTeam;

    @Column(name = "name_home_team", nullable = false)
    private String nameHomeTeam;

    @Column(name = "goals_home_team", nullable = false)
    private Integer goalsHomeTeam;

    @Column(name = "id_awy_team", nullable = false)
    private Integer idAwayTeam;

    @Column(name = "name_away_team", nullable = false)
    private String nameAwayTeam;

    @Column(name = "goals_away_team", nullable = false)
    private Integer goalsAwayTeam;

}
