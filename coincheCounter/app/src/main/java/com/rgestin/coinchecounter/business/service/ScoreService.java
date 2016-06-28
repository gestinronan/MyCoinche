package com.rgestin.coinchecounter.business.service;

import com.rgestin.coinchecounter.connector.model.Score;
import com.rgestin.coinchecounter.connector.model.Team;

import java.util.List;

/**
 * Created by Ronan GESTIN on 28/06/2016.
 */
public interface ScoreService {

    Score createScore(int value, int partie, Team team);
    List<Score> getAllForTeam(Team team);
}
