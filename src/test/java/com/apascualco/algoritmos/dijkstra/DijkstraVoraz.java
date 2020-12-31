package com.apascualco.algoritmos.dijkstra;

import org.junit.Test;

import java.util.*;

import static java.util.Objects.nonNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class DijkstraVoraz {

    @Test
    public void how_works() {
        final Map<NodeDijkstra, Tag> tagList = Dijkstra.tagging(buildGraph2());
        assertFalse(tagList.isEmpty());
        List<NodeDijkstra> route = new LinkedList<>();
        getTagsFrom("G", tagList, route);
        Collections.reverse(route);
        assertFalse(route.isEmpty());
        assertEquals("A", route.get(0).getName());
        assertEquals("C", route.get(1).getName());
        assertEquals("D", route.get(2).getName());
        assertEquals("F", route.get(3).getName());
        assertEquals("G", route.get(4).getName());
    }

    private void getTagsFrom(final String destination, final Map<NodeDijkstra, Tag> tagList, final List<NodeDijkstra> nodeDijkstras) {
        final Map.Entry<NodeDijkstra, Tag> entry = tagList.entrySet().stream()
                .filter(entrySet -> destination.equals(entrySet.getKey().getName()))
                .findFirst()
                .orElse(null);
        if(nonNull(entry)) {
            nodeDijkstras.add(entry.getKey());
            if(nonNull(entry.getValue().getNode())) {
                getTagsFrom(entry.getValue().getNode().getName(), tagList, nodeDijkstras);
            }
        }
    }
    
    private NodeDijkstra buildGraph2() {
        final NodeDijkstra nodeDijkstraA = new NodeDijkstra("A");
        final NodeDijkstra nodeDijkstraB = new NodeDijkstra("B");
        final NodeDijkstra nodeDijkstraC = new NodeDijkstra("C");
        final NodeDijkstra nodeDijkstraD = new NodeDijkstra("D");
        final NodeDijkstra nodeDijkstraE = new NodeDijkstra("E");
        final NodeDijkstra nodeDijkstraF = new NodeDijkstra("F");
        final NodeDijkstra nodeDijkstraG = new NodeDijkstra("G");
        final NodeDijkstra nodeDijkstraH = new NodeDijkstra("H");
        nodeDijkstraA.setAdjacency(buildAdjacentNodeA(nodeDijkstraB,nodeDijkstraC));
        nodeDijkstraB.setAdjacency(buildAdjacentNodeB(nodeDijkstraA,nodeDijkstraD,nodeDijkstraC));
        nodeDijkstraC.setAdjacency(buildAdjacentNodeC(nodeDijkstraA,nodeDijkstraB,nodeDijkstraD));
        nodeDijkstraD.setAdjacency(buildAdjacentNodeD(nodeDijkstraB,nodeDijkstraC,nodeDijkstraF,nodeDijkstraE));
        nodeDijkstraE.setAdjacency(buildAdjacentNodeE(nodeDijkstraD,nodeDijkstraG,nodeDijkstraH));
        nodeDijkstraF.setAdjacency(buildAdjacentNodeF(nodeDijkstraD,nodeDijkstraG));
        nodeDijkstraG.setAdjacency(buildAdjacentNodeG(nodeDijkstraF,nodeDijkstraE,nodeDijkstraH));
        nodeDijkstraH.setAdjacency(buildAdjacentNodeH(nodeDijkstraG,nodeDijkstraE));
        return nodeDijkstraA;
    }

    private Map<NodeDijkstra, Integer> buildAdjacentNodeH(
            final NodeDijkstra nodeDijkstraG, 
            final NodeDijkstra nodeDijkstraE
    ) {
        final Map<NodeDijkstra, Integer> adjacent = new HashMap<>();
        adjacent.put(nodeDijkstraG,1);
        adjacent.put(nodeDijkstraE,3);
        return adjacent;
    }

    private Map<NodeDijkstra, Integer> buildAdjacentNodeG(
            final NodeDijkstra nodeDijkstraF, 
            final NodeDijkstra nodeDijkstraE, 
            final NodeDijkstra nodeDijkstraH
    ) {
        final Map<NodeDijkstra, Integer> adjacent = new HashMap<>();
        adjacent.put(nodeDijkstraF,3);
        adjacent.put(nodeDijkstraE,3);
        adjacent.put(nodeDijkstraH,1);
        return adjacent;
    }

    private Map<NodeDijkstra, Integer> buildAdjacentNodeF(
            final NodeDijkstra nodeDijkstraD,
            final NodeDijkstra nodeDijkstraG
    ) {
        final Map<NodeDijkstra, Integer> adjacent = new HashMap<>();
        adjacent.put(nodeDijkstraD,1);
        adjacent.put(nodeDijkstraG,3);
        return adjacent;
    }

    private Map<NodeDijkstra, Integer> buildAdjacentNodeE(
            final NodeDijkstra nodeDijkstraD, 
            final NodeDijkstra nodeDijkstraG,
            final NodeDijkstra nodeDijkstraH
    ) {
        final Map<NodeDijkstra, Integer> adjacent = new HashMap<>();
        adjacent.put(nodeDijkstraD,2);
        adjacent.put(nodeDijkstraG,3);
        adjacent.put(nodeDijkstraH,3);
        return adjacent;
    }

    private Map<NodeDijkstra, Integer> buildAdjacentNodeD(
            final NodeDijkstra nodeDijkstraB, 
            final NodeDijkstra nodeDijkstraC, 
            final NodeDijkstra nodeDijkstraF, 
            final NodeDijkstra nodeDijkstraE
    ) {
        final Map<NodeDijkstra, Integer> adjacent = new HashMap<>();
        adjacent.put(nodeDijkstraB,5);
        adjacent.put(nodeDijkstraC,1);
        adjacent.put(nodeDijkstraF,1);
        adjacent.put(nodeDijkstraE,2);
        return adjacent;
    }

    private Map<NodeDijkstra, Integer> buildAdjacentNodeC(
            final NodeDijkstra nodeDijkstraA, 
            final NodeDijkstra nodeDijkstraB, 
            final NodeDijkstra nodeDijkstraD
    ) {
        final Map<NodeDijkstra, Integer> adjacent = new HashMap<>();
        adjacent.put(nodeDijkstraA,4);
        adjacent.put(nodeDijkstraB,2);
        adjacent.put(nodeDijkstraD,1);
        return adjacent;
    }

    private Map<NodeDijkstra, Integer> buildAdjacentNodeB(
            final NodeDijkstra nodeDijkstraA, 
            final NodeDijkstra nodeDijkstraD, 
            final NodeDijkstra nodeDijkstraC
    ) {
        final Map<NodeDijkstra, Integer> adjacent = new HashMap<>();
        adjacent.put(nodeDijkstraA,3);
        adjacent.put(nodeDijkstraD,5);
        adjacent.put(nodeDijkstraC,2);
        return adjacent;
    }

    private Map<NodeDijkstra, Integer> buildAdjacentNodeA(
            final NodeDijkstra nodeDijkstraB, 
            final NodeDijkstra nodeDijkstraC
    ) {
        final Map<NodeDijkstra, Integer> adjacent = new HashMap<>();
        adjacent.put(nodeDijkstraB,3);
        adjacent.put(nodeDijkstraC,4);
        return adjacent;
    }
}
