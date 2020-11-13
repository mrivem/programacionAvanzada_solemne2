package com.teamsolemne.pa_solemne2.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class OperacionesAutenticacion extends Conexion {
    
    public Usuario autenticar(String login, char[] clave){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql;
        try {
            sql = "SELECT * FROM alumnos WHERE login = ? and clave = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, String.valueOf(clave));
            rs = ps.executeQuery();
            
            if (rs.next()){
                return new Alumno(
                        rs.getInt("id"),
                        rs.getInt("nivel_id"),
                        rs.getString("login"),
                        rs.getString("clave"),
                        rs.getString("nombre"),
                        rs.getString("apellidos")
                );
            }
            
            sql = "SELECT * FROM profesores WHERE login = ? and clave = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, String.valueOf(clave));
            rs = ps.executeQuery();
            
            if (rs.next()){
                return new Profesor(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("clave"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        rs.getInt("especialista")
                );
            }
            
            sql = "SELECT * FROM administradores WHERE login = ? and clave = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, String.valueOf(clave));
            rs = ps.executeQuery();
            
            if (rs.next()){
                return new Administrador(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("clave"),
                        rs.getString("email")
                );
            }
            return null;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
