package com.apascualco.algoritmos.astar;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Connections {

    private City zaragoza = City.of("ZARAGOZA", Coords.of(41.652134, -0.8809428));
    private City valencia = City.of("VALENCIA", Coords.of(39.469901, -0.375951));
    private City barcelona = City.of("BARCELONA", Coords.of(41.382894, 2.177432));
    private City madrid = City.of("MADRID", Coords.of(40.416705, -3.703582));
    private City murcia = City.of("MURCIA", Coords.of(37.99238, -1.130543));
    private City granada = City.of("GRANADA", Coords.of(12.136037, -61.690404));
    private City huelva = City.of("HUELVA", Coords.of(37.257587, -6.948494));
    private City caceres = City.of("CACERES", Coords.of(39.474518, -6.371676));
    private City valladolid = City.of("VALLADOLID", Coords.of(41.652133, -4.728562));
    private City ourense = City.of("OURENSE", Coords.of(42.196846, -7.61141));
    private City santander = City.of("SANTANDER", Coords.of(43.462041, -3.809972));
    private City oviedo = City.of("OVIEDO", Coords.of(43.360598, -5.844899));
    private City bilbado = City.of("BILBAO", Coords.of(43.263005, -2.934991));

    private final List<Connection> BARCELONA = new LinkedList<>();
    {
        BARCELONA.add(Connection.of(zaragoza, 312));
        BARCELONA.add(Connection.of(valencia, 349));
    }
    private final List<Connection> VALENCIA = new LinkedList<>();
    {
        VALENCIA.add(Connection.of(barcelona, 349));
        VALENCIA.add(Connection.of(madrid, 350));
        VALENCIA.add(Connection.of(murcia, 220));
    }
    private final List<Connection> MURCIA = new LinkedList<>();
    {
        MURCIA.add(Connection.of(valencia, 220));
        MURCIA.add(Connection.of(madrid, 400));
        MURCIA.add(Connection.of(granada, 270));
    }
    private final List<Connection> GRANADA = new LinkedList<>();
    {
        GRANADA.add(Connection.of(murcia, 270));
        GRANADA.add(Connection.of(madrid, 420));
        GRANADA.add(Connection.of(huelva, 345));
    }
    private final List<Connection> HUELVA = new LinkedList<>();
    {
        HUELVA.add(Connection.of(granada, 345));
        HUELVA.add(Connection.of(madrid, 600));
        HUELVA.add(Connection.of(caceres, 345));
    }
    private final List<Connection> CACERES = new LinkedList<>();
    {
        CACERES.add(Connection.of(huelva, 345));
        CACERES.add(Connection.of(madrid, 300));
        CACERES.add(Connection.of(valladolid, 325));
        CACERES.add(Connection.of(ourense, 520));
    }
    private final List<Connection> OURENSE = new LinkedList<>();
    {
        OURENSE.add(Connection.of(caceres, 520));
        OURENSE.add(Connection.of(valladolid, 325));
        OURENSE.add(Connection.of(santander, 543));
        OURENSE.add(Connection.of(oviedo, 361));
    }
    private final List<Connection> OVIEDO = new LinkedList<>();
    {
        OVIEDO.add(Connection.of(ourense, 361));
    }
    private final List<Connection> SANTANDER = new LinkedList<>();
    {
        SANTANDER.add(Connection.of(ourense, 543));
        SANTANDER.add(Connection.of(valladolid, 600));
        SANTANDER.add(Connection.of(bilbado, 99));
    }
    private final List<Connection> BILBAO = new LinkedList<>();
    {
        BILBAO.add(Connection.of(santander, 99));
        BILBAO.add(Connection.of(zaragoza, 303));
        BILBAO.add(Connection.of(valladolid, 270));
    }
    private final List<Connection> ZARAGOZA = new LinkedList<>();
    {
        ZARAGOZA.add(Connection.of(bilbado, 99));
        ZARAGOZA.add(Connection.of(barcelona, 303));
        ZARAGOZA.add(Connection.of(valladolid, 270));
        ZARAGOZA.add(Connection.of(madrid, 310));
    }
    private final List<Connection> MADRID = new LinkedList<>();
    {
        MADRID.add(Connection.of(valencia, 350));
        MADRID.add(Connection.of(murcia, 400));
        MADRID.add(Connection.of(granada, 420));
        MADRID.add(Connection.of(huelva, 600));
        MADRID.add(Connection.of(caceres, 300));
        MADRID.add(Connection.of(valladolid, 191));
        MADRID.add(Connection.of(zaragoza, 310));
    }
    private final List<Connection> VALLADOLID = new LinkedList<>();
    {
        VALLADOLID.add(Connection.of(madrid, 191));
        VALLADOLID.add(Connection.of(zaragoza, 375));
        VALLADOLID.add(Connection.of(bilbado, 270));
        VALLADOLID.add(Connection.of(santander, 247));
        VALLADOLID.add(Connection.of(ourense, 347));
        VALLADOLID.add(Connection.of(caceres, 325));
    }
    private final Map<City,List<Connection>> connections = new HashMap<>();
    {
        connections.put(barcelona, BARCELONA);
        connections.put(valencia, VALENCIA);
        connections.put(murcia, MURCIA);
        connections.put(granada, GRANADA);
        connections.put(huelva, HUELVA);
        connections.put(caceres, CACERES);
        connections.put(ourense, OURENSE);
        connections.put(oviedo, OVIEDO);
        connections.put(santander, SANTANDER);
        connections.put(bilbado, BILBAO);
        connections.put(zaragoza, ZARAGOZA);
        connections.put(madrid, MADRID);
        connections.put(valladolid, VALLADOLID);
    }

    Map<City, List<Connection>> getConnections() {
        return connections;
    }

    public City getZaragoza() {
        return zaragoza;
    }

    public City getBarcelona() {
        return barcelona;
    }

    public City getGranada() {
        return granada;
    }

    public City getHuelva() {
        return huelva;
    }

    public City getValladolid() {
        return valladolid;
    }

    public City getOviedo() {
        return oviedo;
    }

    public City getBilbado() {
        return bilbado;
    }

    public City getSantander() {
        return santander;
    }
}
