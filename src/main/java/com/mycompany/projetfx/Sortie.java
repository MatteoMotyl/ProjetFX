/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetfx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Mattéo
 */
public class Sortie {
    
    private List<Enregistrement> sortie;
    
    public Sortie(List<Enregistrement> sortie) {
        sortie = new ArrayList();
    }
    
    public Sortie(String fichier) {
        //Récuperer le fichier sous forme de Stream
        //Iterer sur le stream pour remplir la liste d'enregistement
    }
    
    public List<Enregistrement> getSortie() {
        return sortie;
    }
    
    public void fillHRseries(XYChart.Series serie){
        
    }
}

