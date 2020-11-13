package com.teamsolemne.pa_solemne2.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OperacionesAuxiliares extends Conexion {
    
    private String[] transformArrayList(ArrayList al){
        
        String[] newArr = new String[al.size()];
        for(int i = 0; i < al.size(); i++){
            newArr[i] = al.get(i).toString();
        }
        
        return newArr;
    }
    
    public String[] getNiveles(){
        ArrayList<String> niveles = new ArrayList<>();
        
        // Preparo la query
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM niveles;";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            // Para cada item en relacion
            while(rs.next()){
                int i_id = rs.getInt("id");
                niveles.add(i_id + "");
            }
            return transformArrayList(niveles);
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
    
    public String[] getProfesores(){
        ArrayList<String> profesores = new ArrayList<>();
        
        // Preparo la query
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM profesores;";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            // Para cada item en relacion
            while(rs.next()){
                int i_id = rs.getInt("id");
                String i_nombre = rs.getString("nombre");
                String i_apellidos = rs.getString("apellidos");
                profesores.add(i_id + " - " + i_nombre + " " + i_apellidos);
            }
            return transformArrayList(profesores);
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
    
    public String[] getAlumnos(){
        ArrayList<String> alumnos = new ArrayList<>();
        
        // Preparo la query
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM alumnos;";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            // Para cada item en relacion
            while(rs.next()){
                int i_id = rs.getInt("id");
                String i_nombre = rs.getString("nombre");
                String i_apellidos = rs.getString("apellidos");
                alumnos.add(i_id + " - " + i_nombre + " " + i_apellidos);
            }
            return transformArrayList(alumnos);
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
    
    public String[] getAsignaturas(){
        ArrayList<String> asignaturas = new ArrayList<>();
        
        // Preparo la query
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM asignaturas;";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            // Para cada item en relacion
            while(rs.next()){
                int i_id = rs.getInt("id");
                String i_nombre = rs.getString("nombre");
                asignaturas.add(i_id + " - " + i_nombre);
            }
            return transformArrayList(asignaturas);
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
