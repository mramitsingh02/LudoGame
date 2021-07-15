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
    private User user;
    private Queue<Player> playerSet = new ArrayBlockingQueue<>(4);

    public Participant() {
    }

    public Participant(String name, Color color) {
        this(-1, name, color, User.COMPUTER, Collections.emptySet());
    }

    public Participant(Color color, User user) {
        this(-1, "Unknown", color, user, Collections.emptySet());
    }

    public Participant(String name, Color color, User user) {
        this(-1, name, color, user, Collections.emptySet());
    }


    public Participant(int id, String name, Color color, User user, Set<Player> playerSet) {
        this.id = id;
        this.name = Objects.isNull(name) ? "Unknown" : name;
        this.color = Objects.isNull(color) ? Color.NONE : color;
        this.user = Objects.isNull(user) ? User.COMPUTER : user;
        if (playerSet.isEmpty()) {
            this.playerSet.add(Player.builder().id(1).color(color).name(name).build());
            this.playerSet.add(Player.builder().id(2).color(color).name(name).build());
            this.playerSet.add(Player.builder().id(3).color(color).name(name).build());
            this.playerSet.add(Player.builder().id(4).color(color).name(name).build());
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

    public User getUser() {
        return user;
    }

    public Queue<Player> getPlayerSet() {
        return playerSet;
    }

    public Player getPlayer() {
        return playerSet.stream().filter(Player::isOnTrack).findFirst().orElse(playerSet.remove());
    }


    public List<Player> getPlayers() {
        return playerSet.stream().filter(Player::isOnTrack).collect(Collectors.toList());
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

    public static class ParticipantBuilder {
        private int id;
        private String name;
        private Color color;
        private User user;
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

        public User getUser() {
            return user;
        }

        public ParticipantBuilder user(User user) {
            this.user = user;
            return this;
        }

        public ParticipantBuilder defaultPlayer() {
            this.playerSet.add(Player.builder().id(1).color(color).name(name).build());
            this.playerSet.add(Player.builder().id(2).color(color).name(name).build());
            this.playerSet.add(Player.builder().id(3).color(color).name(name).build());
            this.playerSet.add(Player.builder().id(4).color(color).name(name).build());
            return this;
        }

        public Participant build() {
            if (name == null) {
                name = "Unknown";
            }
            if (color == null) {
                color = Color.NONE;
            }
            if (playerSet.isEmpty()) {
                defaultPlayer();
            }
            return new Participant(id, name, color, user, playerSet);
        }

    }


}
