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
public class Arrondissement implements Comparable {
    private int idArrondissement;
    private String nomArrondissement;

    public Arrondissement(int idArrondissement, String nomArrondissement) {
        this.idArrondissement = idArrondissement;
        this.nomArrondissement = nomArrondissement;
    }

    public int getIdArrondissement() {
        return idArrondissement;
    }

    public void setIdArrondissement(int idArrondissement) {
        this.idArrondissement = idArrondissement;
    }

    public String getNomArrondissement() {
        return nomArrondissement;
    }

    public void setNomArrondissement(String nomArrondissement) {
        this.nomArrondissement = nomArrondissement;
    }

    @Override
    public String toString() {
        return nomArrondissement;
    }

    @Override
    public int compareTo(Object t) {
        Arrondissement a = (Arrondissement) t;
        if (idArrondissement < a.getIdArrondissement()) return -1;
        else if (idArrondissement == a.getIdArrondissement()) return 0;
        else return 1;
    }
    
}
