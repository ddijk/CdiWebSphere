/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cdiwebsphere;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dick
 */
@Singleton
@Startup
public class MyProvider {

    @PersistenceContext
    EntityManager em;

//    @PostConstruct
//    public void init() {
//        DiscountCode dc = new DiscountCode("A");
//        MicroMarket mm = new MicroMarket("2411LN");
//        Customer c = new Customer(99);
//        c.setName("dick");
//        c.setDiscountCode(dc);
//        c.setZip(mm);
//        em.persist(dc);
//        em.persist(mm);
//        em.persist(c);
//    }
    @Produces
    @EventQualifier
    @RequestScoped
    public MyEvent supply() {
        return new MyEvent();
    }

    public void cleanup(@Disposes @EventQualifier MyEvent me) {

        System.out.println("Cleaning up " + me);
        me.cleanup();
    }
}
