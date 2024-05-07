package com.example.matchservice.ScheduledTasks;

import com.example.matchservice.Service.FootballApi;
import com.example.matchservice.Service.MatchesBoard;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class UpdateMatchesBoard {
    public final MatchesBoard matchesBoard;

    @Autowired
    public UpdateMatchesBoard(final MatchesBoard matchesBoard) {
        this.matchesBoard = matchesBoard;
    }

    @Scheduled(cron = "0 0 6 * * *")
    private void dailyMatchesBoardUpdate() throws ParseException {
        matchesBoard.deleteMatchesBoard();
        JSONObject matches = FootballApi.getBoardMatches(39);
        matchesBoard.insertMatches(matches);
    }
}
