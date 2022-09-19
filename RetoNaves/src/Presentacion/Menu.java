package Presentacion;

import Controladores.ControllerNaves;
import Datatypes.InfoBasicaNave;
import Fabrica.Fabrica;
import Persistencia.ConexionDB;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        search_term = "";

        update_tabla_de_naves();        

        busqueda_avanzada_activada = false;
        filtro_tipo.setEnabled(false);
        filtro_organizacion.setEnabled(false);
        label_tipo.setEnabled(false);
        label_organizacion.setEnabled(false);

        filtro_tipo.removeAllItems();
        filtro_tipo.addItem("[Cualquiera]");
        filtro_tipo.addItem(InfoBasicaNave.convertir_tipo_a_tipo_legible(InfoBasicaNave.TIPO_LANZADERA));
        filtro_tipo.addItem(InfoBasicaNave.convertir_tipo_a_tipo_legible(InfoBasicaNave.TIPO_TRIPULADA));
        filtro_tipo.addItem(InfoBasicaNave.convertir_tipo_a_tipo_legible(InfoBasicaNave.TIPO_NOTRIPULADA));
        
        update_organizaciones();
    }
   
    public void update_organizaciones() {
        filtro_organizacion.removeAllItems();
        filtro_organizacion.addItem("[Cualquiera]");
        Fabrica.getINaves().obtener_origenes().forEach((String e) -> {
            filtro_organizacion.addItem(e);
        });
    }
    
    public void update_tabla_de_naves() {
        DefaultTableModel model = (DefaultTableModel) tabla_de_naves.getModel();
        model.setRowCount(0);
        if (search_term.length() != 0)
            naves = Fabrica.getINaves().obtener_informacion_basica_de_naves(field_buscar.getText());
        else
            naves = Fabrica.getINaves().obtener_informacion_basica_de_naves();
        ArrayList<InfoBasicaNave> filtro_naves = new ArrayList<>();
        naves.forEach((nave) -> {
            if (busqueda_avanzada_activada) {
                if (!filtro_tipo.getSelectedItem().equals("[Cualquiera]") && !filtro_tipo.getSelectedItem().equals(InfoBasicaNave.convertir_tipo_a_tipo_legible(nave.getTipo())))
                    return;
                if (!filtro_organizacion.getSelectedItem().equals("[Cualquiera]") &&
                        !nave.getOrganizaciones().contains((CharSequence) (" " + filtro_organizacion.getSelectedItem() + ",")) &&
                        !nave.getOrganizaciones().startsWith(filtro_organizacion.getSelectedItem() + ",") &&
                        !nave.getOrganizaciones().endsWith(" " + filtro_organizacion.getSelectedItem()) &&
                        !nave.getOrganizaciones().equals(filtro_organizacion.getSelectedItem()))
                    return;
            }
            filtro_naves.add(nave);
//            model.addRow(nave.getAsArray());
        });
        naves = filtro_naves;
        naves.forEach((nave) -> {
            model.addRow(nave.getAsArray());
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_de_naves = new javax.swing.JTable();
        field_buscar = new javax.swing.JTextField();
        button_ver_detalles = new javax.swing.JButton();
        button_ver_detalles1 = new javax.swing.JButton();
        agregar_nave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        busqueda_avanzada = new javax.swing.JCheckBox();
        filtro_tipo = new javax.swing.JComboBox<>();
        label_tipo = new javax.swing.JLabel();
        label_organizacion = new javax.swing.JLabel();
        filtro_organizacion = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventario de naves");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tabla_de_naves.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tipo", "Nombre", "Peso", "Organización/es"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_de_naves);

        field_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                field_buscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_buscarKeyTyped(evt);
            }
        });

        button_ver_detalles.setText("Ver detalles");
        button_ver_detalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ver_detallesActionPerformed(evt);
            }
        });

        button_ver_detalles1.setText("Salir");
        button_ver_detalles1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ver_detalles1ActionPerformed(evt);
            }
        });

        agregar_nave.setText("Agregar nave");
        agregar_nave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_naveActionPerformed(evt);
            }
        });

        jLabel1.setText("Busca:");

        busqueda_avanzada.setText("Busqueda avanzada");
        busqueda_avanzada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                busqueda_avanzadaItemStateChanged(evt);
            }
        });
        busqueda_avanzada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busqueda_avanzadaActionPerformed(evt);
            }
        });

        filtro_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        filtro_tipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filtro_tipoItemStateChanged(evt);
            }
        });
        filtro_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtro_tipoActionPerformed(evt);
            }
        });

        label_tipo.setText("Tipo:");

        label_organizacion.setText("Organizacion:");

        filtro_organizacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        filtro_organizacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filtro_organizacionItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(button_ver_detalles1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agregar_nave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_ver_detalles))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(field_buscar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(busqueda_avanzada)
                        .addGap(18, 18, 18)
                        .addComponent(label_tipo)
                        .addGap(18, 18, 18)
                        .addComponent(filtro_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_organizacion)
                        .addGap(18, 18, 18)
                        .addComponent(filtro_organizacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(busqueda_avanzada)
                    .addComponent(label_tipo)
                    .addComponent(filtro_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_organizacion)
                    .addComponent(filtro_organizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_ver_detalles)
                    .addComponent(button_ver_detalles1)
                    .addComponent(agregar_nave))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_ver_detalles1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ver_detalles1ActionPerformed
        dispose();
    }//GEN-LAST:event_button_ver_detalles1ActionPerformed

    private void button_ver_detallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ver_detallesActionPerformed
        if (tabla_de_naves.getSelectedRow() != -1) {
            new Detalles(naves.get(tabla_de_naves.getSelectedRow())).setVisible(true);
        }
        else
           JOptionPane.showMessageDialog(this, "No se ha seleccionado nave");
        //new Detalles().setVisible(true);
    }//GEN-LAST:event_button_ver_detallesActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ConexionDB.getInstance().close();
    }//GEN-LAST:event_formWindowClosing

    private void agregar_naveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_naveActionPerformed
        new AgregarNave(this).setVisible(true);
    }//GEN-LAST:event_agregar_naveActionPerformed

    private void filtro_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtro_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtro_tipoActionPerformed

    private void busqueda_avanzadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busqueda_avanzadaActionPerformed

    }//GEN-LAST:event_busqueda_avanzadaActionPerformed

    private void busqueda_avanzadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_busqueda_avanzadaItemStateChanged
        if (evt.getStateChange() == 1) {
            filtro_tipo.setEnabled(true);
            filtro_organizacion.setEnabled(true);
            label_tipo.setEnabled(true);
            label_organizacion.setEnabled(true);
            busqueda_avanzada_activada = true;
        }
        else {
            filtro_tipo.setEnabled(false);
            filtro_organizacion.setEnabled(false);
            label_tipo.setEnabled(false);
            label_organizacion.setEnabled(false);
            busqueda_avanzada_activada = false;
        }
        update_tabla_de_naves();
    }//GEN-LAST:event_busqueda_avanzadaItemStateChanged

    private void field_buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_buscarKeyTyped
        search_term = field_buscar.getText();
        update_tabla_de_naves();
    }//GEN-LAST:event_field_buscarKeyTyped

    private void filtro_tipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filtro_tipoItemStateChanged
        update_tabla_de_naves();
    }//GEN-LAST:event_filtro_tipoItemStateChanged

    private void filtro_organizacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filtro_organizacionItemStateChanged
        update_tabla_de_naves();
    }//GEN-LAST:event_filtro_organizacionItemStateChanged

    private void field_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_buscarKeyReleased
        search_term = field_buscar.getText();
        update_tabla_de_naves();
    }//GEN-LAST:event_field_buscarKeyReleased

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    
    private ArrayList<InfoBasicaNave> naves;
    private boolean busqueda_avanzada_activada;
    private String search_term;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar_nave;
    private javax.swing.JCheckBox busqueda_avanzada;
    private javax.swing.JButton button_ver_detalles;
    private javax.swing.JButton button_ver_detalles1;
    private javax.swing.JTextField field_buscar;
    private javax.swing.JComboBox<String> filtro_organizacion;
    private javax.swing.JComboBox<String> filtro_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_organizacion;
    private javax.swing.JLabel label_tipo;
    private javax.swing.JTable tabla_de_naves;
    // End of variables declaration//GEN-END:variables
}
