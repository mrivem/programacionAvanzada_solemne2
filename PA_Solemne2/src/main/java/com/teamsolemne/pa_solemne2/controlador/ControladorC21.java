package com.teamsolemne.pa_solemne2.controlador;

import com.teamsolemne.pa_solemne2.modelo.OperacionesProfesores;
import com.teamsolemne.pa_solemne2.modelo.Profesor;
import com.teamsolemne.pa_solemne2.vista.P20_VistaProfesor;
import com.teamsolemne.pa_solemne2.vista.P40_ListaCompartida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class ControladorC21 implements ActionListener {
    
    private final P40_ListaCompartida frame;
    private final Profesor user;
    private final OperacionesProfesores modc = new OperacionesProfesores();

    public ControladorC21(P40_ListaCompartida frame, Profesor user) {
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
        frame.setTitle("Lista de profesores");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        frame.jLabel_titulo.setText(String.format("Lista de profesores del colegio"));
        frame.jTable_lista.setModel(getTableContents());
        frame.jButton_volver.setText("Volver");
        frame.jButton_consultarSeleccionado.setVisible(false);
    }
    
    private DefaultTableModel getTableContents(){
        ArrayList<Profesor> profesores = modc.listarProfesores();
        
        if(profesores != null){
            String[] tableHeaders = {"nombre", "apellidos", "email"};
            Object[][] tableContents = new Object[profesores.size()][tableHeaders.length];
            
            for(int i = 0; i < profesores.size(); i++){
                tableContents[i][0] = profesores.get(i).getNombre();
                tableContents[i][1] = profesores.get(i).getApellidos();
                tableContents[i][2] = profesores.get(i).getEmail();
            }
            return new DefaultTableModel(tableContents, tableHeaders);
        }
        return new DefaultTableModel();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {    
        if(e.getSource() == frame.jButton_volver){
            ControladorC20 con = new ControladorC20(new P20_VistaProfesor(), user);
            con.iniciar();
            frame.dispose();
        }
    }
    
}
