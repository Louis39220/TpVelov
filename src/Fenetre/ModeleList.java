/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetre;

import entities.Arrondissement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Ludovic
 */
public class ModeleList extends AbstractListModel {
    private List<Arrondissement> liste = new ArrayList<>();
    
    public ModeleList(List<Arrondissement> liste) {
        this.liste = liste;
    }
    
    @Override
    public int getSize() {
        return liste.size();
    }

    @Override
    public Object getElementAt(int i) {
        return liste.get(i);
    }
    
}
