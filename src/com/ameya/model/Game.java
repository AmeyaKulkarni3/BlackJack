package com.ameya.model;

import java.util.List;

public class Game {

    private boolean isActive;
    private List<Player> players;

    public Game() {
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
