package com.teamsolemne.pa_solemne2.controlador;

import com.teamsolemne.pa_solemne2.modelo.Alumno;
import com.teamsolemne.pa_solemne2.modelo.OperacionesAlumno;
import com.teamsolemne.pa_solemne2.modelo.Profesor;
import com.teamsolemne.pa_solemne2.vista.P10_VistaAlumno;
import com.teamsolemne.pa_solemne2.vista.P40_ListaCompartida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class ControladorC12 implements ActionListener {
    
    private final P40_ListaCompartida frame;
    private final Alumno user;
    private final OperacionesAlumno modc = new OperacionesAlumno();

    public ControladorC12(P40_ListaCompartida frame, Alumno user) {
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
        
        frame.jLabel_titulo.setText(String.format("Lista de profesores del alumno %s %s", user.getNombre(), user.getApellidos()));
        frame.jTable_lista.setModel(getTableContents());
        frame.jButton_volver.setText("Volver");
        frame.jButton_consultarSeleccionado.setVisible(false);
    }
    
    private DefaultTableModel getTableContents(){
        Object[] dataPack = modc.listarProfesores(user);
        
        if (dataPack == null) return new DefaultTableModel();
        
        ArrayList<Profesor> profesores = (ArrayList<Profesor>) dataPack[0];
        ArrayList<String> nombresAsignaturas = (ArrayList<String>) dataPack[1];
        
        if(profesores != null){
            String[] tableHeaders = {"nombre", "apellidos", "asignatura"};
            Object[][] tableContents = new Object[profesores.size()][tableHeaders.length];
            
            for(int i = 0; i < profesores.size(); i++){
                tableContents[i][0] = profesores.get(i).getNombre();
                tableContents[i][1] = profesores.get(i).getApellidos();
                tableContents[i][2] = nombresAsignaturas.get(i);
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
