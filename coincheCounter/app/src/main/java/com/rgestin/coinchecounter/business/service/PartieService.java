package com.rgestin.coinchecounter.business.service;

import android.support.annotation.NonNull;

import com.rgestin.coinchecounter.connector.model.Partie;
import com.rgestin.coinchecounter.connector.model.Team;

import java.util.List;

/**
 * Created by ronan GESTIN on 27/06/2016.
 */
public interface PartieService {

    List<Team> getTeam(@NonNull  final Partie partie) ;

    Partie createpratie(@NonNull String name);

    List<Partie> getAllPartie();

    void updatePartie(Partie parite);

    Partie getPartie(Long id);

}
