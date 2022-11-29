package org.example;

import java.util.Objects;

public class Player implements Comparable{
    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name + '\'' +
                ", score=" + score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return getScore() == player.getScore() && getName().equals(player.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getScore());
    }

    @Override
    public int compareTo(Object o) {
        Player player = (Player) o;
        return 1;
    }
}
