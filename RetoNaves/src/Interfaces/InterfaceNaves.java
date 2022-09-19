package Interfaces;

import Clases.Nave;
import Clases.NoTripulada;
import Clases.Tripulada;
import Clases.VehiculoLanzadera;
import Datatypes.InfoBasicaNave;
import Datatypes.InfoCompletaNave;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

public interface InterfaceNaves {
    public String juntar_strings_separadas_con(ArrayList<String> lista, String separacion);
    public ArrayList<InfoBasicaNave> obtener_informacion_basica_de_naves();
    public ArrayList<InfoBasicaNave> obtener_informacion_basica_de_naves(String search);

    public InfoCompletaNave obtener_info_completa_de_nave(String nombre);
    public Tripulada obtener_tripulada(String nombre);
    public NoTripulada obtener_notripulada(String nombre);
    public VehiculoLanzadera obtener_lanzadera(String nombre);
    
    public boolean nombre_repetido(String nombre);
    
    public ImageIcon obtener_imagen_de_nave(String nombre);

    public ArrayList<String> obtener_nolanzaderas();

    public Nave obtener_nave(String nombre);

    public ArrayList<String> obtener_nolanzaderas_con_peso_menor_a(float capacidad);

    public ArrayList<String> obtener_nolanzaderas_compatibles_con_lanzadera(VehiculoLanzadera lanzadera);

    public void guardar_combustibles(String nombre, ArrayList<String> combustibles);
    public void guardar_origenes(String nombre, ArrayList<String> origenes);
    public void guardar_lanzadera(VehiculoLanzadera lanzadera, byte[] image);
    public void guardar_notripulada(NoTripulada notripulada, byte[] image);
    public void guardar_tripulada(Tripulada tripulada, byte[] image);
    
    public void agregar_tripulante(String nombre, String nombre_tripulante);
    public void settear_nombre_nave_lanzada(String nombre, String nombre_nave_lanzada);
    public void guardar_lanzada_de_nave(String nombre);
    public void settear_fecha_fin_actividades(String nombre, Date fechaFinActividades);

    public ArrayList<String> obtener_origenes();
}
