package Presentacion;

import Clases.Nave;
import Clases.Tripulada;
import Clases.VehiculoLanzadera;
import Fabrica.Fabrica;
import java.util.ArrayList;
import java.util.function.Predicate;
import javax.swing.JOptionPane;

public class LanzarLanzadera extends javax.swing.JFrame {

    public LanzarLanzadera(Detalles detalles) {
        initComponents();
        this.detalles = detalles;
    }
    
    public void abrir(VehiculoLanzadera lanzadera) {
        this.lanzadera = lanzadera;
        this.setLocationRelativeTo(null);

        nolanzaderas = Fabrica.getINaves().obtener_nolanzaderas_compatibles_con_lanzadera(lanzadera);
        lista_nolanzadera.setListData(nolanzaderas.toArray(new String[nolanzaderas.size()]));
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista_nolanzadera = new javax.swing.JList<>();
        lanzar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setTitle("Naves compatibles para lanzar");
        setResizable(false);

        lista_nolanzadera.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lista_nolanzadera.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lista_nolanzadera);

        lanzar.setText("Lanzar");
        lanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lanzarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                        .addComponent(lanzar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lanzar)
                    .addComponent(cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void lanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lanzarActionPerformed
        if (lista_nolanzadera.getSelectedIndex() == -1) {
           JOptionPane.showMessageDialog(this, "Debe seleccionar otra nave para lanzar con el vehiculo lanzadora");
        }
        else {
            Nave nave = Fabrica.getINaves().obtener_nave(lista_nolanzadera.getSelectedValue());
            lanzadera.Lanzar(nave);
            nave.Lanzar();
            JOptionPane.showMessageDialog(this, "Se lanzo el vehiculo lanzadera y la nave adjunta");
            detalles.Lanzar();
            setVisible(false);
        }
    }//GEN-LAST:event_lanzarActionPerformed

    ArrayList<String> nolanzaderas;
    VehiculoLanzadera lanzadera;
    Detalles detalles;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lanzar;
    private javax.swing.JList<String> lista_nolanzadera;
    // End of variables declaration//GEN-END:variables

}
