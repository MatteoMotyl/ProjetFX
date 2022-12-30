/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetfx;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Mattéo
 */
public class Sortie {

    private List<Enregistrement> listeEnregistrements = new ArrayList<>();

    public Sortie(List<Enregistrement> sortie) {
        sortie = new ArrayList();
    }

    public Sortie(String fichier) {
        //Récuperer le fichier sous forme de Stream
        /*
        try {
           FileReader reader = new FileReader(fichier);
           reader.
        } catch(IOException e) {
            System.err.println("Le fichier n'a pas été trouvé");
        }
         */

        //Iterer sur le stream pour remplir la liste d'enregistement
        try ( Scanner scanner = new Scanner(new File(fichier));) {
            scanner.nextLine(); //On ne prend pas les entêtes = 1ere ligne
            while (scanner.hasNextLine()) {
                listeEnregistrements.add(new Enregistrement(scanner.nextLine()));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try ( Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter("\n");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    public List<Enregistrement> getSortie() {
        return listeEnregistrements;
    }

    public void fillHRseries(XYChart.Series serie) {
        /*On parcourt chaque élément de listeEnregistrements et on ajoute
        au graphique les secondes et hr pour chacune des lignes
        */
        for (Enregistrement enregistrement : listeEnregistrements) {
           serie.getData().add(new XYChart.Data(enregistrement.getSeconde() , enregistrement.getHr()));   
        }
    }

    /**
     * *
     *
     * @param serie
     */
    public void fillPuisseries(XYChart.Series serie) {
        //TODO

    }
}
