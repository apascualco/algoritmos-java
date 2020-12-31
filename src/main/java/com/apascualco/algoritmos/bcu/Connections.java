package com.apascualco.algoritmos.bcu;

import java.util.*;

class Connections {

    private final List<Connection> BARCELONA = new LinkedList<>();
    {
        BARCELONA.add(Connection.of("ZARAGOZA", 312));
        BARCELONA.add(Connection.of("VALENCIA", 349));
    }
    private final List<Connection> VALENCIA = new LinkedList<>();
    {
        VALENCIA.add(Connection.of("BARCELONA", 349));
        VALENCIA.add(Connection.of("MADRID", 350));
        VALENCIA.add(Connection.of("MURCIA", 220));
    }
    private final List<Connection> MURCIA = new LinkedList<>();
    {
        MURCIA.add(Connection.of("VALENCIA", 220));
        MURCIA.add(Connection.of("MADRID", 400));
        MURCIA.add(Connection.of("GRANADA", 270));
    }
    private final List<Connection> GRANADA = new LinkedList<>();
    {
        GRANADA.add(Connection.of("MURCIA", 270));
        GRANADA.add(Connection.of("MADRID", 420));
        GRANADA.add(Connection.of("HUELVA", 345));
    }
    private final List<Connection> HUELVA = new LinkedList<>();
    {
        HUELVA.add(Connection.of("GRANADA", 345));
        HUELVA.add(Connection.of("MADRID", 600));
        HUELVA.add(Connection.of("CACERES", 345));
    }
    private final List<Connection> CACERES = new LinkedList<>();
    {
        CACERES.add(Connection.of("HUELVA", 345));
        CACERES.add(Connection.of("MADRID", 300));
        CACERES.add(Connection.of("VALLADOLID", 325));
        CACERES.add(Connection.of("OURENSE", 520));
    }
    private final List<Connection> OURENSE = new LinkedList<>();
    {
        OURENSE.add(Connection.of("CACERES", 520));
        OURENSE.add(Connection.of("VALLADOLID", 325));
        OURENSE.add(Connection.of("SANTANDER", 543));
        OURENSE.add(Connection.of("OVIEDO", 361));
    }
    private final List<Connection> OVIEDO = new LinkedList<>();
    {
        OVIEDO.add(Connection.of("OURENSE", 361));
    }
    private final List<Connection> SANTANDER = new LinkedList<>();
    {
        SANTANDER.add(Connection.of("OURENSE", 543));
        SANTANDER.add(Connection.of("VALLADOLID", 600));
        SANTANDER.add(Connection.of("BILBAO", 99));
    }
    private final List<Connection> BILBAO = new LinkedList<>();
    {
        BILBAO.add(Connection.of("SANTANDER", 99));
        BILBAO.add(Connection.of("ZARAGOZA", 303));
        BILBAO.add(Connection.of("VALLADOLID", 270));
    }
    private final List<Connection> ZARAGOZA = new LinkedList<>();
    {
        ZARAGOZA.add(Connection.of("BILBAO", 99));
        ZARAGOZA.add(Connection.of("BARCELONA", 303));
        ZARAGOZA.add(Connection.of("VALLADOLID", 270));
        ZARAGOZA.add(Connection.of("MADRID", 310));
    }
    private final List<Connection> MADRID = new LinkedList<>();
    {
        MADRID.add(Connection.of("VALENCIA", 350));
        MADRID.add(Connection.of("MURCIA", 400));
        MADRID.add(Connection.of("GRANADA", 420));
        MADRID.add(Connection.of("HUELVA", 600));
        MADRID.add(Connection.of("CACERES", 300));
        MADRID.add(Connection.of("VALLADOLID", 191));
        MADRID.add(Connection.of("ZARAGOZA", 310));
    }
    private final List<Connection> VALLADOLID = new LinkedList<>();
    {
        VALLADOLID.add(Connection.of("MADRID", 191));
        VALLADOLID.add(Connection.of("ZARAGOZA", 375));
        VALLADOLID.add(Connection.of("BILBAO", 270));
        VALLADOLID.add(Connection.of("SANTANDER", 247));
        VALLADOLID.add(Connection.of("OURENSE", 347));
        VALLADOLID.add(Connection.of("CACERES", 325));
    }
    private final Map<String,List<Connection>> connections = new HashMap<>();
    {
        connections.put("BARCELONA", BARCELONA);
        connections.put("VALENCIA", VALENCIA);
        connections.put("MURCIA", MURCIA);
        connections.put("GRANADA", GRANADA);
        connections.put("HUELVA", HUELVA);
        connections.put("CACERES", CACERES);
        connections.put("OURENSE", OURENSE);
        connections.put("OVIEDO", OVIEDO);
        connections.put("SANTANDER", SANTANDER);
        connections.put("BILBAO", BILBAO);
        connections.put("ZARAGOZA", ZARAGOZA);
        connections.put("MADRID", MADRID);
        connections.put("VALLADOLID", VALLADOLID);
    }

    Map<String, List<Connection>> getConnections() {
        return connections;
    }
}
