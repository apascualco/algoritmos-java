package com.apascualco.algoritmos.dijkstra;

import java.util.Map;

public class NodeDijkstra {

    private final String name;

    private Map<NodeDijkstra, Integer> adjacency;

    public NodeDijkstra(String name) {
        this.name = name;
    }

    public Map<NodeDijkstra, Integer> getAdjacency() {
        return adjacency;
    }

    public void setAdjacency(Map<NodeDijkstra, Integer> adjacency) {
        this.adjacency = adjacency;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "NodeDijkstra{" +
                "name='" + name + '\'' +
                '}';
    }
}
