/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cdiwebsphere;

import javax.enterprise.event.Observes;
import static javax.enterprise.event.TransactionPhase.AFTER_COMPLETION;
import static javax.enterprise.event.TransactionPhase.AFTER_FAILURE;
import static javax.enterprise.event.TransactionPhase.AFTER_SUCCESS;
import static javax.enterprise.event.TransactionPhase.BEFORE_COMPLETION;
import static javax.enterprise.event.TransactionPhase.IN_PROGRESS;

//@Singleton
//@Startup
public class MyTxMonitorBean {

    public void inProgress(@Observes(during = IN_PROGRESS) Customer a) {
        System.out.println("EVENT IN PROGRESS for " + a);
    }

    public void beforeCompl(@Observes(during = BEFORE_COMPLETION) Customer a) {
        System.out.println("EVENT BEFORE COMPLETION for " + a);
    }

    public void afterCompl(@Observes(during = AFTER_COMPLETION) Customer a) {
        System.out.println("EVENT AFTER_COMPLETION for " + a);
    }

    public void afterSuccess(@Observes(during = AFTER_SUCCESS) Customer a) {
        System.out.println("EVENT AFTER_SUCCESS for " + a);
    }

    public void afterFailure(@Observes(during = AFTER_FAILURE) Customer a) {
        System.out.println("EVENT AFTER_FAILURE for " + a);
    }
}
