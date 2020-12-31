package com.apascualco.algoritmos.dijkstra;

import static java.util.Objects.nonNull;

public class Tag {

    private final NodeDijkstra node;

    private final Integer weight;

    private Tag(NodeDijkstra node, Integer weight) {
        this.node = node;
        this.weight = weight;
    }

    public static Tag of(final NodeDijkstra node, final Integer weight) {
        return new Tag(node,weight);
    }

    public NodeDijkstra getNode() {
        return node;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        String n = nonNull(node) ? ", node=" + node.getName()  : ", node=";
        return "Tag{ weight=" + weight + ", node=" + n + "}";
    }
}
