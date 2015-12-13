/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cdiwebsphere;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author dick
 */
@Singleton
@Startup
public class EntityManagerProvider {

    EntityManagerFactory emf;

    @PostConstruct
    public void init() {

        Map map = new HashMap<>();

        map.put("javax.persistence.jtaDataSource", "jdbc/GlassfishDS");
        emf = Persistence.createEntityManagerFactory("com.mycompany_CdiWebSphere_war_1.0-SNAPSHOTPU", map);

    }

    @Produces
    @RequestScoped
    public EntityManager createEm() {

        System.out.println("About to create EM");
        final EntityManager em = emf.createEntityManager();

        System.out.println("EM created");

        return em;

    }

    public void ruimOp(@Disposes EntityManager em) {
        System.out.println("About to close EM");
        em.close();
        System.out.println("EM closed");
    }

    @PreDestroy
    public void goingDown() {

        System.out.println("About to close EMF");
        emf.close();
        System.out.println("EMF closed");
    }

}
