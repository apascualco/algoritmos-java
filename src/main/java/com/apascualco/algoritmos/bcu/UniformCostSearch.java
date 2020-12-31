package com.apascualco.algoritmos.bcu;

import java.util.*;

import static java.util.Objects.isNull;

class UniformCostSearch {

    private final List<NodeBCU> frontier = new LinkedList<>();
    private final List<NodeBCU> visited = new LinkedList<>();

    Optional<NodeBCU> search(final Connections connections, final NodeBCU from, final String to) {
        if(isNull(from)) {
            throw new NullPointerException("From shouldn't be null");
        }
        if(isNull(to) || to.isEmpty()) {
            throw new NullPointerException("To shouldn't be null or empty");
        }
        boolean foundFinalState = false;
        Optional<NodeBCU> foundNode = Optional.empty();

        from.setCost(0);
        frontier.add(from);

        while(!foundFinalState && frontier.size() != 0) {
            frontier.sort(Comparator.comparing(NodeBCU::getCost));
            final NodeBCU nodeBCU = this.frontier.remove(0);
            visited.add(nodeBCU);

            if(nodeBCU.getCity().equals(to)) {
                foundFinalState = true;
                foundNode = Optional.of(nodeBCU);
            } else {
                final String nodeCity = nodeBCU.getCity();
                final List<NodeBCU> childList = new LinkedList<>();
                connections.getConnections().get(nodeCity).forEach(connection -> {
                    final NodeBCU child = NodeBCU.of(connection.getCity());
                    child.setCost(nodeBCU.getCost() + connection.getDistance());
                    child.setParent(nodeBCU);
                    childList.add(child);
                    if(!visited.contains(child)) {
                        if(frontier.contains(child)) {
                            final List<NodeBCU> removeNodes = new LinkedList<>();
                            final List<NodeBCU> addNodes = new LinkedList<>();
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
                            nodeBCU.addAllChild(childList);
                        }
                    }
                });
            }

        }
        return foundNode;
    }
}
