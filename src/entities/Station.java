/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author Louis
 */
public class Station {
    private String numeroIdentification;
    private String nomArrondissement;
    private String localisationStation;
    private Arrondissement arrondissement;

    public Station(String numeroIdentification, String nomArrondissement, String localisationStation) {
        this.numeroIdentification = numeroIdentification;
        this.nomArrondissement = nomArrondissement;
        this.localisationStation = localisationStation;
    }

    public String getNumeroIdentification() {
        return numeroIdentification;
    }

    public void setNumeroIdentification(String numeroIdentification) {
        this.numeroIdentification = numeroIdentification;
    }

    public String getNomArrondissement() {
        return nomArrondissement;
    }

    public void setNomArrondissement(String nomArrondissement) {
        this.nomArrondissement = nomArrondissement;
    }

    public String getLocalisationStation() {
        return localisationStation;
    }

    public void setLocalisationStation(String localisationStation) {
        this.localisationStation = localisationStation;
    }

    public Arrondissement getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(Arrondissement arrondissement) {
        this.arrondissement = arrondissement;
    }

    @Override
    public String toString() {
        return "Station{" + "numeroIdentification=" + numeroIdentification + ", nomArrondissement=" + nomArrondissement + ", localisationStation=" + localisationStation + '}';
    }
    
    
    
    
    
}
