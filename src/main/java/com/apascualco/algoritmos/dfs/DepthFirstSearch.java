package com.apascualco.algoritmos.dfs;

import java.util.*;

import static java.util.Objects.isNull;

public class DepthFirstSearch {

    private final Stack<NodeDFS> nodeDFS = new Stack<>();
    private final List<NodeDFS> visited = new LinkedList<>();

    Optional<NodeDFS> search(final int[] initialState, final int[] finalState) {
        if(isNull(initialState)) {
            throw new NullPointerException("initialState shouldn't be null");
        }
        if(isNull(finalState)) {
            throw new NullPointerException("finalState shouldn't be null");
        }
        boolean foundFinalState = false;
        Optional<NodeDFS> foundNode = Optional.empty();
        final NodeDFS root = NodeDFS.of(initialState);
        nodeDFS.add(root);
        
        while(!foundFinalState && nodeDFS.size() != 0) {
            final NodeDFS nodeDFS = this.nodeDFS.pop();
            visited.add(nodeDFS);
            if(Arrays.equals(nodeDFS.getState(), finalState)) {
                foundFinalState = true;
                foundNode = Optional.of(nodeDFS);
            } else {
                int[] nodeState = nodeDFS.getState();
                this.processChild(new int[]{nodeState[1],nodeState[0],nodeState[2],nodeState[3]}, nodeDFS);
                this.processChild(new int[]{nodeState[0],nodeState[2],nodeState[1],nodeState[3]}, nodeDFS);
                this.processChild(new int[]{nodeState[0],nodeState[1],nodeState[3],nodeState[2]}, nodeDFS);
            }
        }
        return foundNode;
    }

    private void processChild(final int[] state, final NodeDFS nodeDFS) {
        final NodeDFS nodeDFSChild = NodeDFS.of(state);
        nodeDFSChild.setParent(nodeDFS);
        if(!this.nodeDFS.contains(nodeDFSChild) && !visited.contains(nodeDFSChild)) {
            this.nodeDFS.add(nodeDFSChild);
        }
    }

    public static void main(String[] args) {
        int[] estadoInicial = new int[]{4,2,3,1};
        int[] estadoFinal = new int[]{1,2,3,4};
        final DepthFirstSearch breadthFirstSearch = new DepthFirstSearch();
        long initialTime = System.currentTimeMillis();
        final NodeDFS nodeDFSSolucion = breadthFirstSearch.search(estadoInicial, estadoFinal).orElseThrow(NullPointerException::new);
        breadthFirstSearch.printSolution(nodeDFSSolucion, (System.currentTimeMillis()-initialTime));

    }

    private void printSolution(final NodeDFS solution, long timeElapsed) {
        boolean parentNull = false;
        NodeDFS actualNodeDFS = solution;
        final List<String> estados = new LinkedList<>();
        while(!parentNull) {
            estados.add(actualNodeDFS.toString());
            if(isNull(actualNodeDFS.getParent())) {
                parentNull = true;
            }
            actualNodeDFS = actualNodeDFS.getParent();
        }
        Collections.reverse(estados);
        System.out.println("Solution in: " + estados.size() + " levels [" + String.join(",", estados) + "] time: " + timeElapsed + "ms");
    }
}
