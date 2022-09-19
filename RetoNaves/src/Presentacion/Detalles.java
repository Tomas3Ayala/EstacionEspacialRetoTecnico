package Presentacion;

import Clases.Nave;
import Clases.NoTripulada;
import Clases.Tripulada;
import Clases.VehiculoLanzadera;
import Controladores.ControllerNaves;
import Datatypes.InfoBasicaNave;
import Fabrica.Fabrica;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Detalles extends javax.swing.JFrame {

    public Detalles(InfoBasicaNave info) {
        initComponents();
        ventana_lanzadera = new LanzarLanzadera(this);

        nave = null;

        tipo = info.getTipo();
        button_agregartripulante.setVisible(false);
        //imagen.setIcon(new ImageIcon("nom.png"));
        switch (tipo) {
            case InfoBasicaNave.TIPO_TRIPULADA:
                button_agregartripulante.setVisible(true);
                tripulada = Fabrica.getINaves().obtener_tripulada(info.getNombre());
                nave = tripulada;
                desc1.setText("Número de integrantes:");
                dato1.setText(Integer.toString(tripulada.getNumero_tripulantes()));
                tripulantes.setListData(tripulada.getTripulantes().toArray(new String[tripulada.getTripulantes().size()]));
                nombre_otra_nave.setVisible(false);
                break;
            case InfoBasicaNave.TIPO_LANZADERA:
                lanzadera = Fabrica.getINaves().obtener_lanzadera(info.getNombre());
                nave = lanzadera;
                dato1.setText(Float.toString(lanzadera.getCapacidad()) + "kg");
                if (nave.fue_lanzado()) {
                    desc2.setText("Nombre de la nave lanzada:");
                    nombre_otra_nave.setText(lanzadera.getNombre_nave_lanzada());
                }
                else {
                    desc2.setVisible(false);
                    nombre_otra_nave.setVisible(false);
                }
                tripulantes_scroll.setVisible(false);
                break;
            default:
                notripulada = Fabrica.getINaves().obtener_notripulada(info.getNombre());
                nave = notripulada;
                desc1.setVisible(false);
                desc2.setVisible(false);
                dato1.setVisible(false);
                nombre_otra_nave.setVisible(false);
                tripulantes_scroll.setVisible(false);
                break;
        }
        
        nombre.setText(nave.getNombre());
        peso.setText(Float.toString(nave.getPeso()) + "kg");
        empuje.setText(Float.toString(nave.getEmpuje()) + "kgf");

        combustibles.setText(Fabrica.getINaves().juntar_strings_separadas_con(nave.getCombustible(), "+"));
        origenes.setText(Fabrica.getINaves().juntar_strings_separadas_con(nave.getOrigen(), ", "));
        fechaInicioActividades.setText(nave.getFechaInicioActividades().toString());
        if (nave.getFechaFinActividades() != null)
            fechaFinActividades.setText(nave.getFechaFinActividades().toString());
        else
            fechaFinActividades.setText("N/A");
        if (nave.fue_lanzado())
            fueLanzado.setText("Sí");
        else
            fueLanzado.setText("No");
        ImageIcon img = Fabrica.getINaves().obtener_imagen_de_nave(nave.getNombre());
        if (img != null)
            imagen.setIcon(new ImageIcon(img.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), java.awt.Image.SCALE_SMOOTH)));
        else
            imagen.setIcon(new ImageIcon(new ImageIcon("imgs/spaceship.png").getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), java.awt.Image.SCALE_SMOOTH)));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        peso = new javax.swing.JLabel();
        empuje = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combustibles = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        origenes = new javax.swing.JLabel();
        fechaInicioActividades = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fechaFinActividades = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fueLanzado = new javax.swing.JLabel();
        button_cancelar = new javax.swing.JButton();
        button_lanzar = new javax.swing.JButton();
        desc1 = new javax.swing.JLabel();
        dato1 = new javax.swing.JLabel();
        desc2 = new javax.swing.JLabel();
        tripulantes_scroll = new javax.swing.JScrollPane();
        tripulantes = new javax.swing.JList<>();
        nombre_otra_nave = new javax.swing.JLabel();
        button_agregartripulante = new javax.swing.JButton();
        button_descontinuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalles de nave");
        setMinimumSize(new java.awt.Dimension(610, 348));
        getContentPane().setLayout(null);

        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(237, 11, 100, 14);

        nombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nombre.setText("nombre");
        getContentPane().add(nombre);
        nombre.setBounds(360, 10, 220, 14);

        jLabel2.setText("Peso:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(237, 31, 110, 14);

        peso.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        peso.setText("peso");
        getContentPane().add(peso);
        peso.setBounds(360, 30, 220, 14);

        empuje.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        empuje.setText("empuje");
        getContentPane().add(empuje);
        empuje.setBounds(370, 50, 210, 14);

        jLabel3.setText("Empuje:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(237, 51, 110, 14);

        imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagen.setText("imagen");
        imagen.setToolTipText("");
        getContentPane().add(imagen);
        imagen.setBounds(10, 10, 221, 200);

        jLabel4.setText("Combustible/s:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(237, 71, 130, 14);

        combustibles.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        combustibles.setText("combustibles");
        getContentPane().add(combustibles);
        combustibles.setBounds(390, 70, 190, 14);

        jLabel5.setText("Organización/origen:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(237, 91, 180, 14);

        origenes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        origenes.setText("origenes");
        getContentPane().add(origenes);
        origenes.setBounds(420, 90, 160, 14);

        fechaInicioActividades.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        fechaInicioActividades.setText("fechaInicioActividades");
        getContentPane().add(fechaInicioActividades);
        fechaInicioActividades.setBounds(460, 110, 120, 14);

        jLabel6.setText("Fecha de inicio de actividades:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(237, 111, 180, 14);

        jLabel7.setText("Fecha de fin de actividades:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(237, 131, 210, 14);

        fechaFinActividades.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        fechaFinActividades.setText("fechaFinActividades");
        getContentPane().add(fechaFinActividades);
        fechaFinActividades.setBounds(450, 130, 130, 14);

        jLabel8.setText("¿Ya fue lanzada?:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(237, 151, 160, 14);

        fueLanzado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        fueLanzado.setText("fueLanzado");
        getContentPane().add(fueLanzado);
        fueLanzado.setBounds(430, 150, 150, 14);

        button_cancelar.setText("Cancelar");
        button_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(button_cancelar);
        button_cancelar.setBounds(10, 280, 90, 23);

        button_lanzar.setText("Lanzar");
        button_lanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_lanzarActionPerformed(evt);
            }
        });
        getContentPane().add(button_lanzar);
        button_lanzar.setBounds(520, 280, 65, 23);

        desc1.setText("Capacidad:");
        getContentPane().add(desc1);
        desc1.setBounds(237, 171, 190, 14);

        dato1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dato1.setText("capacidad");
        getContentPane().add(dato1);
        dato1.setBounds(420, 170, 160, 14);

        desc2.setText("Tripulantes:");
        getContentPane().add(desc2);
        desc2.setBounds(237, 191, 210, 14);

        tripulantes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        tripulantes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tripulantes_scroll.setViewportView(tripulantes);

        getContentPane().add(tripulantes_scroll);
        tripulantes_scroll.setBounds(310, 190, 270, 80);

        nombre_otra_nave.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nombre_otra_nave.setText("nombre_otra_nave");
        getContentPane().add(nombre_otra_nave);
        nombre_otra_nave.setBounds(314, 190, 270, 14);

        button_agregartripulante.setText("Agregar tripulante");
        button_agregartripulante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_agregartripulanteActionPerformed(evt);
            }
        });
        getContentPane().add(button_agregartripulante);
        button_agregartripulante.setBounds(220, 280, 140, 23);

        button_descontinuar.setText("Finalizar actividades");
        button_descontinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_descontinuarActionPerformed(evt);
            }
        });
        getContentPane().add(button_descontinuar);
        button_descontinuar.setBounds(370, 280, 140, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_button_cancelarActionPerformed

    private void button_lanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_lanzarActionPerformed
        if (nave.fue_lanzado() || !fechaFinActividades.getText().equals("N/A"))
           JOptionPane.showMessageDialog(this, "La nave ya fue lanzada o ya finalizaron las actividades de la nave");
        else {
            switch (tipo) {
                case InfoBasicaNave.TIPO_TRIPULADA:
                    if (tripulada.Lanzar()) {
                        JOptionPane.showMessageDialog(this, "Se lanzó al espacio la nave");
                        fueLanzado.setText("Sí");
                    }
                    else
                        JOptionPane.showMessageDialog(this, "No se pudo lanzar la nave, la cantidad de integrantes no coincide con el numero de integrantes");
                    break;
                case InfoBasicaNave.TIPO_NOTRIPULADA:
                    notripulada.Lanzar();
                    JOptionPane.showMessageDialog(this, "La nave se lanzó al espacio");
                    fueLanzado.setText("Sí");
                    break;
                default:
                    ventana_lanzadera.abrir(lanzadera);
                    break;
            }
        }
    }//GEN-LAST:event_button_lanzarActionPerformed

    private void button_agregartripulanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_agregartripulanteActionPerformed
        String result = (String) JOptionPane.showInputDialog(
            this,
            "Introduzca el nombre del nuevo tripulante",
            "Nombre del tripulante",
            JOptionPane.PLAIN_MESSAGE,
            null,
            null,
            ""
        );
        if (result != null && result.length() > 0) {
            tripulada.agregar_tripulante(result);
            tripulantes.setListData(tripulada.getTripulantes().toArray(new String[tripulada.getTripulantes().size()]));
        } else
            JOptionPane.showMessageDialog(this, "No se introdujo ningún nombre");
    }//GEN-LAST:event_button_agregartripulanteActionPerformed

    private void button_descontinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_descontinuarActionPerformed
        if (!fechaFinActividades.getText().equals("N/A")) {
           JOptionPane.showMessageDialog(this, "La nave ya finalizo actividades");
        }
        else {
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            fechaFinActividades.setText(format.format(new Date()));
            nave.descontinuar();
            JOptionPane.showMessageDialog(this, "Se han finalizado las actividades de la nave");
        }
    }//GEN-LAST:event_button_descontinuarActionPerformed

    public void Lanzar() {
        fueLanzado.setText("Sí");
    }
    
    private Nave nave;
    private String tipo;
    private NoTripulada notripulada = null;
    private Tripulada tripulada = null;
    private VehiculoLanzadera lanzadera = null;

    private LanzarLanzadera ventana_lanzadera;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_agregartripulante;
    private javax.swing.JButton button_cancelar;
    private javax.swing.JButton button_descontinuar;
    private javax.swing.JButton button_lanzar;
    private javax.swing.JLabel combustibles;
    private javax.swing.JLabel dato1;
    private javax.swing.JLabel desc1;
    private javax.swing.JLabel desc2;
    private javax.swing.JLabel empuje;
    private javax.swing.JLabel fechaFinActividades;
    private javax.swing.JLabel fechaInicioActividades;
    private javax.swing.JLabel fueLanzado;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel nombre_otra_nave;
    private javax.swing.JLabel origenes;
    private javax.swing.JLabel peso;
    private javax.swing.JList<String> tripulantes;
    private javax.swing.JScrollPane tripulantes_scroll;
    // End of variables declaration//GEN-END:variables

}
