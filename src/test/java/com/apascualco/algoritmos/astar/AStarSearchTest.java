package com.apascualco.algoritmos.astar;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.isNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AStarSearchTest {

    private AStarSearch astarSearch;
    private Connections connections;

    public AStarSearchTest() {
        this.astarSearch = new AStarSearch();
        this.connections = new Connections();
    }

    @Test
    public void testing_barcelona_to_oviedo() {
        final NodeAStar nodeAStar = astarSearch.search(
                connections,
                NodeAStar.of(connections.getBarcelona()),
                connections.getOviedo()
        ).orElseThrow(NullPointerException::new);
        assertNotNull(nodeAStar);
        assertEquals(Integer.valueOf(1290),  nodeAStar.getCost());
        final List<NodeAStar> cities = getNodeList(nodeAStar);
        assertEquals(5, cities.size());
    }

    @Test
    public void testing_granada_to_zaragoza() {
        final NodeAStar nodeAStar = astarSearch.search(
                connections,
                NodeAStar.of(connections.getGranada()),
                connections.getZaragoza()
        ).orElseThrow(NullPointerException::new);
        assertNotNull(nodeAStar);
        assertEquals(Integer.valueOf(730),  nodeAStar.getCost());
        final List<NodeAStar> cities = getNodeList(nodeAStar);
        assertEquals(3, cities.size());
    }

    @Test
    public void testing_huelva_to_bilbao() {
        final NodeAStar nodeAStar = astarSearch.search(
                connections,
                NodeAStar.of(connections.getHuelva()),
                connections.getBilbado()
        ).orElseThrow(NullPointerException::new);
        assertNotNull(nodeAStar);
        assertEquals(Integer.valueOf(940), nodeAStar.getCost());
        final List<NodeAStar> cities = getNodeList(nodeAStar);
        assertEquals(4, cities.size());
        assertEquals(connections.getValladolid(), cities.get(1).getCity());
    }

    @Test
    public void testing_huelva_to_bilbao_with_valladolid_have_more_km_270_to_370() {
        connections.getConnections().get(connections.getValladolid()).stream()
                .filter(node -> node.getCity().equals(connections.getBilbado()))
                .forEach(node -> node.setDistance(370));

        final NodeAStar nodeAStar = astarSearch.search(
                connections,
                NodeAStar.of(connections.getHuelva()),
                connections.getBilbado()
        ).orElseThrow(NullPointerException::new);
        assertNotNull(nodeAStar);
        final List<NodeAStar> cities = getNodeList(nodeAStar);
        assertEquals(5, cities.size());
        assertEquals(connections.getSantander(), cities.get(1).getCity());
    }

    @Test
    public void real_test() {
        long initialTime = System.currentTimeMillis();
        final NodeAStar nodeBFS = astarSearch.search(
                connections,
                NodeAStar.of(connections.getBarcelona()),
                connections.getOviedo()
        ).orElseThrow(NullPointerException::new);
        final List<NodeAStar> NodeAStarList = getNodeList(nodeBFS);
        Collections.reverse(NodeAStarList);
        System.out.println("Solution in: " + NodeAStarList.size() + " levels [" + String.join(",", NodeAStarList.toString()) + "] time: " + (System.currentTimeMillis()-initialTime) + "ms");
    }

    private List<NodeAStar> getNodeList(final NodeAStar nodeAStar) {
        boolean parentNull = false;
        NodeAStar current = nodeAStar;
        final List<NodeAStar> nodeAStarList = new LinkedList<>();
        while(!parentNull) {
            nodeAStarList.add(current);
            if(isNull(current.getParent())) {
                parentNull = true;
            }
            current = current.getParent();
        }
        return nodeAStarList;
    }
}
