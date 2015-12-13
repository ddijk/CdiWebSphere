/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cdiwebsphere;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.apache.log4j.Logger;

/**
 *
 * @author dick
 */
@Model
public class NewJSFManagedBean {

    String naam = "Fish";
    private static final Logger logger = Logger.getLogger(NewJSFManagedBean.class);

    static int key = 99;

    @Inject
    @EventQualifier
    MyEvent me;

    List<Customer> resultList = new ArrayList<>();

    @Inject
    Dao dao;

    @PostConstruct
    public void init() {
        logger.info("Created Bean @" + new Date());

//
//        logger.info("Aantal " + resultList.size() + " @@" + new Date());
    }

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public NewJSFManagedBean() {
    }

    public String getNaam() {
        return naam;
    }

    public void clicked() {
        logger.info("Event received: " + me);
        dao.saveCustomer(key++);

    }

    public List<Customer> getCustomers() {

        logger.info("getCustomers() called");
        resultList = dao.getCustomers();
        return resultList;

    }

}
