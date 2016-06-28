package com.rgestin.coinchecounter.business.service;

import com.rgestin.coinchecounter.connector.model.Partie;
import com.rgestin.coinchecounter.connector.model.Team;

/**
 * Created by ronan GESTIN on 27/06/2016.
 */
public interface TeamService {

    Team createTeam(Partie partie, String name);
}
