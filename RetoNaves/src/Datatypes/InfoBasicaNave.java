package Datatypes;

public class InfoBasicaNave {
    private final String tipo;
    private final String nombre;
    private final String peso;
    private final String organizaciones;
    public static final String TIPO_TRIPULADA = "tripulada";
    public static final String TIPO_NOTRIPULADA = "notripulada";
    public static final String TIPO_LANZADERA = "vehiculolanzadera";

    public InfoBasicaNave(String tipo, String nombre, String peso, String organizaciones) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.peso = peso;
        this.organizaciones = organizaciones;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPeso() {
        return peso;
    }

    public String getOrganizaciones() {
        return organizaciones;
    }
    
    public static String convertir_tipo_a_tipo_legible(String t) {
        String rt = new String();
        switch (t) {
            case TIPO_TRIPULADA:
                rt = "Tripulada";
                break;
            case TIPO_NOTRIPULADA:
                rt = "No tripulada";
                break;
            default:
                rt = "Vehiculo lanzadera";
                break;
        }
        return rt;
    }
    
    public String[] getAsArray() {
        String[] array = {convertir_tipo_a_tipo_legible(tipo), nombre, peso, organizaciones};
        return array;
    }
    
    
}
