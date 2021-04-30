package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row;
    private int column;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return column < data[row].length || row != data.length - 1;
    }

    @Override
    public Integer next() {
        if (!hasNext())
            throw new NoSuchElementException();
        if (column >= data[row].length) {
            row++;
            column = 0;
        }
        return data[row][column++];
    }
}
