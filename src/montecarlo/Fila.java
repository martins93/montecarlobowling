/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlo;

import probabilidades.Intervalos;

/**
 *
 * @author Martin
 */
public class Fila {

    private int ronda, palos1, palos2, pts;
    private float rnd1,rnd2;
    Intervalos intervals;


    public Fila(int ronda) {
        
        intervals = new Intervalos();
        this.ronda=ronda;
        this.rnd1=Math.round(Math.random()*100);
        this.palos1=this.validarIntervalo(rnd1);
        if(this.palos1!=10)
        {
             this.rnd2=Math.round(Math.random()*100);
             this.palos2=this.validarIntervalo2(rnd2, palos1);
             this.pts=this.calcularPts(palos1, palos2);
        }
        else
        {
            this.pts=this.calcularPts(palos1, 0);
        }
        
    }
    
    public Fila()
    {
        intervals = new Intervalos();
    }
    
    

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public float getRnd1() {
        return rnd1;
    }

    public void setRnd1(int rnd1) {
        this.rnd1 = rnd1;
    }

    public int getPalos1() {
        return palos1;
    }

    public void setPalos1(int palos1) {
        this.palos1 = palos1;
    }

    public float getRnd2() {
        return rnd2;
    }

    public void setRnd2(int rnd2) {
        this.rnd2 = rnd2;
    }

    public int getPalos2() {
        return palos2;
    }

    public void setPalos2(int palos2) {
        this.palos2 = palos2;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public Fila calcularProxFila(Fila fAnterior) {
        Fila fProxima = new Fila();

        float rnd = (float) Math.random() * 100;
        float rnd2 = (float) Math.random() * 100;

        fProxima.setRonda(fAnterior.getRonda()+1);
        fProxima.setRnd1(Math.round(rnd));
        fProxima.setPalos1(this.validarIntervalo(rnd));
        if(fProxima.getPalos1()!=10)
        {
            fProxima.setRnd2(Math.round(rnd2));
            fProxima.setPalos2(this.validarIntervalo2(rnd2,fProxima.getPalos1()));
            fProxima.setPts(this.calcularPts(fProxima.getPalos1(), fProxima.getPalos2()));   
        }
        else
        {
            fProxima.setPts(this.calcularPts(fProxima.getPalos1(), 0));
        }
       
        return fProxima;
    }

    public int validarIntervalo(float rnd1) {

        int palos = 10;

        int[] primeraBola = intervals.getPrimeraBola();

            if (Math.round(rnd1) < primeraBola[0]) {
                palos = 7;
            } else if (Math.round(rnd1) < (primeraBola[0] + primeraBola[1])) {
                palos = 8;
            } else if (Math.round(rnd1) < (primeraBola[0] + primeraBola[1] + primeraBola[2])) {
                palos = 9;
            }        
        return palos;
    }
    
    public int validarIntervalo2(float rnd2, int palos1)
    {
        int palos2=0;
        int[] segundaBola = intervals.getSegundaBola();
        
        switch(palos1)
        {
            case 7:
            {
                if (Math.round(rnd2) < segundaBola[0]) {
                palos2 = 0;
                break;
            } else if (Math.round(rnd2) < (segundaBola[0] + segundaBola[1])) {
                palos2 = 1;
                break;
            } else if (Math.round(rnd2) < (segundaBola[0] + segundaBola[1] + segundaBola[2])) {
                palos2 = 2;
                break;
            } else if (Math.round(rnd2) < (segundaBola[0] + segundaBola[1] + segundaBola[2] + segundaBola[3]))
                palos2 = 3;
                break;
            }
            case 8:
            {
                 if(Math.round(rnd2)< segundaBola[4]) { 
                 palos2 = 0;
                 break;
            } else if (Math.round(rnd2) < (segundaBola[4] + segundaBola[5])) {
                palos2 = 1;
                break;
            } else if (Math.round(rnd2) < (segundaBola[4] + segundaBola[5] + segundaBola[6])) {
                palos2 = 2;
                break;
            } 
            }
            case 9:
            {
                if(Math.round(rnd2)< segundaBola[7]) { 
                 palos2 = 0;
                 break;
            } else if (Math.round(rnd2) < (segundaBola[7] + segundaBola[8])) {
                palos2 = 1;
                break;
            } 
            }
            
        }      
        return palos2;
    }
    
    public int calcularPts(int palos1, int palos2)
    {
       int puntos=0;
        
        if(palos1==10)
        {
            puntos=20;
        }
        else if (palos1+palos2==10)
        {
            puntos=15;
        }
        else
        {
            puntos=palos1+palos2;
        }
        
        return puntos;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("RONDA: ");
        sb.append(this.getRonda()-1);
        sb.append(" RND1: ");
        sb.append(this.getRnd1());
        sb.append(" PALOS EN EL TIRO 1: ");
        sb.append(this.getPalos1());
        sb.append(" RND2: ");
        sb.append(this.getRnd2());
        sb.append(" PALOS EN EL TIRO2: ");
        sb.append(this.getPalos2());
        sb.append(" PUNTOS: ");
        sb.append(this.getPts());
        
        return sb.toString();
    }

}
