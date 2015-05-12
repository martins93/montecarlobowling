/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlo;

import java.util.LinkedList;

/**
 *
 * @author Martin
 */
public class Montecarlo {

    private LinkedList<Fila> filas;
    private int desde;
    private int hasta;
    private int puntosTotal;
    
    
    public Montecarlo(int desde, int hasta)

    {
        filas = new LinkedList<>();
        this.desde = desde;
        this.hasta = hasta;
        this.puntosTotal=0;
    }

    public LinkedList<Fila> getFilas() {
        return filas;
    }

    public void setFilas(LinkedList<Fila> filas) {
        this.filas = filas;
    }

    public int getDesde() {
        return desde;
    }

    public void setDesde(int desde) {
        this.desde = desde;
    }

    public int getHasta() {
        return hasta;
    }

    public void setHasta(int hasta) {
        this.hasta = hasta;
    }

    public int getPuntosTotal() {
        return puntosTotal;
    }

    public void setPuntosTotal(int puntosTotal) {
        this.puntosTotal = puntosTotal;
    }
    
    
    public void armarMontecarlo()
    {
        Fila f = new Fila(1);
        
        for (int i = 1; i <= hasta; i++) {
            
            puntosTotal+=f.getPts();
            f = f.calcularProxFila(f);
            if(i>=desde)
            {
                filas.add(f);
                System.out.println(f.toString());
            }            
        }     
        System.out.println(" PUNTOS TOTALES: " + puntosTotal);
    }
}
