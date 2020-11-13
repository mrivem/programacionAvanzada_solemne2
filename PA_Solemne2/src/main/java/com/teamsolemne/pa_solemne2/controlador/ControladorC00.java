package com.teamsolemne.pa_solemne2.controlador;

import com.mrivem.pa_tallerclase.vista.P00_InicioSesion;
import com.teamsolemne.pa_solemne2.modelo.Administrador;
import com.teamsolemne.pa_solemne2.modelo.Alumno;
import com.teamsolemne.pa_solemne2.modelo.OperacionesAutenticacion;
import com.teamsolemne.pa_solemne2.modelo.Profesor;
import com.teamsolemne.pa_solemne2.modelo.Usuario;
import com.teamsolemne.pa_solemne2.vista.P10_VistaAlumno;
import com.teamsolemne.pa_solemne2.vista.P20_VistaProfesor;
import com.teamsolemne.pa_solemne2.vista.P30_VistaAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControladorC00 implements ActionListener {
    
    //private final Usuario mod;
    private final OperacionesAutenticacion modC;
    private final P00_InicioSesion frame;
    
    public ControladorC00(P00_InicioSesion frame){
        //this.mod = new Usuario(0, "", "");
        this.modC = new OperacionesAutenticacion();
        this.frame = frame;
        setListeners();
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Inicio de sesión");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    private void setListeners(){
        this.frame.jButton_ingresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frame.jButton_ingresar){

            Usuario loggedUser = modC.autenticar(frame.jTextField_nombre.getText(), frame.jPasswordField_contrasena.getPassword());
            if(loggedUser != null){
                System.out.println("Usuario autenticado exitosamente");
                if(loggedUser instanceof Alumno){
                    System.out.format("Iniciando como alumno -> %s\n", ((Alumno) loggedUser).toString());
                    ControladorC10 con = new ControladorC10(new P10_VistaAlumno(), (Alumno) loggedUser);
                    con.iniciar();
                } else if (loggedUser instanceof Profesor){
                    System.out.format("Iniciando como Profesor -> %s\n", ((Profesor) loggedUser).toString());
                    ControladorC20 con = new ControladorC20(new P20_VistaProfesor(), (Profesor) loggedUser);
                    con.iniciar();
                } else if (loggedUser instanceof Administrador){
                    System.out.format("Iniciando como Administrador -> %s\n", ((Administrador) loggedUser).toString());
                    ControladorC30 con = new ControladorC30(new P30_VistaAdministrador(), (Administrador) loggedUser);
                    con.iniciar();
                }
                frame.dispose();
            } else {
                System.out.println("Nombre de usuario o contraseña incorrecta");
            }
        }
    }
}
