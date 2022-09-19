package Clases;

import java.util.ArrayList;
import java.util.Date;

public class NoTripulada extends Nave {
    
    public NoTripulada(String nombre, boolean lanzado, ArrayList<String> origen, Date fechaInicioActividades, Date fechaFinActividades, ArrayList<String> combustible, float peso, float empuje) {
        super(nombre, lanzado, origen, fechaInicioActividades, fechaFinActividades, combustible, peso, empuje);
    }
    
}
