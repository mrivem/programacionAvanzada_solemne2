package com.teamsolemne.pa_solemne2.controlador;

import com.teamsolemne.pa_solemne2.modelo.Asignatura;
import com.teamsolemne.pa_solemne2.modelo.OperacionesProfesores;
import com.teamsolemne.pa_solemne2.modelo.Profesor;
import com.teamsolemne.pa_solemne2.vista.P20_VistaProfesor;
import com.teamsolemne.pa_solemne2.vista.P40_ListaCompartida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class ControladorC22 implements ActionListener {
    
    private final P40_ListaCompartida frame;
    private final Profesor user;
    private final OperacionesProfesores modc = new OperacionesProfesores();
    
    private Asignatura asignaturaSeleccionada;
    private ArrayList<Asignatura> asignaturas;

    public ControladorC22(P40_ListaCompartida frame, Profesor user) {
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
        
        frame.jLabel_titulo.setText(String.format("Lista de asignaturas del profesor %s %s", user.getNombre(), user.getApellidos()));
        frame.jTable_lista.setModel(getTableContents());
        frame.jButton_volver.setText("Volver");
        frame.jButton_consultarSeleccionado.setText("Ver listado de alumnos");
        frame.jButton_consultarSeleccionado.setEnabled(false);
    }
    
    private DefaultTableModel getTableContents(){
        asignaturas = modc.listarAsignaturasProfesor(user);
        
        
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
            ControladorC23 con = new ControladorC23(new P40_ListaCompartida(), user, asignaturaSeleccionada);
            con.iniciar();
        }
        
        if(e.getSource() == frame.jButton_volver){
            ControladorC20 con = new ControladorC20(new P20_VistaProfesor(), user);
            con.iniciar();
            frame.dispose();
        }
    }
    
}
