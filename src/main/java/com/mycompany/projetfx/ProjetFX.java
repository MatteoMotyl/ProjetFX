/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.projetfx;


import java.util.Enumeration;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.Axis;
import javafx.scene.chart. NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Mattéo
 */
public class ProjetFX extends Application {

    static Sortie sortie;
    static String file = "D:\\cours 1ère année Alès\\Informatique\\APO projet\\Fichiers GPS en CSV\\01_07_22_TL.csv";
    
    
    @Override
    public void start(Stage primaryStage) {
            
        Button boutonLireFichier = new Button("Lire fichier");
        Button btnPrintSortie = new Button("Print sortie");
        Button btnHR = new Button("Profil HR");
        Button btnP = new Button("Puissance moyenne");

        VBox vbx = new VBox(5);
        HBox hboxButtons = new HBox (5);
        
        hboxButtons.getChildren().addAll(boutonLireFichier , btnPrintSortie, btnHR, btnP);
        vbx.getChildren().add(hboxButtons);
        

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        
        xAxis.setLabel("seconde");
        
        final AreaChart<Number,Number> chart = new AreaChart<>( xAxis,yAxis);
        
        chart.setCreateSymbols(false);
        
        Scene scene = new Scene (vbx, 800, 600);
        
        primaryStage.setTitle("Analyse GPX");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //-------------------------------------------------------------------
        
        boutonLireFichier.setOnAction((ActionEvent event) -> {
            Enregistrement test = new Enregistrement("1,1");
            sortie = new Sortie(file);
        });
        
        btnHR.setOnAction((event) ->  {  
            XYChart.Series seriesHR = new XYChart.Series();
            
            yAxis.setLabel("bpm");
            seriesHR.setName("Profil HR");
            
            sortie.fillHRseries(seriesHR);
            chart.getData().add(seriesHR);
            vbx.getChildren().add(chart);
        });
                
        btnPrintSortie.setOnAction((event) -> {
            if (sortie != null) {
                System.out.println(sortie);
            }});
                
                
                
        btnP.setOnAction((event) -> {
            XYChart.Series seriesPuiss = new XYChart.Series();
            
            yAxis.setLabel("puissance moyenne");
            seriesPuiss.setName("profil puissance moyenne");
            
            sortie.fillPuisseries(seriesPuiss);
            chart.getData().add(seriesPuiss);
            vbx.getChildren().add(chart);
        });
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}