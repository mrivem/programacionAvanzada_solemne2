package com.teamsolemne.pa_solemne2.controlador;

import com.teamsolemne.pa_solemne2.modelo.Alumno;
import com.teamsolemne.pa_solemne2.modelo.Asignatura;
import com.teamsolemne.pa_solemne2.modelo.OperacionesAlumno;
import com.teamsolemne.pa_solemne2.vista.P10_VistaAlumno;
import com.teamsolemne.pa_solemne2.vista.P40_ListaCompartida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class ControladorC13 implements ActionListener {
    
    private final P40_ListaCompartida frame;
    private final Alumno user;
    private final OperacionesAlumno modc = new OperacionesAlumno();
    
    private Asignatura asignaturaSeleccionada;
    private ArrayList<Asignatura> asignaturas;

    public ControladorC13(P40_ListaCompartida frame, Alumno user) {
        this.frame = frame;
        this.user = user;
        setListeners();
    }
    
    private void setListeners(){
        frame.jButton_volver.addActionListener(this);
        frame.jButton_consultarSeleccionado.addActionListener(this);
        frame.jTable_lista.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if(e.getValueIsAdjusting()) return;
            
            frame.jButton_consultarSeleccionado.setEnabled(true);
            
            asignaturaSeleccionada = asignaturas.get(frame.jTable_lista.getSelectedRow());
        });
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Lista de asignaturas");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        frame.jLabel_titulo.setText(String.format("Lista de asignaturas del alumno %s %s", user.getNombre(), user.getApellidos()));
        frame.jTable_lista.setModel(getTableContents());
        frame.jButton_volver.setText("Volver");
        frame.jButton_consultarSeleccionado.setText("Consultar seleccionado");
        frame.jButton_consultarSeleccionado.setEnabled(false);
    }
    
    private DefaultTableModel getTableContents(){
        asignaturas = modc.listarAsignaturas(user);
        
        
        if(asignaturas != null){
            String[] tableHeaders = {"nombre"};
            Object[][] tableContents = new Object[asignaturas.size()][tableHeaders.length];
            
            for(int i = 0; i < asignaturas.size(); i++){
                tableContents[i][0] = asignaturas.get(i).getNombre();
            }
            return new DefaultTableModel(tableContents, tableHeaders);
        }
        return new DefaultTableModel();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {    
        if(e.getSource() == frame.jButton_consultarSeleccionado){
            ControladorC14 con = new ControladorC14(new P40_ListaCompartida(), user, asignaturaSeleccionada);
            con.iniciar();
        }
        
        if(e.getSource() == frame.jButton_volver){
            ControladorC10 con = new ControladorC10(new P10_VistaAlumno(), user);
            con.iniciar();
            frame.dispose();
        }
    }
    
}
