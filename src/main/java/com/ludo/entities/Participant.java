package com.ludo.entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

@ToString
@EqualsAndHashCode
public class Participant {
    private int id;
    private String name;
    private Color color;
    private UserType userType;
    private Queue<Player> playerSet = new ArrayBlockingQueue<>(4);

    public Participant() {
    }

    public Participant(String name, Color color) {
        this(-1, name, color, UserType.COMPUTER, Collections.emptySet());
    }

    public Participant(Color color, UserType userType) {
        this(-1, "Unknown", color, userType, Collections.emptySet());
    }

    public Participant(String name, Color color, UserType userType) {
        this(-1, name, color, userType, Collections.emptySet());
    }


    public Participant(int id, String name, Color color, UserType userType, Set<Player> playerSet) {
        this.id = id;
        this.name = Objects.isNull(name) ? "Unknown" : name;
        this.color = Objects.isNull(color) ? Color.NONE : color;
        this.userType = Objects.isNull(userType) ? UserType.COMPUTER : userType;
        if (playerSet.isEmpty()) {
            this.playerSet.add(Player.builder().id(1).color(color).currentCell(color.getStartIndex()).name(name).build());
            this.playerSet.add(Player.builder().id(2).color(color).currentCell(color.getStartIndex()).name(name).build());
            this.playerSet.add(Player.builder().id(3).color(color).currentCell(color.getStartIndex()).name(name).build());
            this.playerSet.add(Player.builder().id(4).color(color).currentCell(color.getStartIndex()).name(name).build());
        } else {
            this.playerSet.addAll(playerSet);
        }

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UserType getUserType() {
        return userType;
    }

    public Queue<Player> getPlayerSet() {
        return playerSet;
    }

    public Player getPlayer() {
        return playerSet.stream().filter(Player::isOnTrack).findFirst().orElse(playerSet.remove());
    }


    public List<Player>  getOnTrackPlayers() {
        return playerSet.stream().filter(Player::isOnTrack).collect(Collectors.toList());
    }

    public List<Player>  getOffTrackPlayers() {
        return playerSet.stream().filter(Player::isOffTrack).collect(Collectors.toList());
    }

    public Color getColor() {
        return color;
    }

    public static ParticipantBuilder builder() {
        return new ParticipantBuilder();
    }

    public int throwDisk(Dice dice) {
        return dice.roll();
    }

    public int rollDice(Dice dice) {
        return dice.roll();
    }

    public String readableName() {
        return  color + "-" + name +  "-" + userType + "-" + id;
    }


    public static class ParticipantBuilder {
        private int id;
        private String name;
        private Color color;
        private UserType userType;
        private Set<Player> playerSet = new TreeSet<>(Player::compareTo);

        public int getId() {
            return id;
        }

        public ParticipantBuilder id(int id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public ParticipantBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ParticipantBuilder color(Color color) {
            this.color = color;
            return this;
        }

        public UserType getUser() {
            return userType;
        }

        public ParticipantBuilder user(UserType userType) {
            this.userType = userType;
            return this;
        }

        public ParticipantBuilder defaultPlayer() {
            if (playerSet.isEmpty()) {

                this.playerSet.add(Player.builder().id(1).color(color).currentCell(color.getStartIndex()).name(name).build());
                this.playerSet.add(Player.builder().id(2).color(color).currentCell(color.getStartIndex()).name(name).build());
                this.playerSet.add(Player.builder().id(3).color(color).currentCell(color.getStartIndex()).name(name).build());
                this.playerSet.add(Player.builder().id(4).color(color).currentCell(color.getStartIndex()).name(name).build());
            }
            return this;
        }

        public Participant build() {
            this.defaultName();
            this.defaultColor();
            this.defaultPlayer();
            return new Participant(id, name, color, userType, playerSet);
        }

        private void defaultName() {
            if (name == null) {
                this.name("Unknown");
            }
        }

        private void defaultColor() {
            if (color == null) {
                this.color(Color.NONE);
            }
        }

    }


}
