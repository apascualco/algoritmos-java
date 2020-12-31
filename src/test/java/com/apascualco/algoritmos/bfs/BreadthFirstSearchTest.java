package com.apascualco.algoritmos.bfs;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.isNull;
import static org.junit.Assert.*;

public class BreadthFirstSearchTest {

    private BreadthFirstSearch breadthFirstSearch;

    public BreadthFirstSearchTest() {
        this.breadthFirstSearch = new BreadthFirstSearch();
    }

    @Test
    public void bfs_founded_node() {
        int[] initialState = new int[]{'l','o','a','h'};
        int[] finalState = new int[]{'h','o','l','a'};
        final NodeBFS nodeBFS = this.breadthFirstSearch.search(initialState, finalState).orElseThrow(NullPointerException::new);
        assertNotNull(nodeBFS);
        assertArrayEquals(nodeBFS.getState(), finalState);
        final List<String> states = getNodeList(nodeBFS);
        assertEquals(5, states.size());
    }

    @Test(expected = NullPointerException.class)
    public void initial_status_null_should_throw_exception() {
        int[] finalState = new int[]{'h','o','l','a'};
        this.breadthFirstSearch.search(null, finalState).orElseThrow(NullPointerException::new);
    }

    @Test(expected = NullPointerException.class)
    public void final_status_null_should_throw_exception() {
        int[] initialState = new int[]{'l','o','a','h'};
        this.breadthFirstSearch.search(initialState, null).orElseThrow(NullPointerException::new);
    }

    @Test
    public void real_test() {
        int[] initialState = new int[]{4,2,3,1};
        int[] finalState = new int[]{1,2,3,4};
        long initialTime = System.currentTimeMillis();
        final NodeBFS nodeBFS = this.breadthFirstSearch.search(initialState, finalState).orElseThrow(NullPointerException::new);
        printSolution(getNodeList(nodeBFS), (System.currentTimeMillis()-initialTime));
    }

    private static void printSolution(final List<String> states, long timeElapsed) {
        Collections.reverse(states);
        System.out.println("Solution in: " + states.size() + " levels [" + String.join(",", states) + "] time: " + timeElapsed + "ms");
    }

    private List<String> getNodeList(final NodeBFS nodeDFS) {
        boolean parentNull = false;
        NodeBFS current = nodeDFS;
        final List<String> states = new LinkedList<>();
        while(!parentNull) {
            states.add(current.toString());
            if(isNull(current.getParent())) {
                parentNull = true;
            }
            current = current.getParent();
        }
        return states;
    }
}
