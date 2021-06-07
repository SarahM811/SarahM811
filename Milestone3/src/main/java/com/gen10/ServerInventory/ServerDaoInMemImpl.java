/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.ServerInventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author sakim
 */
public class ServerDaoInMemImpl implements ServerDao {

    private Map<String, Server> serverMap = new HashMap<>();
    
    @Override
    public void addServer(Server server) {
        serverMap.put(server.getName(), server);
    }

    @Override
    public Server getServer(String name) {
        return serverMap.get(name);
    }

    @Override
    public void removeServer(String name) {
        serverMap.remove(name);
    }

    @Override
    public List<Server> getAllServers() {
        return new ArrayList<Server>(serverMap.values());
    }

    @Override
    public Map<String, List<Server>> getAllServersGroupByManufacturer() {
        //get all servers and put into stream
        return serverMap.values()
                .stream()
                //sort it/collect them by manufacturer
                .collect(Collectors.groupingBy(Server::getManufacturer));
                //the same thing below
                //.collect(Collectors.groupingBy(s -> s.getManufacturer()));
    }

    @Override
    public List<Server> getServersByManufacturer(String manufacturer) {
        //have filtering step in pipeline
        return serverMap.values()
                .stream()
                //intermediate operation filter predicate takes a server in and filter out based on criteria
                //if manufacturers name equals is true, keep the server, if false, throw away
                .filter(s -> s.getManufacturer().equalsIgnoreCase(manufacturer))
                .collect(Collectors.toList());
    }

    @Override
    public List<Server> getServersOlderThan(int ageInYears) {
        return serverMap.values()
                .stream()
                .filter(s -> s.getServerAge() > ageInYears)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Server>> getServersOlderThanGroupByManufacturer(int ageInYears) {
      return serverMap.values()
                .stream()
                .filter(s -> s.getServerAge() > ageInYears)
                .collect(Collectors.groupingBy(Server::getManufacturer));  
    }

    @Override
    public double getAverageServerAge() {
        return serverMap.values()
                //collection of server objects and grab in stream
                .stream()
                //intermediate operation mapToLong
                //transform into stream of long
               // .mapToLong(s -> s.getServerAge())
                .mapToLong(Server::getServerAge)
                .average()
                .getAsDouble();
    }
    
}
