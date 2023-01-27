package de.projectoc.pgamemaster.model;

public class Gameserver {
    private long id = 0;
    private String name;
    private int status;

    public Gameserver(String name, int status) {
        this.name = name;
        this.status = status;
    }
}
