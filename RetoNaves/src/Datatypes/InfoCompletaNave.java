package Datatypes;

import java.util.ArrayList;
import java.util.Date;

public class InfoCompletaNave {
    private String nombre; // nombre unico que la identifica
    private boolean lanzado; // true si fue lanzado
    private ArrayList<String> origen; // organizacion detras de las nave, como ESA, NASA, etc.
    private Date fechaInicioActividades;
    private Date fechaFinActividades;
    private ArrayList<String> combustible; // tipos de combustible
    private float peso; // kg de peso
    private float empuje; // kg de fuerza

    public InfoCompletaNave(String nombre, boolean lanzado, ArrayList<String> origen, Date fechaInicioActividades, Date fechaFinActividades, ArrayList<String> combustible, float peso, float empuje) {
        this.nombre = nombre;
        this.lanzado = lanzado;
        this.origen = origen;
        this.fechaInicioActividades = fechaInicioActividades;
        this.fechaFinActividades = fechaFinActividades;
        this.combustible = combustible;
        this.peso = peso;
        this.empuje = empuje;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isLanzado() {
        return lanzado;
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
