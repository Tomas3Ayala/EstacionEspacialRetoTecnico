package Clases;

import java.util.ArrayList;
import java.util.Date;
import Fabrica.Fabrica;

public class Tripulada extends Nave{
    private int numero_tripulantes;
    private ArrayList<String> tripulantes;

    public Tripulada(String nombre, boolean lanzado, ArrayList<String> origen, Date fechaInicioActividades, Date fechaFinActividades, ArrayList<String> combustible, float peso, float empuje, int numero_tripulantes, ArrayList<String> tripulantes) {
        super(nombre, lanzado, origen, fechaInicioActividades, fechaFinActividades, combustible, peso, empuje);
        this.numero_tripulantes = numero_tripulantes;
        this.tripulantes = tripulantes;
    }
    
    public void agregar_tripulante(String tripulante) {
        this.tripulantes.add(tripulante);
        Fabrica.getINaves().agregar_tripulante(getNombre(), tripulante);
    }
    
    @Override
    public boolean Lanzar() {
        // chequea si se puede lanzar teniendo el numero de tripulantes correcto y que no este descontinuado
        if (obtener_fecha_fin_actividades() == null && se_puede_lanzar())
            return super.Lanzar();
        return false;
    }

    public int getNumero_tripulantes() {
        return numero_tripulantes;
    }

    public ArrayList<String> getTripulantes() {
        return tripulantes;
    }
    
    public boolean se_puede_lanzar() {
        return tripulantes.size() == numero_tripulantes;
    }
    
}
