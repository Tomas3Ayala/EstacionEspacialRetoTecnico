
package Persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    public static Properties getProperties() {
        FileInputStream in = null;
        try {
            Properties defaultProps = new Properties();
            in = new FileInputStream("config/config.properties");
            try {
                defaultProps.load(in);
            } catch (IOException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            return defaultProps;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return new Properties();
    }
    
    public static final Properties properties = getProperties();
    
    public static final String host = properties.getProperty("host");
    public static final String port = properties.getProperty("port");
    public static final String db = properties.getProperty("db");
    public static final String user = properties.getProperty("user");
    public static final String pass = properties.getProperty("pass");
  
    public Connection conexion = null;

    private static ConexionDB instance;
    public static ConexionDB getInstance() {
        if (instance == null)
            instance = new ConexionDB();
        return instance;
    }
    
    public Connection getConnection() {
        if (conexion == null) {
            try {
                com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
                DriverManager.registerDriver(driver);
                conexion = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, pass);
            } catch (SQLException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return conexion;
    }
   
    public void close() {
        System.out.println("cerrando...");
        if (conexion != null) {
            try {
                conexion.close();
                conexion = null;
            } catch (SQLException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
}