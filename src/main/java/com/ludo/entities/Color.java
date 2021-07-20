package com.ludo.entities;

public enum Color {
    NONE( new Cell(-1, -1)), RED(new Cell(0, 0)), GREEN(new Cell(1, 13)), YELLOW(new Cell(2, 26)), BLUE(new Cell(3, 39));

    Cell startCellIndex;

    Color(Cell startIndex) {
        this.startCellIndex = startIndex;
    }

    public Cell getStartIndex() {
        return Cell.clone( startCellIndex);
    }
}
