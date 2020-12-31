package com.apascualco.algoritmos.bcu;

import java.util.LinkedList;
import java.util.List;

public final class NodeBCU {

    private String city;
    private NodeBCU parent;
    private Integer cost;
    private List<NodeBCU> childList = new LinkedList<>();

    @SuppressWarnings("unused")
    private NodeBCU() { }

    private NodeBCU(final String city) {
        this.city = city;
    }

    static NodeBCU of(final String city) {
        return new NodeBCU(city);
    }

    String getCity() {
        return city;
    }

    NodeBCU getParent() {
        return parent;
    }

    void setParent(final NodeBCU parent) {
        this.parent = parent;
    }

    Integer getCost() {
        return cost;
    }

    void setCost(Integer cost) {
        this.cost = cost;
    }

    void addAllChild(List<NodeBCU> childList) {
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
        NodeBCU nodeBCU = (NodeBCU) object;
        return this.city.equals(nodeBCU.city);

    }

    @Override
    public String toString() {
        return this.getCity();
    }
}
