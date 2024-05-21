package Propuesto1;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class ServerSide {
    public static void main(String[] args) throws Exception {
        System.setProperty("java.rmi.server.hostname", "192.168.0.6");
        
        LocateRegistry.createRegistry(1099);
        Stock pharmacy = new Stock();
        pharmacy.addMedicine("Paracetamol", 3.2f, 10);
        pharmacy.addMedicine("Mejoral", 2.0f, 20);
        pharmacy.addMedicine("Amoxilina", 1.0f, 30);
        pharmacy.addMedicine("Aspirina", 5.0f, 40);
        Naming.rebind("PHARMACY", pharmacy);
        System.out.println("Server ready");
    }
}