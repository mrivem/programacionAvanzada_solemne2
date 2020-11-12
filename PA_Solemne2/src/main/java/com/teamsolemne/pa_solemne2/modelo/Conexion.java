package com.teamsolemne.pa_solemne2.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private final String base = "pasolemne2";
    private final String user = "dbSolemne2";
    private final String password = "d3dl2AtLbnLPMXBN";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("conectado a la BBDD");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
            System.out.println("Error en la conexión a la BBDD");
        }

        return con;
    }
    
}

