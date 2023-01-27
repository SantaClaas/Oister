package de.projectoc.pgamemaster.model;

import jakarta.persistence.*;

@Entity
public abstract class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private int status;
}
