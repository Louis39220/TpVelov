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
    private String nomStation;
    private String localisationStation;
    private Arrondissement arrondissement;

    public Station(String numeroIdentification, String nomArrondissement, String localisationStation, int numarrond, String nomarrond) {
        this.numeroIdentification = numeroIdentification;
        this.nomStation = nomArrondissement;
        this.localisationStation = localisationStation;
        this.arrondissement = new Arrondissement(numarrond, nomarrond);
    }

    public Station(String numeroIdentification, String nomStation, String localisationStation) {
        this.numeroIdentification = numeroIdentification;
        this.nomStation = nomStation;
        this.localisationStation = localisationStation;
    }    

    public String getNumeroIdentification() {
        return numeroIdentification;
    }

    public void setNumeroIdentification(String numeroIdentification) {
        this.numeroIdentification = numeroIdentification;
    }

    public String getNomStation() {
        return nomStation;
    }

    public void setNomArrondissement(String nomArrondissement) {
        this.nomStation = nomArrondissement;
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
        return "Station{" + "numeroIdentification=" + numeroIdentification + ", nomArrondissement=" + nomStation + ", localisationStation=" + localisationStation + '}';
    }
    
    
    
    
    
}
