package ru.job4j.generics.store;

import java.util.ArrayList;
import java.util.List;

public class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(Base model) {
        mem.add((T) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        var index = mem.indexOf(id);
        if (index != -1) {
            mem.set(index, (T) model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        var index = mem.indexOf(id);
        if (index != -1) {
            mem.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        var index = mem.indexOf(id);
        return index != -1 ? mem.get(index) : null;
    }
}
