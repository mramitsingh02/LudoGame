package com.ludo.entities;

import lombok.ToString;

@ToString
public class Tracker {
    private Path[] path;

    public Tracker() {
        path = new Path[4];
        for (int i = 0; i < 4; i++) {
            path[i] = new Path(i);
        }
    }

    public void print() {
        for (Path path : path) {
            System.out.println(path);
        }
    }

    public Path getPath(int index) {
        return path[index];
    }

}
