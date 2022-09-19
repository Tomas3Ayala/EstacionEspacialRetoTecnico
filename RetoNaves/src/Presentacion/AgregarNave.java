package Presentacion;

import Clases.NoTripulada;
import Clases.Tripulada;
import Clases.VehiculoLanzadera;
import Datatypes.InfoBasicaNave;
import Fabrica.Fabrica;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AgregarNave extends javax.swing.JFrame {

    public AgregarNave(Menu menu) {
        this.menu = menu;
        initComponents();
        dato1.setVisible(true);
        dato2.setVisible(true);
        dato1.setText("Número de tripulantes:");
        tipo_seleccionado = InfoBasicaNave.TIPO_TRIPULADA;
        combustibles = new ArrayList<>();
        origenes = new ArrayList<>();
        update_combustibles();
        update_origenes();
        imagen.setText("");
        imagen.setIcon(new ImageIcon(new ImageIcon("imgs/spaceship.png").getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), java.awt.Image.SCALE_SMOOTH)));
        
        this.setSize(780, this.getHeight());
    }
    
    private void update_combustibles() {
        lista_combustibles.setListData(combustibles.toArray(new String[combustibles.size()]));
    }

    private void update_origenes() {
        lista_origenes.setListData(origenes.toArray(new String[origenes.size()]));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radio_tipos = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        peso = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        empuje = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_combustibles = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        agregar_combustible = new javax.swing.JButton();
        agregar_origen = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista_origenes = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        buscar_imagen = new javax.swing.JButton();
        radio_no_tripulada = new javax.swing.JRadioButton();
        radio_tripulada = new javax.swing.JRadioButton();
        radio_lanzadero = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        dato2 = new javax.swing.JSpinner();
        agregar_nave = new javax.swing.JButton();
        dato1 = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar nave");

        jLabel1.setText("Nombre:");

        jLabel2.setText("Peso:");

        peso.setModel(new javax.swing.SpinnerNumberModel(1.0f, 1.0f, null, 1.0f));

        jLabel3.setText("Empuje");

        empuje.setModel(new javax.swing.SpinnerNumberModel(1.0f, 1.0f, null, 1.0f));

        lista_combustibles.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lista_combustibles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lista_combustiblesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(lista_combustibles);

        jLabel4.setText("Combustibles:");

        agregar_combustible.setText("Agregar elemento");
        agregar_combustible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_combustibleActionPerformed(evt);
            }
        });

        agregar_origen.setText("Agregar elemento");
        agregar_origen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_origenActionPerformed(evt);
            }
        });

        lista_origenes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lista_origenes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lista_origenesKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(lista_origenes);

        jLabel5.setText("Origenes:");

        buscar_imagen.setText("Buscar imagen");
        buscar_imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_imagenActionPerformed(evt);
            }
        });

        radio_tipos.add(radio_no_tripulada);
        radio_no_tripulada.setText("No tripulada");
        radio_no_tripulada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_no_tripuladaActionPerformed(evt);
            }
        });

        radio_tipos.add(radio_tripulada);
        radio_tripulada.setSelected(true);
        radio_tripulada.setText("Tripulada");
        radio_tripulada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_tripuladaActionPerformed(evt);
            }
        });

        radio_tipos.add(radio_lanzadero);
        radio_lanzadero.setText("Vehículo lanzadera");
        radio_lanzadero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_lanzaderoActionPerformed(evt);
            }
        });

        jLabel6.setText("Seleccione tipo:");

        dato2.setModel(new javax.swing.SpinnerNumberModel(1.0f, 1.0f, null, 1.0f));

        agregar_nave.setText("Agregar nave");
        agregar_nave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_naveActionPerformed(evt);
            }
        });

        dato1.setText("Número de tripulantes:");

        imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagen.setText("imagen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(agregar_combustible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombre)
                    .addComponent(peso)
                    .addComponent(empuje)
                    .addComponent(agregar_origen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar_imagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(dato1)
                            .addGap(18, 18, 18)
                            .addComponent(dato2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel6)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(radio_no_tripulada)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(radio_tripulada)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(radio_lanzadero)))
                    .addComponent(agregar_nave, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(empuje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(152, 152, 152))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(buscar_imagen)
                        .addGap(2, 2, 2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(agregar_combustible)
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radio_no_tripulada)
                            .addComponent(radio_tripulada)
                            .addComponent(radio_lanzadero))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dato2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dato1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agregar_origen)
                            .addComponent(agregar_nave))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radio_no_tripuladaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_no_tripuladaActionPerformed
        dato1.setVisible(false);
        dato2.setVisible(false);
        tipo_seleccionado = InfoBasicaNave.TIPO_NOTRIPULADA;
    }//GEN-LAST:event_radio_no_tripuladaActionPerformed

    private void radio_tripuladaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_tripuladaActionPerformed
        dato1.setVisible(true);
        dato2.setVisible(true);
        dato1.setText("Número de tripulantes:");
        tipo_seleccionado = InfoBasicaNave.TIPO_TRIPULADA;
    }//GEN-LAST:event_radio_tripuladaActionPerformed

    private void radio_lanzaderoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_lanzaderoActionPerformed
        dato1.setVisible(true);
        dato2.setVisible(true);
        dato1.setText("Capacidad (en kilogramos):");
        tipo_seleccionado = InfoBasicaNave.TIPO_LANZADERA;
    }//GEN-LAST:event_radio_lanzaderoActionPerformed

    private void agregar_naveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_naveActionPerformed
        if (nombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío");
            return;
        }
        if (Fabrica.getINaves().nombre_repetido(nombre.getText())) {
            JOptionPane.showMessageDialog(this, "El nombre ya esta siendo usado por otra nave");
            return;
        }
        
//        System.out.println(tipo_seleccionado);
        switch (tipo_seleccionado) {
            case InfoBasicaNave.TIPO_TRIPULADA:
                Tripulada tripulada = new Tripulada(
                        nombre.getText(),
                        false,
                        origenes,
                        new Date(),
                        null,
                        combustibles,
                        (float) peso.getValue(),
                        (float) empuje.getValue(),
                        Math.round((float) dato2.getValue()),
                        new ArrayList<>()
                );
                Fabrica.getINaves().guardar_tripulada(tripulada, image_data);
                break;
            case InfoBasicaNave.TIPO_NOTRIPULADA:
                NoTripulada notripulada = new NoTripulada(
                        nombre.getText(),
                        false,
                        origenes,
                        new Date(),
                        null,
                        combustibles,
                        (float) peso.getValue(),
                        (float) empuje.getValue()
                );
                Fabrica.getINaves().guardar_notripulada(notripulada, image_data);
                break;
            default:
                VehiculoLanzadera lanzadera = new VehiculoLanzadera(
                        nombre.getText(),
                        false,
                        origenes,
                        new Date(),
                        null,
                        combustibles,
                        (float) peso.getValue(),
                        (float) empuje.getValue(),
                        (float) dato2.getValue(),
                        null
                );
                Fabrica.getINaves().guardar_lanzadera(lanzadera, image_data);
                break;
        }
        menu.update_tabla_de_naves();
        menu.update_organizaciones();
        JOptionPane.showMessageDialog(this, "Se ha agregado con exito la nave");
    }//GEN-LAST:event_agregar_naveActionPerformed

    private void agregar_combustibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_combustibleActionPerformed
        String result = (String) JOptionPane.showInputDialog(
            this,
            "Introduzca el nombre del combustible",
            "Nombre del combustible",
            JOptionPane.PLAIN_MESSAGE,
            null,
            null,
            ""
        );
        if (result != null && result.length() > 0) {
            combustibles.add(result);
            update_combustibles();
        } else
            JOptionPane.showMessageDialog(this, "No se introdujo ningún nombre");
    }//GEN-LAST:event_agregar_combustibleActionPerformed

    private void agregar_origenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_origenActionPerformed
        String result = (String) JOptionPane.showInputDialog(
            this,
            "Introduzca el nombre del origen",
            "Nombre del origen",
            JOptionPane.PLAIN_MESSAGE,
            null,
            null,
            ""
        );
        if (result != null && result.length() > 0) {
            if (result == "[Cualquiera]")
                JOptionPane.showMessageDialog(this, "[Cualquiera] es una palabra reservada en el sistema");
            else {
                origenes.add(result);
                update_origenes();
            }
        } else
            JOptionPane.showMessageDialog(this, "No se introdujo ningún nombre");
    }//GEN-LAST:event_agregar_origenActionPerformed

    private void buscar_imagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_imagenActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                image_data = Files.readAllBytes(file.toPath());
            } catch (IOException ex) {
                Logger.getLogger(AgregarNave.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (image_data.length > 500000) { // fija un limite de 0.5 MB para las imagenes
                JOptionPane.showMessageDialog(this, "La imagen seleccionada es muy grande, maximo 0.5 MB");
                return;
            }
            System.out.println(image_data.length);
            imagen.setIcon(new ImageIcon(new ImageIcon(image_data).getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), java.awt.Image.SCALE_SMOOTH)));
        }
        else
            JOptionPane.showMessageDialog(this, "No se selecciono ninguna imagen");
    }//GEN-LAST:event_buscar_imagenActionPerformed

    private void lista_combustiblesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lista_combustiblesKeyReleased
        if (evt.getKeyCode() == 127 && lista_combustibles.getSelectedIndex() != -1) { // Delete key
            combustibles.remove(lista_combustibles.getSelectedIndex());
            update_combustibles();
        }
    }//GEN-LAST:event_lista_combustiblesKeyReleased

    private void lista_origenesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lista_origenesKeyReleased
        if (evt.getKeyCode() == 127 && lista_origenes.getSelectedIndex() != -1) { // Delete key
            origenes.remove(lista_origenes.getSelectedIndex());
            update_origenes();
        }
    }//GEN-LAST:event_lista_origenesKeyReleased
    
    private String tipo_seleccionado;
    private byte[] image_data;
    private ArrayList<String> combustibles;
    private ArrayList<String> origenes;
    private Menu menu;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar_combustible;
    private javax.swing.JButton agregar_nave;
    private javax.swing.JButton agregar_origen;
    private javax.swing.JButton buscar_imagen;
    private javax.swing.JLabel dato1;
    private javax.swing.JSpinner dato2;
    private javax.swing.JSpinner empuje;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lista_combustibles;
    private javax.swing.JList<String> lista_origenes;
    private javax.swing.JTextField nombre;
    private javax.swing.JSpinner peso;
    private javax.swing.JRadioButton radio_lanzadero;
    private javax.swing.JRadioButton radio_no_tripulada;
    private javax.swing.ButtonGroup radio_tipos;
    private javax.swing.JRadioButton radio_tripulada;
    // End of variables declaration//GEN-END:variables
}
