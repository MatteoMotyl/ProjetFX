/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetfx;

/**
 *
 * @author Mattéo
 */
public class Enregistrement {
    
    private int seconde;
    private int cad;
    private int hr;
    private double km;
    private double kph;
    private int nm;
    private int watts;
    private double alt;
    private double lon;
    private double lat;
    private int headwind;
    private double slope;
    private int temp;
    private int interval;
    private int lrbalance;
    private int lte;
    private int rte;
    private int lps;
    private int rps;
    private int smo2;
    private int thb;
    private int o2hb;
    private int hhb;
    private boolean valide=true;
	// ..

    public Enregistrement(String line) {
        
	String[] data = line.split(",");
	seconde = (int) getdouble(data[0]);
	cad = (int) getdouble(data[1]);
	hr = (int) getdouble(data[2]);
	km = getdouble(data[3]);
	kph= getdouble(data[4]);
	nm= (int) getdouble(data[5]);
	watts= (int) getdouble(data[6]);
	alt= getdouble(data[7]);
	lon= getdouble(data[8]);
	lat= getdouble(data[9]);
	headwind= (int) getdouble(data[10]);
	slope = (int) getdouble(data[11]);
	temp= (int) getdouble(data[12]);
	interval= (int) getdouble(data[13]);
	lrbalance= (int) getdouble(data[14]);
	lte= (int) getdouble(data[15]);
	rte= (int) getdouble(data[16]);
	lps= (int) getdouble(data[17]);
	rps= (int) getdouble(data[18]);
	smo2= (int) getdouble(data[18]);
	thb= (int) getdouble(data[20]);
	o2hb= (int) getdouble(data[21]);
	hhb= (int) getdouble(data[22]);
        
    }
    
    private int getInt(String s) {
        if (s.compareTo(" ") == 1) {
                valide = false;
                return 0;
        }
        return Integer.parseInt(s) ;
    }

    private double getdouble(String s) {
            Double result = 0.0;
            try {
                    result = Double.parseDouble(s);
            } catch (Exception e) {
                    valide = false;
                    result = 0.0 ;
            }
            return result;
    }

    @Override
    public String toString() {
            return "\n seconde=" + seconde + ", cad=" + cad + ", hr=" + hr + ", km=" + km + ", kph=" + kph + ", nm=" + nm + ", watts=" + watts + ", alt=" + alt + ", lon=" + lon + ", lat=" + lat + ", headwind=" + headwind + ", slope=" + slope + ", temp=" + temp + ", interval=" + interval + ", lrbalance=" + lrbalance + ", lte=" + lte + ", rte=" + rte + ", lps=" + lps + ", rps=" + rps + ", smo2=" + smo2 + ", thb=" + thb + ", o2hb=" + o2hb + ", hhb=" + hhb + "" ;
    }

    public int getSeconde() {
            return seconde ;
    }

    public int getCad() {
            return cad;
    }

    public int getHr() {
            return hr;
    }

    public Double getKm() {
            return km;
    }

    public Double getKph() {
            return kph;
    }

    public int getWatts() {
            return watts;
    }

    public Double getAlt() {
            return alt;
    }

    public Double getLon() {
            return lon;
    }

    public Double getLat() {
            return lat;
    }

    public boolean IsValide() {
            return valide;
    }
}

