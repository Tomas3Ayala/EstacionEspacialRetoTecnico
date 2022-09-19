package Clases;

import java.util.ArrayList;
import java.util.Date;
import Fabrica.Fabrica;

public class VehiculoLanzadera extends Nave{
    private float capacidad; // kg de peso que puede llevar
    private String nombre_nave_lanzada;

    public VehiculoLanzadera(String nombre, boolean lanzado, ArrayList<String> origen, Date fechaInicioActividades, Date fechaFinActividades, ArrayList<String> combustible, float peso, float empuje, float capacidad, String nombre_nave_lanzada) {
        super(nombre, lanzado, origen, fechaInicioActividades, fechaFinActividades, combustible, peso, empuje);
        this.capacidad = capacidad;
        this.nombre_nave_lanzada = nombre_nave_lanzada;
    }
    
    @Override
    public boolean Lanzar() {
        return false; // no se puede lanzar un vehiculo lanzadera solo
    }
    
    public boolean Lanzar(Nave nave) {
        // chequea si no se terminado las actividades de la nave, no fue lanzada anteriormente y que el peso de la nave pasada como argumento no supero la capacidad del vehiculo
        if (obtener_fecha_fin_actividades() == null && !fue_lanzado() && nave.getPeso()<= capacidad) {
            nombre_nave_lanzada = nave.getNombre();
            Fabrica.getINaves().settear_nombre_nave_lanzada(getNombre(), nombre_nave_lanzada);
            return nave.Lanzar() && super.Lanzar(); // lanza la nave y el vehiculo lanzadera
        }
        return false;
    }

    public float getCapacidad() {
        return capacidad;
    }

    public String getNombre_nave_lanzada() {
        return nombre_nave_lanzada;
    }
    
    
}
