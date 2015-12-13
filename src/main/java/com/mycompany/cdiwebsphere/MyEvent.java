/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cdiwebsphere;

import java.util.Date;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author dick
 */
@RequestScoped
public class MyEvent {

    @Override
    public String toString() {
        return "instance of myEvent @" + new Date();
    }

    public void cleanup() {
        System.out.println("Cleaning up this event");
    }
}
