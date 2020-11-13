package com.teamsolemne.pa_solemne2.controlador;

import com.teamsolemne.pa_solemne2.modelo.Alumno;
import com.teamsolemne.pa_solemne2.modelo.OperacionesAlumno;
import com.teamsolemne.pa_solemne2.vista.P10_VistaAlumno;
import com.teamsolemne.pa_solemne2.vista.P40_ListaCompartida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class ControladorC11 implements ActionListener {
    
    private final P40_ListaCompartida frame;
    private final Alumno user;
    private final OperacionesAlumno modc = new OperacionesAlumno();

    public ControladorC11(P40_ListaCompartida frame, Alumno user) {
        this.frame = frame;
        this.user = user;
        setListeners();
    }
    
    private void setListeners(){
        frame.jButton_volver.addActionListener(this);
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Lista de compañeros");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        frame.jLabel_titulo.setText(String.format("Lista de compañeros del alumno %s %s", user.getNombre(), user.getApellidos()));
        frame.jTable_lista.setModel(getTableContents());
        frame.jButton_volver.setText("Volver");
        frame.jButton_consultarSeleccionado.setVisible(false);
    }
    
    private DefaultTableModel getTableContents(){
        ArrayList<Alumno> alumnos = modc.listarAlumnosClase(user);
        
        if(alumnos != null){
            String[] tableHeaders = {"nombre", "apellidos"};
            Object[][] tableContents = new Object[alumnos.size()][tableHeaders.length];
            
            for(int i = 0; i < alumnos.size(); i++){
                tableContents[i][0] = alumnos.get(i).getNombre();
                tableContents[i][1] = alumnos.get(i).getApellidos();
            }
            return new DefaultTableModel(tableContents, tableHeaders);
        }
        return new DefaultTableModel();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {    
        if(e.getSource() == frame.jButton_volver){
            ControladorC10 con = new ControladorC10(new P10_VistaAlumno(), user);
            con.iniciar();
            frame.dispose();
        }
    }
    
}
