package com.teamsolemne.pa_solemne2.controlador;

import com.mrivem.pa_tallerclase.vista.P00_InicioSesion;
import com.teamsolemne.pa_solemne2.modelo.Administrador;
import com.teamsolemne.pa_solemne2.modelo.Alumno;
import com.teamsolemne.pa_solemne2.modelo.OperacionesAutenticacion;
import com.teamsolemne.pa_solemne2.modelo.Profesor;
import com.teamsolemne.pa_solemne2.modelo.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControladorP00 implements ActionListener {
    
    //private final Usuario mod;
    private final OperacionesAutenticacion modC;
    private final P00_InicioSesion frame;
    
    public ControladorP00(P00_InicioSesion frame){
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
                    //ControladorP10 con = new ControladorP10(new P10_VistaEncargado());
                    //con.iniciar();
                } else if (loggedUser instanceof Profesor){
                    System.out.format("Iniciando como Profesor -> %s\n", ((Profesor) loggedUser).toString());
                    //ControladorP20 con = new ControladorP20(new P20_VistaProfesor());
                    //con.iniciar();
                } else if (loggedUser instanceof Administrador){
                    System.out.format("Iniciando como Administrador -> %s\n", ((Administrador) loggedUser).toString());
                    //ControladorP30 con = new ControladorP30(new P30_VistaAdministrador());
                    //con.iniciar();
                }
                frame.dispose();
            } else {
                System.out.println("Nombre de usuario o contraseña incorrecta");
            }
        }
    }
}
