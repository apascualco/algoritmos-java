package com.apascualco.algoritmos.dijkstra;

import java.util.*;

import static java.util.Objects.isNull;

public class Dijkstra {

    public static Map<NodeDijkstra, Tag> tagging(final NodeDijkstra from) {
        final Map<NodeDijkstra, Tag> tags= new LinkedHashMap<>();
        final List<NodeDijkstra> visited = new ArrayList<>();
        final List<NodeDijkstra> pendingToVisit = new ArrayList<>();

        tags.put(from, Tag.of(null, 0));
        pendingToVisit.add(from);
        NodeDijkstra current;

        while(!pendingToVisit.isEmpty()) {
            current = lowestDistanceNode(tags, visited);
            if(isNull(current)) { break; }
            visited.add(current);

            for(Map.Entry<NodeDijkstra, Integer> adjacency:current.getAdjacency().entrySet()) {
                if(!visited.contains(adjacency.getKey()) && !pendingToVisit.contains(adjacency.getKey())) {
                    pendingToVisit.add(adjacency.getKey());
                }
                if(!visited.contains(adjacency.getKey())) {
                    final Integer weight = tags.get(current).getWeight() + adjacency.getValue();
                    if(!tags.containsKey(adjacency.getKey())) {
                        tags.put(adjacency.getKey(), Tag.of(current, weight));
                    } else if(tags.get(adjacency.getKey()).getWeight() > weight) {
                        tags.put(adjacency.getKey(), Tag.of(current, weight));
                    }
                }
            }
            pendingToVisit.remove(current);
        }
        return tags;
    }

    private static NodeDijkstra lowestDistanceNode(
            final Map<NodeDijkstra, Tag> tags,
            final List<NodeDijkstra> visited) {
        Integer min = Integer.MAX_VALUE;
        NodeDijkstra minNode = null;
        for(Map.Entry<NodeDijkstra, Tag> node:tags.entrySet()) {
            if(node.getValue().getWeight() < min && ! visited.contains(node.getKey())) {
                min = node.getValue().getWeight();
                minNode = node.getKey();
            }
        }
        return minNode;
    }

}
