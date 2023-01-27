package de.projectoc.pgamemaster.service;

import de.projectoc.pgamemaster.model.Gameserver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameserverService {
    static List<Gameserver> gameservers = new ArrayList<>();
    static long id = 0;

    public List<Gameserver> findAll() {
        return gameservers;
    }
}
