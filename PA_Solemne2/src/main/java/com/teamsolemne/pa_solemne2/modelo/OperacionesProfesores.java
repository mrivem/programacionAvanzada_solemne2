package com.teamsolemne.pa_solemne2.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OperacionesProfesores extends Conexion {
    // VERBOSE = Quiero que el programa me imprima en consola todo lo que hace
    private static final boolean VERBOSE = true;
    
    public ArrayList<Profesor> listarProfesores(){
        ArrayList<Profesor> profesores = new ArrayList<>();  // Campo a retornar
        
        if (VERBOSE) System.out.format("listarProfesores\n");
        
        // Preparo la query
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM profesores";
        if (VERBOSE) System.out.println(sql);
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            // Para cada profesor
            while(rs.next()){
                Profesor p = new Profesor(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("clave"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        rs.getInt("especialista")
                );
                
                // Guardo el id
                if (VERBOSE) System.out.format("Profesor %s\n", p.toString());
                profesores.add(p);
            }
            
            if(VERBOSE){
                System.out.format("%s resultados obtenidos\n", profesores.size());
                for(int i = 0; i < profesores.size(); i++){
                    System.out.format("Profesor -> %s\n", profesores.get(i).toString());
                }
            }
            
            return profesores;
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
    
    public ArrayList<Asignatura> listarAsignaturasProfesor(Profesor profesor){
        ArrayList<Asignatura> asignaturas = new ArrayList<>();  // Campo a retornar
        
        if (VERBOSE) System.out.format("listarAsignaturasProfesor con profesor %S\n", profesor.toString());
        
        // Preparo la query
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM asignaturas WHERE profesor_id = ?;";
        if (VERBOSE) System.out.println(sql);
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, profesor.getId());
            rs = ps.executeQuery();
            // Para cada asignatura
            while(rs.next()){
                Asignatura a = new Asignatura(
                        rs.getInt("id"),
                        rs.getInt("nivel_id"),
                        rs.getInt("profesor_id"),
                        rs.getString("nombre")
                );
                
                // Guardo el id
                if (VERBOSE) System.out.format("Asignatura %s\n", a.toString());
                asignaturas.add(a);
            }
            
            if(VERBOSE){
                System.out.format("%s resultados obtenidos\n", asignaturas.size());
                for(int i = 0; i < asignaturas.size(); i++){
                    System.out.format("Asignatura -> %s\n", asignaturas.get(i).toString());
                }
            }
            
            return asignaturas;
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
    
    public ArrayList<Alumno> listarAlumnosAsignatura(Asignatura asignatura){
        ArrayList<Alumno> alumnos = new ArrayList<>();  // Campo a retornar
        ArrayList<Object> auxList = new ArrayList<>();
        
        if (VERBOSE) System.out.format("listarAlumnosAsignatura con asignatura %S\n", asignatura.toString());
        
        // Preparo la query
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM asignatura_has_alumno WHERE asignatura_id = ?;";
        if (VERBOSE) System.out.println(sql);
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, asignatura.getId());
            rs = ps.executeQuery();
            // Para cada item en relacion
            while(rs.next()){
                int i_id = rs.getInt("alumno_id");
                auxList.add(i_id);
                
                if (VERBOSE) System.out.format("Asignatura %s está el alumno de id: %s\n", asignatura.toString(), i_id);

            }
            Object[] ids_alumnos = auxList.toArray();
            auxList.clear();
            
            sql = "SELECT * FROM alumnos WHERE id = ?;";
            if (VERBOSE) System.out.println(sql);
            
            for(int i = 0; i < ids_alumnos.length; i++){
                ps = con.prepareStatement(sql);
                ps.setInt(1, (int) ids_alumnos[i]);
                rs = ps.executeQuery();
                
                while(rs.next()){
                    Alumno a = new Alumno(
                            rs.getInt("id"),
                            rs.getInt("nivel_id"),
                            rs.getString("login"),
                            rs.getString("clave"),
                            rs.getString("nombre"),
                            rs.getString("apellidos")
                    );

                    // Guardo el id
                    if (VERBOSE) System.out.format("Alumno %s\n", a.toString());
                    alumnos.add(a);
                }
            }            
            
            if(VERBOSE){
                System.out.format("%s resultados obtenidos\n", alumnos.size());
                for(int i = 0; i < alumnos.size(); i++){
                    System.out.format("Alumno -> %s\n", alumnos.get(i).toString());
                }
            }
            
            return alumnos;
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
    
    public void agregarNota(Nota nota){
        if (VERBOSE) System.out.format("agregarNota con nota %S\n", nota.toString());
        
        // Preparo la query
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO notas (asignatura_has_alumno_alumno_id, asignatura_has_alumno_asignatura_id, trimestre, nota) VALUES (?, ?, ?, ?);";
        if (VERBOSE) System.out.println(sql);
            
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, nota.getId_alumno());
            ps.setInt(2, nota.getId_asignatura());
            ps.setInt(3, nota.getTrimestre());
            ps.setDouble(4, nota.getNota());
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
