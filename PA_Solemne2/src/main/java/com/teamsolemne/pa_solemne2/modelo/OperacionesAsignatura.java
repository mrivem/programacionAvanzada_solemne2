package com.teamsolemne.pa_solemne2.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OperacionesAsignatura extends Conexion {
    
    private static final boolean VERBOSE = true;
    
    public boolean registrarAsignatura(Asignatura asignatura){     
        if (VERBOSE) System.out.format("registrarAsignatura con asignatura %S\n", asignatura.toString());
        
        // Preparo la query
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO asignaturas (nivel_id, profesor_id, nombre) VALUES (?, ?, ?);";
        if (VERBOSE) System.out.println(sql);
            
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, asignatura.getNivel_id());
            ps.setInt(2, asignatura.getProfesor_id());
            ps.setString(3, asignatura.getNombre());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminarAsignatura(int id){     
        if (VERBOSE) System.out.format("eliminarAsignatura con id %S\n", id);
        
        // Preparo la query
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM asignaturas WHERE id = ?;";
        if (VERBOSE) System.out.println(sql);
            
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificarAsignatura(Asignatura asignatura){     
        if (VERBOSE) System.out.format("modificarAsignatura con asignatura %S\n", asignatura.toString());
        
        // Preparo la query
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE asignaturas SET nivel_id = ?, profesor_id = ?, nombre = ? WHERE id = ?;";
        if (VERBOSE) System.out.println(sql);
            
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, asignatura.getNivel_id());
            ps.setInt(1, asignatura.getProfesor_id());
            ps.setString(3, asignatura.getNombre());
            ps.setInt(4, asignatura.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
