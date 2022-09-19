package Controladores;

import Clases.Nave;
import Clases.NoTripulada;
import Clases.Tripulada;
import Clases.VehiculoLanzadera;
import Datatypes.InfoBasicaNave;
import Datatypes.InfoCompletaNave;
import Fabrica.Fabrica;
import Interfaces.InterfaceNaves;
import Persistencia.ConexionDB;
import java.awt.Image;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class ControllerNaves implements InterfaceNaves {

    @Override
    public String juntar_strings_separadas_con(ArrayList<String> lista, String separacion) {
        String r = new String();
        for (int i = 0; i < lista.size(); i++) {
            if (i != 0)
                r += separacion;
            r += lista.get(i);
        }
        if (lista.isEmpty())
            return "N/A";
        return r;
    }

    @Override
    public ArrayList<InfoBasicaNave> obtener_informacion_basica_de_naves() {
        ArrayList<InfoBasicaNave> info = new ArrayList<>();
        Connection con = ConexionDB.getInstance().getConnection();
        String[] tipos = {
            InfoBasicaNave.TIPO_TRIPULADA,
            InfoBasicaNave.TIPO_NOTRIPULADA,
            InfoBasicaNave.TIPO_LANZADERA,
        };
        for (int i = 0; i < tipos.length; i++) {
            try {
                PreparedStatement query = con.prepareStatement("SELECT n.* FROM nave as n, " + tipos[i] + " WHERE n.Nombre=" + tipos[i] + ".Nombre");
                ResultSet naves = query.executeQuery();
                while (naves.next()) {
                    ArrayList<String> origenes = new ArrayList<>();
                    try {
                        query = con.prepareStatement("SELECT * FROM origen as o WHERE o.nombre=?");
                        query.setString(1, naves.getString("Nombre"));
                        ResultSet origenes_set = query.executeQuery();
                        while (origenes_set.next()) {
                            origenes.add(origenes_set.getString("Origen"));
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    info.add(new InfoBasicaNave(tipos[i], naves.getString("Nombre"), naves.getString("Peso"), juntar_strings_separadas_con(origenes, ", ")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return info;
    }
    
    @Override
    public ArrayList<InfoBasicaNave> obtener_informacion_basica_de_naves(String search) {
        ArrayList<InfoBasicaNave> info = new ArrayList<>();
        Connection con = ConexionDB.getInstance().getConnection();
        String[] tipos = {
            InfoBasicaNave.TIPO_TRIPULADA,
            InfoBasicaNave.TIPO_NOTRIPULADA,
            InfoBasicaNave.TIPO_LANZADERA,
        };
        for (int i = 0; i < tipos.length; i++) {
            try {
                PreparedStatement query = con.prepareStatement("SELECT n.* FROM nave as n, " + tipos[i] + " WHERE n.Nombre=" + tipos[i] + ".Nombre AND n.Nombre LIKE '%" + search + "%'");
                ResultSet naves = query.executeQuery();
                while (naves.next()) {
                    ArrayList<String> origenes = new ArrayList<>();
                    try {
                        query = con.prepareStatement("SELECT * FROM origen as o WHERE o.nombre=?");
                        query.setString(1, naves.getString("Nombre"));
                        ResultSet origenes_set = query.executeQuery();
                        while (origenes_set.next()) {
                            origenes.add(origenes_set.getString("Origen"));
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    info.add(new InfoBasicaNave(tipos[i], naves.getString("Nombre"), naves.getString("Peso"), juntar_strings_separadas_con(origenes, ", ")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return info;
    }
    
    @Override
    public InfoCompletaNave obtener_info_completa_de_nave(String nombre) {
        InfoCompletaNave info = null;
        Connection con = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM nave WHERE nave.Nombre=?");
            query.setString(1, nombre);
            ResultSet naves = query.executeQuery();
            if (naves.next()) {
                ArrayList<String> origenes = new ArrayList<>();
                try {
                    query = con.prepareStatement("SELECT * FROM origen as o WHERE o.Nombre=?");
                    query.setString(1, nombre);
                    ResultSet origenes_set = query.executeQuery();
                    while (origenes_set.next()) {
                        origenes.add(origenes_set.getString("Origen"));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
                }
                ArrayList<String> combustibles = new ArrayList<>();
                try {
                    query = con.prepareStatement("SELECT * FROM combustible as c WHERE c.Nombre=?");
                    query.setString(1, nombre);
                    ResultSet combustibles_set = query.executeQuery();
                    while (combustibles_set.next()) {
                        combustibles.add(combustibles_set.getString("Combustible"));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
                }
                info = new InfoCompletaNave(
                    nombre,
                    naves.getBoolean("Lanzado"),
                    origenes,
                    naves.getDate("FechaInicioActividades"),
                    naves.getDate("FechaFinActividades"),
                    combustibles,
                    naves.getFloat("peso"),
                    naves.getFloat("empuje")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
        }
        return info;
    }

    @Override
    public Tripulada obtener_tripulada(String nombre) {
        Tripulada tripulada = null;
        Connection con = ConexionDB.getInstance().getConnection();
        InfoCompletaNave info = obtener_info_completa_de_nave(nombre);
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM tripulada as t WHERE t.Nombre=?");
            query.setString(1, nombre);
            ResultSet tripuladas = query.executeQuery();
            if (tripuladas.next()) {
                ArrayList<String> tripulantes = new ArrayList<>();
                try {
                    query = con.prepareStatement("SELECT * FROM tripulante as t WHERE t.NombreTripulada=?");
                    query.setString(1, nombre);
                    ResultSet tripulantes_set = query.executeQuery();
                    while (tripulantes_set.next()) {
                        tripulantes.add(tripulantes_set.getString("Nombre"));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
                }
                tripulada = new Tripulada(
                    info.getNombre(),
                    info.isLanzado(),
                    info.getOrigen(),
                    info.getFechaInicioActividades(),
                    info.getFechaFinActividades(),
                    info.getCombustible(),
                    info.getPeso(),
                    info.getEmpuje(),
                    tripuladas.getInt("NumeroTripulantes"),
                    tripulantes
                );
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tripulada;
    }

    @Override
    public NoTripulada obtener_notripulada(String nombre) {
        InfoCompletaNave info = obtener_info_completa_de_nave(nombre);
        return new NoTripulada(info.getNombre(), info.isLanzado(), info.getOrigen(), info.getFechaInicioActividades(), info.getFechaFinActividades(), info.getCombustible(), info.getPeso(), info.getEmpuje());
    }

    @Override
    public VehiculoLanzadera obtener_lanzadera(String nombre) {
        VehiculoLanzadera lanzadera = null;
        Connection con = ConexionDB.getInstance().getConnection();
        InfoCompletaNave info = obtener_info_completa_de_nave(nombre);
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM vehiculolanzadera as v WHERE v.Nombre=?");
            query.setString(1, nombre);
            ResultSet lanzaderas_set = query.executeQuery();
            if (lanzaderas_set.next()) {
                lanzadera = new VehiculoLanzadera(
                    info.getNombre(),
                    info.isLanzado(),
                    info.getOrigen(),
                    info.getFechaInicioActividades(),
                    info.getFechaFinActividades(),
                    info.getCombustible(),
                    info.getPeso(),
                    info.getEmpuje(),
                    lanzaderas_set.getFloat("Capacidad"),
                    lanzaderas_set.getString("NombreNaveLanzada")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lanzadera;
    }
    
    @Override
    public boolean nombre_repetido(String nombre) {
        Connection con = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM nave WHERE Nombre=?");
            query.setString(1, nombre);
            ResultSet naves = query.executeQuery();
            if (naves.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public ImageIcon obtener_imagen_de_nave(String nombre) {
        ImageIcon image = null;
        Connection con = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = con.prepareStatement("SELECT Imagen FROM nave as n WHERE n.Nombre=?");
            query.setString(1, nombre);
            ResultSet naves_set = query.executeQuery();
            if (naves_set.next()) {
                byte[] bytes = naves_set.getBytes("Imagen");
                if (bytes != null)
                    image = new ImageIcon(bytes);//(ImageIcon) naves_set.getObject("Imagen");//
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }
    
    
    @Override
    public ArrayList<String> obtener_nolanzaderas() {
        ArrayList<String> nolanzaderas = new ArrayList<>();
        Connection con = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = con.prepareStatement("SELECT Nombre FROM nave");
            ResultSet naves_set = query.executeQuery();
            while (naves_set.next()) {
                query = con.prepareStatement("SELECT Nombre FROM vehiculolanzadera as v WHERE v.Nombre=?");
                query.setString(1, naves_set.getString("Nombre"));
                ResultSet lanzaderas = query.executeQuery();
                if (!lanzaderas.next())
                    nolanzaderas.add(naves_set.getString("Nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nolanzaderas;
    }
    
    @Override
    public Nave obtener_nave(String nombre) {
        Nave nave = obtener_tripulada(nombre);
        if (nave == null)
            nave = obtener_lanzadera(nombre);
        if (nave == null)
            nave = obtener_notripulada(nombre);
        return nave;
    }
    
    @Override
    public ArrayList<String> obtener_nolanzaderas_con_peso_menor_a(float capacidad) {
        ArrayList<String> nolanzaderas = obtener_nolanzaderas();
        Predicate<String> peso_correcto = (String e) -> (Fabrica.getINaves().obtener_nave(e).getPeso() > capacidad);
        nolanzaderas.removeIf(peso_correcto);
        return nolanzaderas;
    }
    
    @Override
    public ArrayList<String> obtener_nolanzaderas_compatibles_con_lanzadera(VehiculoLanzadera lanzadera) {
        ArrayList<String> nolanzaderas = obtener_nolanzaderas_con_peso_menor_a(lanzadera.getCapacidad());
        ArrayList<String> a_quitar = new ArrayList<>();
        for (String e : nolanzaderas) {
            Tripulada nave = obtener_tripulada(e);
            if (nave != null) {
                if (obtener_nave(e).fue_lanzado() || !nave.se_puede_lanzar() || nave.esta_descontinuado())
                    a_quitar.add(e);
            }
            else if (obtener_nave(e).fue_lanzado() || obtener_nave(e).esta_descontinuado())
                a_quitar.add(e);
        }
        nolanzaderas.removeAll(a_quitar);
        return nolanzaderas;
    }

    @Override
    public void guardar_combustibles(String nombre, ArrayList<String> combustibles) {
        Connection con = ConexionDB.getInstance().getConnection();
        for (String combustible : combustibles) {
            try {
                PreparedStatement query = con.prepareStatement("INSERT INTO `combustible` (`Nombre`, `Combustible`) VALUES (?, ?)");
                query.setString(1, nombre);
                query.setString(2, combustible);
                query.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void guardar_origenes(String nombre, ArrayList<String> origenes) {
        Connection con = ConexionDB.getInstance().getConnection();
        for (String origen : origenes) {
            try {
                PreparedStatement query = con.prepareStatement("INSERT INTO `origen` (`Nombre`, `Origen`) VALUES (?, ?)");
                query.setString(1, nombre);
                query.setString(2, origen);
                query.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void guardar_lanzadera(VehiculoLanzadera lanzadera, byte[] image) {
        Connection con = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = con.prepareStatement("INSERT INTO `nave`"
                    + "(`Nombre`, `Imagen`, `Lanzado`, `FechaInicioActividades`, `FechaFinActividades`, `Peso`, `Empuje`) VALUES"
                    + "(?, ?, ?, ?, ?, ?, ?)");
            query.setString(1, lanzadera.getNombre());
            query.setBytes(2, image);
            query.setBoolean(3, lanzadera.fue_lanzado());
            if (lanzadera.getFechaInicioActividades() == null)
                query.setDate(4, null);
            else
                query.setDate(4, new java.sql.Date(lanzadera.getFechaInicioActividades().getTime()));
            if (lanzadera.getFechaFinActividades() == null)
                query.setDate(5, null);
            else
                query.setDate(5, new java.sql.Date(lanzadera.getFechaFinActividades().getTime()));
            query.setFloat(6, lanzadera.getPeso());
            query.setFloat(7, lanzadera.getEmpuje());
            query.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
        }
        guardar_combustibles(lanzadera.getNombre(), lanzadera.getCombustible());
        guardar_origenes(lanzadera.getNombre(), lanzadera.getOrigen());

        try {
            PreparedStatement query = con.prepareStatement("INSERT INTO `vehiculolanzadera` (`Nombre`, `Capacidad`, `NombreNaveLanzada`) VALUES (?, ?, ?)");
            query.setString(1, lanzadera.getNombre());
            query.setFloat(2, lanzadera.getCapacidad());
            query.setString(3, lanzadera.getNombre_nave_lanzada());
            query.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void guardar_notripulada(NoTripulada notripulada, byte[] image) {
        Connection con = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = con.prepareStatement("INSERT INTO `nave`"
                    + "(`Nombre`, `Imagen`, `Lanzado`, `FechaInicioActividades`, `FechaFinActividades`, `Peso`, `Empuje`) VALUES"
                    + "(?, ?, ?, ?, ?, ?, ?)");
            query.setString(1, notripulada.getNombre());
            query.setBytes(2, image);
            query.setBoolean(3, notripulada.fue_lanzado());
            if (notripulada.getFechaInicioActividades() == null)
                query.setDate(4, null);
            else
                query.setDate(4, new java.sql.Date(notripulada.getFechaInicioActividades().getTime()));
            if (notripulada.getFechaFinActividades() == null)
                query.setDate(5, null);
            else
                query.setDate(5, new java.sql.Date(notripulada.getFechaFinActividades().getTime()));
            query.setFloat(6, notripulada.getPeso());
            query.setFloat(7, notripulada.getEmpuje());
            query.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
        }
        guardar_combustibles(notripulada.getNombre(), notripulada.getCombustible());
        guardar_origenes(notripulada.getNombre(), notripulada.getOrigen());
        
        try {
            PreparedStatement query = con.prepareStatement("INSERT INTO `notripulada` (`Nombre`) VALUES (?)");
            query.setString(1, notripulada.getNombre());
            query.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void guardar_tripulada(Tripulada tripulada, byte[] image) {
        Connection con = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = con.prepareStatement("INSERT INTO `nave`"
                    + "(`Nombre`, `Imagen`, `Lanzado`, `FechaInicioActividades`, `FechaFinActividades`, `Peso`, `Empuje`) VALUES"
                    + "(?, ?, ?, ?, ?, ?, ?)");
            query.setString(1, tripulada.getNombre());
            query.setBytes(2, image);
            query.setBoolean(3, tripulada.fue_lanzado());
            if (tripulada.getFechaInicioActividades() == null)
                query.setDate(4, null);
            else
                query.setDate(4, new java.sql.Date(tripulada.getFechaInicioActividades().getTime()));
            if (tripulada.getFechaFinActividades() == null)
                query.setDate(5, null);
            else
                query.setDate(5, new java.sql.Date(tripulada.getFechaFinActividades().getTime()));
            query.setFloat(6, tripulada.getPeso());
            query.setFloat(7, tripulada.getEmpuje());
            query.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
        }
        guardar_combustibles(tripulada.getNombre(), tripulada.getCombustible());
        guardar_origenes(tripulada.getNombre(), tripulada.getOrigen());
        
        try {
            PreparedStatement query = con.prepareStatement("INSERT INTO `tripulada` (`Nombre`, `NumeroTripulantes`) VALUES (?, ?)");
            query.setString(1, tripulada.getNombre());
            query.setInt(2, tripulada.getNumero_tripulantes());
            query.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public ArrayList<String> obtener_origenes() {
        ArrayList<String> origenes = new ArrayList<>();
        Connection con = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = con.prepareStatement("SELECT DISTINCT Origen FROM `origen`");
            ResultSet origen_set = query.executeQuery();
            while (origen_set.next()) {
                origenes.add(origen_set.getString("Origen"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
        }
        return origenes;
    }

    @Override
    public void agregar_tripulante(String nombre, String nombre_tripulante) {
        Connection con = ConexionDB.getInstance().conexion;
        try {
            PreparedStatement query = con.prepareStatement("INSERT INTO `tripulante` (`NombreTripulada`, `Nombre`) VALUES (?, ?)");
            query.setString(1, nombre);
            query.setString(2, nombre_tripulante);
            query.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void settear_nombre_nave_lanzada(String nombre, String nombre_nave_lanzada) {
        Connection con = ConexionDB.getInstance().conexion;
        try {
            PreparedStatement query = con.prepareStatement("UPDATE `vehiculolanzadera` SET `NombreNaveLanzada` = ? WHERE `vehiculolanzadera`.`Nombre` = ?");
            query.setString(1, nombre_nave_lanzada);
            query.setString(2, nombre);
            query.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void guardar_lanzada_de_nave(String nombre) {
        Connection con = ConexionDB.getInstance().conexion;
        try {
            PreparedStatement query = con.prepareStatement("UPDATE `nave` SET `Lanzado` = '1' WHERE `nave`.`Nombre` = ?");
            query.setString(1, nombre);
            query.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void settear_fecha_fin_actividades(String nombre, java.util.Date fechaFinActividades) {
        Connection con = ConexionDB.getInstance().conexion;
        try {
            PreparedStatement query = con.prepareStatement("UPDATE `nave` SET `FechaFinActividades` = ? WHERE `nave`.`Nombre` = ?");
            query.setDate(1, new Date(fechaFinActividades.getTime()));
            query.setString(2, nombre);
            query.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControllerNaves.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
