/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.ServerInventory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author sakim
 */
public class App {
    
    public static void main(String[] args) {
        ServerDao dao = new ServerDaoInMemImpl();
        
        Server myServer = new Server();
        myServer.setName("hr124");
        myServer.setIp("192.143.43.111");
        myServer.setManufacturer("Dell");
        myServer.setRam(16);
        myServer.setNumProcessors(12);
        myServer.setPurchaseDate(LocalDate.parse("2014-01-10", DateTimeFormatter.ISO_DATE));
        
        dao.addServer(myServer);
        
        List<Server> dells = dao.getServersByManufacturer("Dell");
        for (Server currentServer : dells) {
            System.out.println(currentServer.getName());
        }
        
        dells.stream()
                .forEach(s -> System.out.println(s.getName()));
        
        Map<String, List<Server>> serverMap = dao.getAllServersGroupByManufacturer();
        
        Set<String> manufacturers = serverMap.keySet();
        
        manufacturers.stream()
                .forEach(name -> {
                    System.out.println("============");
                    System.out.println("Manufacturer: " + name);
                    serverMap.get(name).stream().forEach(s -> System.out.println(s.getName()));
                });
        
    }
}
