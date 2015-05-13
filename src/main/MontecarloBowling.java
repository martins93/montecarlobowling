/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import montecarlo.Montecarlo;

/**
 *
 * @author Martin
 */
public class MontecarloBowling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Montecarlo monte = new Montecarlo(0,10);
        monte.armarMontecarlo();
        System.out.println(monte.toString());
       
        
        // TODO code application logic here
    }
    
}
