package com.apascualco.algoritmos.backtracking;

public class Pair<A,B> {

    private A first;
    private B second;

    private Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public void update(Pair<A, B> pair) {
        this.first = pair.getFirst();
        this.second = pair.getSecond();
    }

    public static <A, B> Pair<A, B> with(A value0, B value1) {
        return new Pair<>(value0, value1);
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
