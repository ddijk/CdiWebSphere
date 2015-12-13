/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cdiwebsphere;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.apache.log4j.Logger;

/**
 *
 * @author dick
 */
@Stateless
public class Dao {

    @Inject
    EntityManager em;

//    @Inject
//    Event<Customer> entityEvent;
    private static final Logger logger = Logger.getLogger(Dao.class);
    private static final String ZIPCODE = "2411LN";
    private static final String DISCOUNT_CODE = "A";

    public void saveCustomer(int key) {

        MicroMarket mm = getMarket();
        Customer c = new Customer(key);
        c.setName("dick_" + key);
        c.setDiscountCode(getDc());
        c.setZip(mm);

        em.joinTransaction();
        System.out.println("TX joined");
        em.persist(c);

        //   entityEvent.fire(c);
        logger.info("Customer saved with key " + key);
    }

    public List<Customer> getCustomers() {
        return em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }

    DiscountCode getDc() {
        DiscountCode dc = em.find(DiscountCode.class, DISCOUNT_CODE);
        if (dc == null) {
            logger.info("Discount code not found, creating it");
            dc = new DiscountCode(DISCOUNT_CODE);
            em.persist(dc);
        }

        return dc;

    }

    public MicroMarket getMarket() {
        MicroMarket mc = em.find(MicroMarket.class, ZIPCODE);
        if (mc == null) {
            logger.info("Micromarket not found, creating it");
            mc = new MicroMarket(ZIPCODE);
            em.persist(mc);
        }

        return mc;

    }

}
