package com.apascualco.algoritmos.backtracking;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Heuristics {

    private Predicate<int[]> pruning;
    private BiPredicate<int[],Pair<Integer, Integer>> heuristic;

    @SuppressWarnings("unused")
    private Heuristics() { }

    public Heuristics(final Predicate<int[]> pruning,final BiPredicate<int[], Pair<Integer, Integer>> heuristic) {
        this.pruning = pruning;
        this.heuristic = heuristic;
    }

    public static Heuristics of(final Predicate<int[]> pruning, final BiPredicate<int[],Pair<Integer, Integer>> heuristic) {
        return new Heuristics(pruning,heuristic);
    }

    public Predicate<int[]> getPruning() {
        return pruning;
    }

    public BiPredicate<int[], Pair<Integer, Integer>> getHeuristic() {
        return heuristic;
    }

}
