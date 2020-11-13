package com.teamsolemne.pa_solemne2.controlador;

import com.teamsolemne.pa_solemne2.modelo.Alumno;
import com.teamsolemne.pa_solemne2.modelo.Asignatura;
import com.teamsolemne.pa_solemne2.modelo.Nota;
import com.teamsolemne.pa_solemne2.modelo.OperacionesAlumno;
import com.teamsolemne.pa_solemne2.vista.P10_VistaAlumno;
import com.teamsolemne.pa_solemne2.vista.P40_ListaCompartida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class ControladorC14 implements ActionListener {
    
    private final P40_ListaCompartida frame;
    private final Alumno user;
    private final Asignatura ass;
    private final OperacionesAlumno modc = new OperacionesAlumno();

    public ControladorC14(P40_ListaCompartida frame, Alumno user, Asignatura ass) {
        this.frame = frame;
        this.user = user;
        this.ass = ass;
        setListeners();
    }
    
    private void setListeners(){
        frame.jButton_volver.addActionListener(this);
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Listado de notas");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        frame.jLabel_titulo.setText(String.format("Listado de notas del alumno %s %s en la asignatura %s", user.getNombre(), user.getApellidos(), ass.getNombre()));
        frame.jTable_lista.setModel(getTableContents());
        frame.jButton_volver.setText("Volver");
        frame.jButton_consultarSeleccionado.setVisible(false);
    }
    
    private DefaultTableModel getTableContents(){
        ArrayList<Nota> notas = modc.listarNotasAsignatura(user, ass);
        
        if(notas != null){
            String[] tableHeaders = {"trimestre", "nota"};
            Object[][] tableContents = new Object[notas.size()][tableHeaders.length];
            
            for(int i = 0; i < notas.size(); i++){
                tableContents[i][0] = notas.get(i).getTrimestre();
                tableContents[i][1] = notas.get(i).getNota();
            }
            return new DefaultTableModel(tableContents, tableHeaders);
        }
        return new DefaultTableModel();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {    
        if(e.getSource() == frame.jButton_volver){
            frame.dispose();
        }
    }
    
}
