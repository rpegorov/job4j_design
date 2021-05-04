package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EventIt implements Iterator<Integer> {
    private final int[] data;
    private int point;

    public EventIt(int[] data) {
        this.data = data;
    }

    /**
     * Метод проверяет есть ли в массиве следующее четное значение.
     * Если метод exist возвращает != -1 значит значения есть.
     */
    @Override
    public boolean hasNext() {
        return exist() != -1;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }

/**
 * Метод проводит поиск ячейки в которой находится четное число.
 * При это каждый последующий поиск элемента будет уменьшать
 * количество итераций цикла на point. Если очередное четное число
 * найдено не будет метод вернет -1.
 */
    private int exist() {
        var value = -1;
        for (int index = point; index < data.length; index++) {
            if (data[index] % 2 == 0) {
                point = index;
                value++;
                break;
            }
        }
        return value;
    }
}
