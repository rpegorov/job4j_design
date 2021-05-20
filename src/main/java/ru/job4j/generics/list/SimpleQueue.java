package ru.job4j.generics.list;

public class SimpleQueue<T> {

    private SimpleStack<T> in = new SimpleStack<>();
    private SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
    }
}
