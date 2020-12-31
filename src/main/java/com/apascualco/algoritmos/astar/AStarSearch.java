package com.apascualco.algoritmos.astar;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

class AStarSearch {

    private final List<NodeAStar> frontier = new LinkedList<>();
    private final List<NodeAStar> visited = new LinkedList<>();

    private Comparator<NodeAStar> nodeAStarComparator(final City destination) {
        return (o1, o2) -> {
            final int costCity1 = o1.getCost();
            final int heuristicValue1 = distance(o1.getCity().getCoords(), destination.getCoords()).intValue();
            final int functionCity1Result = costCity1 + heuristicValue1;

            final int costCity2 = o2.getCost();
            final int heuristicValue2 = distance(o2.getCity().getCoords(), destination.getCoords()).intValue();
            final int functionCity2Result = costCity2 + heuristicValue2;
            return functionCity1Result - functionCity2Result;
        };
    }
    private Double distance(final Coords coords1, final Coords coords2) {
        if ((coords1.getLatitude() == coords2.getLatitude()) && (coords1.getLongitude() == coords2.getLongitude())) {
            return 0.0;
        } else {
            double distance = Math.sin(Math.toRadians(coords1.getLatitude()))
                    * Math.sin(Math.toRadians(coords2.getLatitude())) + Math.cos(Math.toRadians(coords1.getLatitude()))
                    * Math.cos(Math.toRadians(coords2.getLatitude()))
                    * Math.cos(Math.toRadians(coords1.getLongitude() - coords2.getLongitude()));
            distance = Math.acos(distance);
            distance = Math.toDegrees(distance);
            distance = distance * 60 * 1.1515;
            return distance * 1.609344;
        }
    }

    Optional<NodeAStar> search(final Connections connections, final NodeAStar from, final City destination) {
        if(isNull(from)) {
            throw new NullPointerException("From shouldn't be null");
        }
        if(isNull(destination)) {
            throw new NullPointerException("To shouldn't be null or empty");
        }
        boolean foundFinalState = false;
        Optional<NodeAStar> foundNode = Optional.empty();

        from.setCost(0);
        frontier.add(from);

        while(!foundFinalState && frontier.size() != 0) {
            frontier.sort(nodeAStarComparator(destination));
            final NodeAStar nodeAStar = this.frontier.remove(0);
            visited.add(nodeAStar);

            if(nodeAStar.getCity().equals(destination)) {
                foundFinalState = true;
                foundNode = Optional.of(nodeAStar);
            } else {
                final City nodeCity = nodeAStar.getCity();
                final List<NodeAStar> childList = new LinkedList<>();
                connections.getConnections().get(nodeCity).forEach(connection -> {
                    final NodeAStar child = NodeAStar.of(connection.getCity());
                    child.setCost(nodeAStar.getCost() + connection.getDistance());
                    child.setParent(nodeAStar);
                    childList.add(child);
                    if(!visited.contains(child)) {
                        if(frontier.contains(child)) {
                            final List<NodeAStar> removeNodes = new LinkedList<>();
                            final List<NodeAStar> addNodes = new LinkedList<>();
                            frontier.forEach(node -> {
                                if(node.equals(child) && node.getCost() > child.getCost()) {
                                    removeNodes.add(node);
                                    addNodes.add(child);
                                }
                            });
                            frontier.removeAll(removeNodes);
                            frontier.addAll(addNodes);
                        } else {
                            frontier.add(child);
                            nodeAStar.addAllChild(childList);
                        }
                    }
                });
            }

        }
        return foundNode;
    }
}
