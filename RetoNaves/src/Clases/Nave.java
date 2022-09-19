package Clases;

import java.util.ArrayList;
import java.util.Date;
import Fabrica.Fabrica;

public abstract class Nave {
    private String nombre; // nombre unico que la identifica
    private boolean lanzado; // true si fue lanzado
    private ArrayList<String> origen; // organizacion detras de las nave, como ESA, NASA, etc.
    private Date fechaInicioActividades;
    private Date fechaFinActividades;
    private ArrayList<String> combustible; // tipos de combustible
    private float peso; // kg de peso
    private float empuje; // kg de fuerza

    public Nave(String nombre, boolean lanzado, ArrayList<String> origen, Date fechaInicioActividades, Date fechaFinActividades, ArrayList<String> combustible, float peso, float empuje) {
        this.nombre = nombre;
        this.lanzado = lanzado;
        this.origen = origen;
        this.fechaInicioActividades = fechaInicioActividades;
        this.fechaFinActividades = fechaFinActividades;
        this.combustible = combustible;
        this.peso = peso;
        this.empuje = empuje;
    }
    
    public boolean fue_lanzado() {
        return lanzado;
    }
    
    public boolean Lanzar() { // retorna true si se pudo lanzar la nave, en este caso general siempre se puede lanzar la nave
        lanzado = true;
        System.out.println("hasdiasdjiasidjioasdioasnid");
        Fabrica.getINaves().guardar_lanzada_de_nave(nombre);
        return true;
    }
    
    public Date obtener_fecha_fin_actividades() {
        return fechaFinActividades;
    }
    
    public void descontinuar() { // finaliza actividades
        if (obtener_fecha_fin_actividades() == null) {
            fechaFinActividades = new Date();
            Fabrica.getINaves().settear_fecha_fin_actividades(nombre, fechaFinActividades);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getOrigen() {
        return origen;
    }

    public Date getFechaInicioActividades() {
        return fechaInicioActividades;
    }

    public Date getFechaFinActividades() {
        return fechaFinActividades;
    }
    
    public boolean esta_descontinuado() {
        return obtener_fecha_fin_actividades() != null;
    }

    public ArrayList<String> getCombustible() {
        return combustible;
    }

    public float getPeso() {
        return peso;
    }

    public float getEmpuje() {
        return empuje;
    }
    
    
}
