/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probabilidades;

/**
 *
 * @author Martin
 */
public class Intervalos {
    
    private int[] primeraBola;
    private int[] segundaBola;
    
    
    
    
    public Intervalos()
    {
        primeraBola = new int[]{12,15,18,55};
        segundaBola = new int[]{2,10,45,43,4,20,76,6,94};  
    }

    public int[] getPrimeraBola() {
        return primeraBola;
    }

    public void setPrimeraBola(int[] primeraBola) {
        this.primeraBola = primeraBola;
    }

    public int[] getSegundaBola() {
        return segundaBola;
    }

    public void setSegundaBola(int[] segundaBola) {
        this.segundaBola = segundaBola;
    }
    
}
