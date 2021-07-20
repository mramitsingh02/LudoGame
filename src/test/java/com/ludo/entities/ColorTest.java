package com.ludo.entities;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColorTest {

    @Test
    public void testColor() {
        for (Color value : Color.values()) {
            Assert.assertNotNull(value.getStartIndex());
        }
    }

    @Test
    public void testColorCell() {

        Assert.assertEquals(new Cell(-1, -1), Color.NONE.getStartIndex());
        Assert.assertEquals(new Cell(0, 0), Color.RED.getStartIndex());
        Assert.assertEquals(new Cell(1, 13), Color.GREEN.getStartIndex());
        Assert.assertEquals(new Cell(2, 26), Color.YELLOW.getStartIndex());
        Assert.assertEquals(new Cell(3, 39), Color.BLUE.getStartIndex());


    }
}