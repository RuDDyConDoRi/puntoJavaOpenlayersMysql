package com.conexion;

/**
 *
 * @author ruddy.condori
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyBaseDatosGIS {

    Connection con;

    public Connection getCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/gis", 
                            "root",                                  // user
                            "");                                     // password
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.con;
    }
}


