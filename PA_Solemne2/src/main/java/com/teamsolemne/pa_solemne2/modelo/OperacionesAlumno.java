package com.teamsolemne.pa_solemne2.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OperacionesAlumno extends Conexion {
    
    // VERBOSE = Quiero que el programa me imprima en consola todo lo que hace
    private static final boolean VERBOSE = true;
    
    public ArrayList<Alumno> listarAlumnosClase(Alumno alumno){
        ArrayList<Alumno> alumnos = new ArrayList<>();  // Campo a retornar
        ArrayList<Object> auxList = new ArrayList<>();  // Guardará los ids de las asignaturas del alumno
        ArrayList<Object> auxList2 = new ArrayList<>(); // Guardará los ids de los compañeros de clase del alumno
        
        if (VERBOSE) System.out.format("listarAlumnosClase para alumno %s\n", alumno.toString());
        
        // Preparo la query, pido asignaturas del usuario
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM asignatura_has_alumno WHERE alumno_id = ?";
        if (VERBOSE) System.out.println(sql);
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.id);
            rs = ps.executeQuery();
            // Para cada asignatura
            while(rs.next()){
                // Guardo el id
                if (VERBOSE) System.out.format("Alumno id:%s en asignatura id:%s\n", alumno.id, rs.getInt("asignatura_id"));
                auxList.add(rs.getInt("asignatura_id"));
            }
            
            // Preparo la query, pido los ids de los alumnos en las asignaturas (compañeros de alumno)
            sql = "SELECT * FROM asignatura_has_alumno WHERE asignatura_id = ?";
            ps = con.prepareStatement(sql);
            if (VERBOSE) System.out.println(sql);
            for(int i = 0; i < auxList.size(); i++){
                int i_id = (int) auxList.get(i);
                
                ps.setInt(1, i_id);
                rs = ps.executeQuery();
                // Para cada alumno
                while(rs.next()){
                    if (VERBOSE) System.out.format("Asignatura id:%s con alumno id:%s\n", i_id, rs.getInt("alumno_id"));
                    // si el id no existe en la lista y no es el id del alumno que realiza la operacion, agregalo
                    if(!auxList2.contains(rs.getInt("alumno_id")) && rs.getInt("alumno_id") != alumno.id)
                        auxList2.add(rs.getInt("alumno_id"));
                }
            }
            
            // Preparo la query, pido todos los datos de los alumnos por su id
            sql = "SELECT * FROM alumnos WHERE id = ?";
            ps = con.prepareStatement(sql);
            if (VERBOSE) System.out.println(sql);
            for(int i = 0; i < auxList2.size(); i++){                
                ps.setInt(1, (int) auxList2.get(i));
                rs = ps.executeQuery();
                // Para cada alumno
                while(rs.next()){
                    // Agregalo a la lista
                    alumnos.add(new Alumno(
                            rs.getInt("id"),
                            rs.getInt("nivel_id"),
                            rs.getString("login"),
                            rs.getString("clave"),
                            rs.getString("nombre"),
                            rs.getString("apellidos")
                    ));
                }
            }
            
            if(VERBOSE){
                System.out.format("%s resultados obtenidos\n", alumnos.size());
                alumnos.forEach((a) -> {
                    System.out.format("Alumno compañero -> %s\n", a.toString());
                });
            }
            // Retorna la lista
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
    
    public Object[] listarProfesores(Alumno alumno){
        ArrayList<Profesor> profesores = new ArrayList<>();         // Campo a retornar
        ArrayList<String> nombreAsignaturas = new ArrayList<>();    // Campo a retornar
        ArrayList<Object> auxList = new ArrayList<>();
        
        if (VERBOSE) System.out.format("listarProfesores para alumno %s\n", alumno.toString());
        
        // Preparo la query, pido asignaturas del usuario
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM asignatura_has_alumno WHERE alumno_id = ?";
        if (VERBOSE) System.out.println(sql);
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.id);
            rs = ps.executeQuery();
            // Para cada asignatura
            while(rs.next()){
                // Guardo el id
                if (VERBOSE) System.out.format("Alumno id:%s en asignatura id:%s\n", alumno.id, rs.getInt("asignatura_id"));
                auxList.add(rs.getInt("asignatura_id"));
            }
            Object[] ids_asignaturas = auxList.toArray();
            auxList.clear();
            
            // Preparo la query, pido los ids de los profes en las asignaturas
            sql = "SELECT * FROM asignaturas WHERE id = ?";
            ps = con.prepareStatement(sql);
            if (VERBOSE) System.out.println(sql);
            for(int i = 0; i < ids_asignaturas.length; i++){                
                ps.setInt(1, (int) ids_asignaturas[i]);
                rs = ps.executeQuery();
                // Para cada alumno
                while(rs.next()){
                    if (VERBOSE) System.out.format("Asignatura id:%s con profe id:%s\n", (int) ids_asignaturas[i], rs.getInt("profesor_id"));
                    nombreAsignaturas.add(rs.getString("nombre"));
                    auxList.add(rs.getInt("profesor_id"));
                }
            }
            Object[] ids_profesores = auxList.toArray();
            auxList.clear();
            
            // Preparo la query, pido todos los datos de los profes por su id
            sql = "SELECT * FROM profesores WHERE id = ?";
            ps = con.prepareStatement(sql);
            if (VERBOSE) System.out.println(sql);
            for(int i = 0; i < ids_profesores.length; i++){                
                ps.setInt(1, (int) ids_profesores[i]);
                rs = ps.executeQuery();
                // Para cada profe
                while(rs.next()){
                    // Agregalo a la lista
                    profesores.add(new Profesor(
                            rs.getInt("id"),
                            rs.getString("login"),
                            rs.getString("clave"),
                            rs.getString("nombre"),
                            rs.getString("apellidos"),
                            rs.getString("email"),
                            rs.getInt("especialista")
                    ));
                }
            }
            
            if(VERBOSE){
                System.out.format("%s resultados obtenidos\n", profesores.size());
                for(int i = 0; i < profesores.size(); i++){
                    System.out.format("Profesor -> %s realizando la asignatura %s\n", profesores.get(i).toString(), nombreAsignaturas.get(i));
                }
            }
            // Retorna la lista
            return new Object[]{profesores, nombreAsignaturas};
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
    
    public ArrayList<Asignatura> listarAsignaturas(Alumno alumno){
        return null;
    }
    
    public ArrayList<Nota> listarNotasAsignatura(Asignatura asignatura, Alumno alumno){
        return null;
    }
}
