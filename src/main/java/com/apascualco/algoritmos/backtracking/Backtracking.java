package com.apascualco.algoritmos.backtracking;

import java.util.List;
import java.util.stream.IntStream;

public class Backtracking {

    public Pair<Integer, Integer> search(
            final List<Pair<Integer, Integer>> range,
            final Heuristics heuristics
    ) {
        int[] initialState = {0,0};
        final Pair<Integer,Integer> optimal = Pair.with(0,0);
        return this.search(initialState, range, optimal, 0,heuristics);
    }

    private Pair<Integer,Integer> search(
            final int[] state,
            final List<Pair<Integer, Integer>> range,
            final Pair<Integer,Integer> optimal,
            final int branch,
            final Heuristics heuristics
            ) {

        int rangeFrom = range.get(branch).getFirst();
        int rangeTo = range.get(branch).getSecond();

        IntStream.range(rangeFrom,rangeTo).forEach(cursor -> {
                    state[branch] = cursor;
                    if (heuristics.getPruning().test(state)) {
                        if (branch < state.length - 1) {
                            optimal.update(this.search(
                                    state.clone(),
                                    range,
                                    optimal,
                                    branch + 1,
                                    heuristics)
                            );
                        } else if (heuristics.getHeuristic().test(state, optimal)) {
                            optimal.update(Pair.with(state[0], state[1]));
                        }
                    }
                }
        );
        return optimal;
    }
}
