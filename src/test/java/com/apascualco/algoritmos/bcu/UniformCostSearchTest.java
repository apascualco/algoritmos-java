package com.apascualco.algoritmos.bcu;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.isNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UniformCostSearchTest {

    private UniformCostSearch uniformCostSearch;

    public UniformCostSearchTest() {
        this.uniformCostSearch = new UniformCostSearch();
    }

    @Test
    public void testing_barcelona_to_oviedo() {
        final NodeBCU nodeBCU = uniformCostSearch.search(new Connections(), NodeBCU.of("BARCELONA"), "OVIEDO").orElseThrow(NullPointerException::new);
        assertNotNull(nodeBCU);
        assertEquals(Integer.valueOf(1290),  nodeBCU.getCost());
        final List<NodeBCU> cities = getNodeList(nodeBCU);
        assertEquals(5, cities.size());
    }

    @Test
    public void testing_granada_to_zaragoza() {
        final NodeBCU nodeBCU = uniformCostSearch.search(new Connections(), NodeBCU.of("GRANADA"), "ZARAGOZA").orElseThrow(NullPointerException::new);
        assertNotNull(nodeBCU);
        assertEquals(Integer.valueOf(730),  nodeBCU.getCost());
        final List<NodeBCU> cities = getNodeList(nodeBCU);
        assertEquals(3, cities.size());
    }

    @Test
    public void testing_huelva_to_bilbao() {
        final NodeBCU nodeBCU = uniformCostSearch.search(new Connections(), NodeBCU.of("HUELVA"), "BILBAO").orElseThrow(NullPointerException::new);
        assertNotNull(nodeBCU);
        assertEquals(Integer.valueOf(940),  nodeBCU.getCost());
        final List<NodeBCU> cities = getNodeList(nodeBCU);
        assertEquals(4, cities.size());
        assertEquals("VALLADOLID", cities.get(1).getCity());
    }

    @Test
    public void testing_huelva_to_bilbao_with_valladolid_have_more_km_270_to_370() {
        final Connections connections = new Connections();
        connections.getConnections().get("VALLADOLID").stream().filter(node -> node.getCity().equals("BILBAO")).forEach(node -> node.setDistance(370));
        final NodeBCU nodeBCU = uniformCostSearch.search(connections, NodeBCU.of("HUELVA"), "BILBAO").orElseThrow(NullPointerException::new);
        assertNotNull(nodeBCU);
        assertEquals(Integer.valueOf(1009),  nodeBCU.getCost());
        final List<NodeBCU> cities = getNodeList(nodeBCU);
        assertEquals(4, cities.size());
        assertEquals("ZARAGOZA", cities.get(1).getCity());
    }

    @Test
    public void real_test() {
        long initialTime = System.currentTimeMillis();
        final NodeBCU nodeBFS = uniformCostSearch.search(new Connections(), NodeBCU.of("BARCELONA"), "OVIEDO").orElseThrow(NullPointerException::new);
        final List<NodeBCU> nodeBCUList = getNodeList(nodeBFS);
        Collections.reverse(nodeBCUList);
        System.out.println("Solution in: " + nodeBCUList.size() + " levels [" + String.join(",", nodeBCUList.toString()) + "] time: " + (System.currentTimeMillis()-initialTime) + "ms");
    }

    private List<NodeBCU> getNodeList(final NodeBCU nodeBCU) {
        boolean parentNull = false;
        NodeBCU current = nodeBCU;
        final List<NodeBCU> nodeBCUList = new LinkedList<>();
        while(!parentNull) {
            nodeBCUList.add(current);
            if(isNull(current.getParent())) {
                parentNull = true;
            }
            current = current.getParent();
        }
        return nodeBCUList;
    }
}
