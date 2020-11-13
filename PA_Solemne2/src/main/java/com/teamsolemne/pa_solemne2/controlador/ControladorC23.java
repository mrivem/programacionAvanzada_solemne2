package com.teamsolemne.pa_solemne2.controlador;

import com.teamsolemne.pa_solemne2.modelo.Alumno;
import com.teamsolemne.pa_solemne2.modelo.Asignatura;
import com.teamsolemne.pa_solemne2.modelo.OperacionesProfesores;
import com.teamsolemne.pa_solemne2.modelo.Profesor;
import com.teamsolemne.pa_solemne2.vista.P20_VistaProfesor;
import com.teamsolemne.pa_solemne2.vista.P21_AsignarNota;
import com.teamsolemne.pa_solemne2.vista.P40_ListaCompartida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class ControladorC23 implements ActionListener {
    
    private final P40_ListaCompartida frame;
    private final Profesor user;
    private final Asignatura ass;
    private final OperacionesProfesores modc = new OperacionesProfesores();
    
    private Alumno alumnoSeleccionado;
    private ArrayList<Alumno> alumnos;

    public ControladorC23(P40_ListaCompartida frame, Profesor user, Asignatura ass) {
        this.frame = frame;
        this.user = user;
        this.ass = ass;
        setListeners();
    }
    
    private void setListeners(){
        frame.jButton_volver.addActionListener(this);
        frame.jButton_consultarSeleccionado.addActionListener(this);
        frame.jTable_lista.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if(e.getValueIsAdjusting()) return;
            
            frame.jButton_consultarSeleccionado.setEnabled(true);
            
            alumnoSeleccionado = alumnos.get(frame.jTable_lista.getSelectedRow());
        });
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Lista de alumnos de la asignatura");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        frame.jLabel_titulo.setText(String.format("Lista de alumnos de la asignatura %s", ass.getNombre()));
        frame.jTable_lista.setModel(getTableContents());
        frame.jButton_volver.setText("Volver");
        frame.jButton_consultarSeleccionado.setText("Asignar nota a alumno");
        frame.jButton_consultarSeleccionado.setEnabled(false);
    }
    
    private DefaultTableModel getTableContents(){
        alumnos = modc.listarAlumnosAsignatura(ass);
        
        
        if(alumnos != null){
            String[] tableHeaders = {"nombre"};
            Object[][] tableContents = new Object[alumnos.size()][tableHeaders.length];
            
            for(int i = 0; i < alumnos.size(); i++){
                tableContents[i][0] = alumnos.get(i).getNombre();
            }
            return new DefaultTableModel(tableContents, tableHeaders);
        }
        return new DefaultTableModel();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {    
        if(e.getSource() == frame.jButton_consultarSeleccionado){
            ControladorC24 con = new ControladorC24(new P21_AsignarNota(), alumnoSeleccionado, ass);
            con.iniciar();
        }
        
        if(e.getSource() == frame.jButton_volver){
            frame.dispose();
        }
    }
    
}
