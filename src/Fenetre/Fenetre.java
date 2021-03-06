/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetre;

import DAO.AbstractDaoFactory;
import DAO.Dao;
import entities.Arrondissement;
import entities.Station;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Ludovic
 */
public class Fenetre extends javax.swing.JFrame {
    
    Map<String, Station> listeStation;
    List<Arrondissement> listeArrond;
    
    public Fenetre() {
        this.listeStation = new HashMap<>();
        this.listeArrond = new ArrayList<>();
        initListe();
        initComponents();
        lbLogo.setIcon(new ImageIcon("image.png"));
        imgAPropos.setIcon(new ImageIcon("imgAPropos.png"));
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width-this.getWidth()) / 2, (d.height-this.getHeight()) / 2);
        
        fenAPropos.setSize(500, 190);
        fenAPropos.setLocation((d.width-fenAPropos.getWidth()) / 2, (d.height-fenAPropos.getHeight()) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fenAPropos = new javax.swing.JDialog();
        imgAPropos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btFermerAPropos = new javax.swing.JButton();
        lbLogo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabStation = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lbNumStation = new javax.swing.JLabel();
        lbNomStation = new javax.swing.JLabel();
        txtNumStation = new javax.swing.JTextField();
        txtNomStation = new javax.swing.JTextField();
        lbNumArrondissement = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listNumArrondissement = new javax.swing.JList();
        lbLocalisation = new javax.swing.JLabel();
        txtLocalisation = new javax.swing.JTextField();
        btCreer = new javax.swing.JButton();
        btSupp = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuConnexion = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuQuitter = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuAPropos = new javax.swing.JMenuItem();

        fenAPropos.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        fenAPropos.setTitle("A propos : Application Vélo'v 1.0");
        fenAPropos.setAlwaysOnTop(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Application Vélo'v");

        jLabel2.setText("Une application java Swing pour le Grand Lyon");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Product Version :");

        jLabel4.setText("1.0");

        btFermerAPropos.setText("Fermer");
        btFermerAPropos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFermerAProposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fenAProposLayout = new javax.swing.GroupLayout(fenAPropos.getContentPane());
        fenAPropos.getContentPane().setLayout(fenAProposLayout);
        fenAProposLayout.setHorizontalGroup(
            fenAProposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fenAProposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgAPropos, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(fenAProposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fenAProposLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(fenAProposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addGroup(fenAProposLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(fenAProposLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btFermerAPropos)
                        .addGap(77, 77, 77))))
        );
        fenAProposLayout.setVerticalGroup(
            fenAProposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fenAProposLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(fenAProposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgAPropos, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fenAProposLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fenAProposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addComponent(btFermerAPropos)))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gestion des stations");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tabStation.setModel(new ModeleTable(listeStation));
        jScrollPane1.setViewportView(tabStation);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbNumStation.setText("Numéro station : ");

        lbNomStation.setText("Nom station : ");

        lbNumArrondissement.setText("Numéro arrondissement");

        listNumArrondissement.setModel(new ModeleList(listeArrond));
        jScrollPane2.setViewportView(listNumArrondissement);

        lbLocalisation.setText("Localistion");

        btCreer.setText("Créer");

        btSupp.setText("Supprimer");
        btSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuppActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNumStation)
                    .addComponent(lbNomStation)
                    .addComponent(lbNumArrondissement)
                    .addComponent(lbLocalisation))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btCreer)
                        .addGap(159, 159, 159)
                        .addComponent(btSupp)
                        .addGap(159, 159, 159))
                    .addComponent(txtNumStation)
                    .addComponent(txtNomStation)
                    .addComponent(jScrollPane2)
                    .addComponent(txtLocalisation))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNumStation)
                    .addComponent(txtNumStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNomStation)
                    .addComponent(txtNomStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNumArrondissement)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLocalisation)
                    .addComponent(txtLocalisation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCreer)
                    .addComponent(btSupp))
                .addGap(24, 24, 24))
        );

        jMenu1.setText("Fichier");

        menuConnexion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuConnexion.setText("Connexion à la base");
        menuConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConnexionActionPerformed(evt);
            }
        });
        jMenu1.add(menuConnexion);
        jMenu1.add(jSeparator1);

        menuQuitter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        menuQuitter.setText("Quitter");
        menuQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuitterActionPerformed(evt);
            }
        });
        jMenu1.add(menuQuitter);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("?");

        menuAPropos.setText("A propos");
        menuAPropos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAProposActionPerformed(evt);
            }
        });
        jMenu2.add(menuAPropos);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(lbLogo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConnexionActionPerformed
        try {
            remplirTable();
        } catch (IOException ex) {
            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuConnexionActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        quitter();
    }//GEN-LAST:event_formWindowClosing

    private void menuQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQuitterActionPerformed
        quitter();
    }//GEN-LAST:event_menuQuitterActionPerformed

    private void menuAProposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAProposActionPerformed
        fenAPropos.setVisible(true);
    }//GEN-LAST:event_menuAProposActionPerformed

    private void btFermerAProposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFermerAProposActionPerformed
        fenAPropos.setVisible(false);
    }//GEN-LAST:event_btFermerAProposActionPerformed

    private void btSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuppActionPerformed
        suppLine();
    }//GEN-LAST:event_btSuppActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCreer;
    private javax.swing.JButton btFermerAPropos;
    private javax.swing.JButton btSupp;
    private javax.swing.JDialog fenAPropos;
    private javax.swing.JLabel imgAPropos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lbLocalisation;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbNomStation;
    private javax.swing.JLabel lbNumArrondissement;
    private javax.swing.JLabel lbNumStation;
    private javax.swing.JList listNumArrondissement;
    private javax.swing.JMenuItem menuAPropos;
    private javax.swing.JMenuItem menuConnexion;
    private javax.swing.JMenuItem menuQuitter;
    private javax.swing.JTable tabStation;
    private javax.swing.JTextField txtLocalisation;
    private javax.swing.JTextField txtNomStation;
    private javax.swing.JTextField txtNumStation;
    // End of variables declaration//GEN-END:variables
    
    private void quitter() {
        int rep = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment quitter ?", 
                "Attention", JOptionPane.YES_NO_OPTION);
        if (rep == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
    private void remplirTable() throws IOException, SQLException, Exception {
        AbstractDaoFactory abs = AbstractDaoFactory.getDaoFactory(AbstractDaoFactory.DAO_ORACLE);
        Dao<Station> dao = (Dao<Station>) abs.getStationDao();
        HashMap<String, Station> liste = dao.selectAll();
        
        Collection<Station> collec = liste.values();
        for (Station s : collec) ((ModeleTable)tabStation.getModel()).ajoutStation(s);
    }
    
    private void suppLine() {
        try {
            Station s = ((ModeleTable)tabStation.getModel()).suppressionStation(tabStation.getSelectedRow());
            AbstractDaoFactory abs = AbstractDaoFactory.getDaoFactory(AbstractDaoFactory.DAO_ORACLE);
            Dao<Station> dao = (Dao<Station>) abs.getStationDao();
            dao.delete(s);
        } catch (IOException ex) {
            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initListe() {
        try {
            AbstractDaoFactory abs = AbstractDaoFactory.getDaoFactory(AbstractDaoFactory.DAO_ORACLE);
            Dao<Arrondissement> dao = (Dao<Arrondissement>) abs.getArrondissementDao();
            HashMap<String, Arrondissement> liste = dao.selectAll();
            
            Collection<Arrondissement> collec = liste.values();
            for (Arrondissement a : collec) listeArrond.add(a);
            Collections.sort(listeArrond);
        } catch (IOException ex) {
            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
