package com.apascualco.algoritmos.bfs;

import java.util.*;

import static java.util.Objects.isNull;

public class BreadthFirstSearch {

    private final Queue<NodeBFS> nodeBFS = new LinkedList<>();
    private final List<NodeBFS> visited = new LinkedList<>();

    Optional<NodeBFS> search(final int[] initialState, final int[] finalState) {
        if(isNull(initialState)) {
            throw new NullPointerException("initialState shouldn't be null");
        }
        if(isNull(finalState)) {
            throw new NullPointerException("finalState shouldn't be null");
        }
        boolean foundFinalState = false;
        Optional<NodeBFS> foundNode = Optional.empty();
        final NodeBFS root = NodeBFS.of(initialState);
        nodeBFS.add(root);
        
        while(!foundFinalState && nodeBFS.size() != 0) {
            final NodeBFS nodeDFS = this.nodeBFS.poll();
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

    private void processChild(final int[] state, final NodeBFS nodeDFS) {
        final NodeBFS nodeDFSChild = NodeBFS.of(state);
        nodeDFSChild.setParent(nodeDFS);
        if(!this.nodeBFS.contains(nodeDFSChild) && !visited.contains(nodeDFSChild)) {
            this.nodeBFS.add(nodeDFSChild);
        }
    }

    public static void main(String[] args) {
        int[] estadoInicial = new int[]{4,2,3,1};
        int[] estadoFinal = new int[]{1,2,3,4};
        final BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        long initialTime = System.currentTimeMillis();
        final NodeBFS nodeDFSSolucion = breadthFirstSearch.search(estadoInicial, estadoFinal).orElseThrow(NullPointerException::new);
        breadthFirstSearch.printSolution(nodeDFSSolucion, (System.currentTimeMillis()-initialTime));

    }

    private void printSolution(final NodeBFS solution, long timeElapsed) {
        boolean parentNull = false;
        NodeBFS actualNodeDFS = solution;
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
