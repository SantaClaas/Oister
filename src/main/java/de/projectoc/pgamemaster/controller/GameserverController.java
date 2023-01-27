package de.projectoc.pgamemaster.controller;

import de.projectoc.pgamemaster.model.Gameserver;
import de.projectoc.pgamemaster.service.GameserverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class GameserverController {
    @Autowired
    GameserverService gameserverService;

    @GetMapping("/servers")
    public ResponseEntity<List<Gameserver>> getAllServers() {
        return new ResponseEntity<>(gameserverService.findAll(), HttpStatus.OK);
    }
}
