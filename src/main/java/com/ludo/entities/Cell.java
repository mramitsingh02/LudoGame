package com.ludo.entities;

import lombok.ToString;

import java.util.Set;

@ToString
public class Cell {
    public final int row;
    public final int column;
    public boolean isStampCell;
    public boolean isStartCell;
    public Set<Participant> participantSet;

    public Cell(int row, int column) {
        this(row, column, false);
    }

    public Cell(int row, int column, boolean isStampCell) {
        this.row = row;
        this.column = column;
        this.isStampCell = isStampCell;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public String toString() {
        return this.row + "@" + this.column + (isStampCell ? "*": "");
    }

    public int hashCode() {
        return this.row * 31 + this.column;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o.getClass() != this.getClass()) {
            return false;
        } else {
            return ((Cell) o).row == this.row && ((Cell) o).column == this.column;
        }
    }

    public boolean isStartCell() {
        return isStartCell;
    }

    public Cell setStartCell(boolean startCell) {
        isStartCell = startCell;
        return this;
    }
}