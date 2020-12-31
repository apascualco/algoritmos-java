package com.apascualco.algoritmos.bfs;

import java.util.Arrays;

public final class NodeBFS {

    private int[] state;
    private NodeBFS parent;

    @SuppressWarnings("unused")
    private NodeBFS() { }

    private NodeBFS(final int[] state) {
        this.state = state;
    }

    static NodeBFS of(final int[] dato) {
        return new NodeBFS(dato);
    }

    int[] getState() {
        return state;
    }

    NodeBFS getParent() {
        return parent;
    }

    void setParent(final NodeBFS parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        NodeBFS nodeBFS = (NodeBFS) object;
        return Arrays.equals(this.state, nodeBFS.state);

    }

    @Override
    public String toString() {
        return Arrays.toString(this.getState());
    }
}
