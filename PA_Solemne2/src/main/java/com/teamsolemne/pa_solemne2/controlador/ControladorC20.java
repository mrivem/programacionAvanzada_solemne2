package com.teamsolemne.pa_solemne2.controlador;

import com.mrivem.pa_tallerclase.vista.P00_InicioSesion;
import com.teamsolemne.pa_solemne2.modelo.Profesor;
import com.teamsolemne.pa_solemne2.vista.P20_VistaProfesor;
import com.teamsolemne.pa_solemne2.vista.P40_ListaCompartida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControladorC20 implements ActionListener {
    
    private final P20_VistaProfesor frame;
    private final Profesor user;

    public ControladorC20(P20_VistaProfesor frame, Profesor user) {
        this.frame = frame;
        this.user = user;
        setListeners();
    }
    
    private void setListeners(){
        frame.jButton_cerrarSesion.addActionListener(this);
        frame.jButton_listarProfesores.addActionListener(this);
        frame.jButton_listarAlumnos.addActionListener(this);
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Portal Profesor");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frame.jButton_listarProfesores){
            ControladorC21 con = new ControladorC21(new P40_ListaCompartida(), user);
            con.iniciar();
            frame.dispose();
        }
        
        if(e.getSource() == frame.jButton_listarAlumnos){
            ControladorC22 con = new ControladorC22(new P40_ListaCompartida(), user);
            con.iniciar();
            frame.dispose();
        }
        
        if(e.getSource() == frame.jButton_cerrarSesion){
            ControladorC00 con = new ControladorC00(new P00_InicioSesion());
            con.iniciar();
            frame.dispose();
        }
    }
    
}
