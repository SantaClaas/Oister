package de.projectoc.pgamemaster.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Gameserver extends Server {
    @Column String game;
}
