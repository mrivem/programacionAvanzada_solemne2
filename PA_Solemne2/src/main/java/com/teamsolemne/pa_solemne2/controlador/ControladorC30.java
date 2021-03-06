package com.teamsolemne.pa_solemne2.controlador;

import com.mrivem.pa_tallerclase.vista.P00_InicioSesion;
import com.teamsolemne.pa_solemne2.modelo.Administrador;
import com.teamsolemne.pa_solemne2.vista.P30_VistaAdministrador;
import com.teamsolemne.pa_solemne2.vista.P31_CrearAlumno;
import com.teamsolemne.pa_solemne2.vista.P32_BuscarAlumno;
import com.teamsolemne.pa_solemne2.vista.P33_CrearAsignatura;
import com.teamsolemne.pa_solemne2.vista.P34_BuscarAsignatura;
import com.teamsolemne.pa_solemne2.vista.P35_MatricularAlumno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControladorC30 implements ActionListener {
    
    private final P30_VistaAdministrador frame;
    private final Administrador user;

    public ControladorC30(P30_VistaAdministrador frame, Administrador user) {
        this.frame = frame;
        this.user = user;
        setListeners();
    }
    
    private void setListeners(){
        frame.jButton_cerrarSesion.addActionListener(this);
        frame.jButton_crearAlumno.addActionListener(this);
        frame.jButton_crearAsignatura.addActionListener(this);
        frame.jButton_buscarAlumno.addActionListener(this);
        frame.jButton_buscarAsignatura.addActionListener(this);
        frame.jButton_matricularAlumno.addActionListener(this);
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Portal Administrador");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {  
        if(e.getSource() == frame.jButton_crearAlumno){
            ControladorC31 con = new ControladorC31(new P31_CrearAlumno());
            con.iniciar();
        }
        
        if(e.getSource() == frame.jButton_crearAsignatura){
            ControladorC33 con = new ControladorC33(new P33_CrearAsignatura());
            con.iniciar();
        }
        
        if(e.getSource() == frame.jButton_buscarAlumno){
            ControladorC32 con = new ControladorC32(new P32_BuscarAlumno());
            con.iniciar();
        }
        
        if(e.getSource() == frame.jButton_buscarAsignatura){
            ControladorC34 con = new ControladorC34(new P34_BuscarAsignatura());
            con.iniciar();
        }
        
        if(e.getSource() == frame.jButton_matricularAlumno){
            ControladorC35 con = new ControladorC35(new P35_MatricularAlumno());
            con.iniciar();
        }
        
        if(e.getSource() == frame.jButton_cerrarSesion){
            ControladorC00 con = new ControladorC00(new P00_InicioSesion());
            con.iniciar();
            frame.dispose();
        }
    }
    
}
