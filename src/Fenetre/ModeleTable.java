
package Fenetre;

import DAO.AbstractDaoFactory;
import DAO.Dao;
import entities.Station;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

public class ModeleTable extends AbstractTableModel {
    private Map<String, Station> listeStations = new HashMap<>();
    private String[] listeColonnes = {"Numéro station", "Nom station", "Numéro arrondissement", "Localisation"};
    
    public ModeleTable(Map<String, Station> listeStations) {
        this.listeStations = listeStations;
    }
    
    @Override
    public int getColumnCount() {
        return listeColonnes.length;
    }
    
    @Override
    public int getRowCount() {
        return listeStations.size();
    }
    
    @Override
    public Object getValueAt(int row, int col) {
        Collection<Station> c = listeStations.values();
        int i = 0;
        String cle = null;
        for (Station s : c) {
            if (i == row) cle = s.getNumeroIdentification();
            i++;
        }
        if (col == 0) return listeStations.get(cle).getNumeroIdentification();
        else if (col == 1) return listeStations.get(cle).getNomStation();
        else if (col == 2) return listeStations.get(cle).getArrondissement().getIdArrondissement();
        else if (col == 3) return listeStations.get(cle).getLocalisationStation();
        else return null;
    }
    
    @Override
    public String getColumnName(int col) {
        return listeColonnes[col];
    }
    
    public void ajoutStation(Station s) {
        listeStations.put(s.getNumeroIdentification(), s);
        fireTableDataChanged();
    }
    
    public Station suppressionStation(int row) throws IOException, SQLException, Exception {
        Collection<Station> c = listeStations.values();
        int i = 0;
        Station station = null;
        for (Station s : c) {
            if (i == row) station = s;
            i++;
        }
        if (station != null) listeStations.remove(station.getNumeroIdentification());
        
        fireTableDataChanged();
        return station;
    }
}
