package com.apascualco.algoritmos.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class BacktrackingTest {

    private Backtracking backtracking;


    public BacktrackingTest() {
        this.backtracking = new Backtracking();
    }

    @Test
    public void testing_backtracking_with_pruning() {

        final List<Pair<Integer, Integer>> range = new ArrayList<>();
        range.add(0,  Pair.with(0,50));
        range.add(1, Pair.with(0,75));

        Pair<Integer,Integer>result = backtracking.search(range, Heuristics.of(pruning,heuristics));

        System.out.println(result);
    }

    private BiPredicate<int[],Pair<Integer, Integer>> heuristics = (state,optimal) ->
        evaluate(state) > evaluate(new int[]{optimal.getFirst(), optimal.getSecond()});

    private Predicate<int[]> pruning = state -> {
        int totalHoursOfProduction = 10 * state[0] + 6 * state[1];
        int totalPieces = 8 * state[0] + 7 * state[1];
        return totalHoursOfProduction <= 240 && totalPieces <= 230;
    };

    private int evaluate(final int[] state) {
        return (68-34) * state[0] + (58-27) * state[1];
    }

}
