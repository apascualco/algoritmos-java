package com.apascualco.algoritmos.astar;

import java.util.LinkedList;
import java.util.List;

public final class NodeAStar {

    private City city;
    private NodeAStar parent;
    private Integer cost;
    private List<NodeAStar> childList = new LinkedList<>();

    @SuppressWarnings("unused")
    private NodeAStar() { }

    private NodeAStar(final City city) {
        this.city = city;
    }

    static NodeAStar of(final City city) {
        return new NodeAStar(city);
    }

    City getCity() {
        return city;
    }

    NodeAStar getParent() {
        return parent;
    }

    void setParent(final NodeAStar parent) {
        this.parent = parent;
    }

    Integer getCost() {
        return cost;
    }

    void setCost(Integer cost) {
        this.cost = cost;
    }

    void addAllChild(List<NodeAStar> childList) {
        this.childList.addAll(childList);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        NodeAStar nodeAStar = (NodeAStar) object;
        return this.city.equals(nodeAStar.city);

    }

    @Override
    public String toString() {
        return this.getCity().getName();
    }
}
