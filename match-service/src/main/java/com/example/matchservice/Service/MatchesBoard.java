package com.example.matchservice.Service;

import com.example.matchservice.Model.Match;
import com.example.matchservice.Repository.MatchRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class MatchesBoard {
    private final MatchRepository matchRepository;

    @Autowired
    public MatchesBoard(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public void insertMatches(JSONObject fetchedMatches) throws ParseException {
        JSONArray matchesArray = fetchedMatches.getJSONArray("response");

        for (int i = 0; i < matchesArray.length(); i++) {
            JSONObject matchObject = matchesArray.getJSONObject(i);
            JSONObject fixtureObject = matchObject.getJSONObject("fixture");
            JSONObject leagueObject = matchObject.getJSONObject("league");
            JSONObject homeTeamObject = matchObject.getJSONObject("teams").getJSONObject("home");
            JSONObject awayTeamObject = matchObject.getJSONObject("teams").getJSONObject("away");

            Match match = new Match();
            match.setIdMatch(fixtureObject.getInt("id"));
            match.setNameStadium(fixtureObject.getJSONObject("venue").getString("name"));
            match.setCityStadium(fixtureObject.getJSONObject("venue").getString("city"));
            match.setDatetimeMatch(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").parse(fixtureObject.getString("date")));
            match.setStatusMatch(fixtureObject.getJSONObject("status").getString("short"));
            match.setIdLeague(leagueObject.getInt("id"));
            match.setNameLeague(leagueObject.getString("name"));
            match.setIdHomeTeam(homeTeamObject.getInt("id"));
            match.setNameHomeTeam(homeTeamObject.getString("name"));
            try {
                match.setGoalsHomeTeam(matchObject.getJSONObject("goals").getInt("home"));
                match.setGoalsAwayTeam(matchObject.getJSONObject("goals").getInt("away"));
            } catch (Exception e) {
                match.setGoalsHomeTeam(0);
                match.setGoalsAwayTeam(0);
            }
            match.setIdAwayTeam(awayTeamObject.getInt("id"));
            match.setNameAwayTeam(awayTeamObject.getString("name"));

            matchRepository.save(match);
        }
    }

    public void deleteMatchesBoard() {
        matchRepository.deleteAll();
    }
}
