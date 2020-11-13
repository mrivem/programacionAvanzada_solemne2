package com.teamsolemne.pa_solemne2.controlador;

import com.teamsolemne.pa_solemne2.modelo.Alumno;
import com.teamsolemne.pa_solemne2.modelo.Asignatura;
import com.teamsolemne.pa_solemne2.modelo.Nota;
import com.teamsolemne.pa_solemne2.modelo.OperacionesProfesores;
import com.teamsolemne.pa_solemne2.vista.P21_AsignarNota;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class ControladorC24 implements ActionListener, ChangeListener {
    
    private final P21_AsignarNota frame;
    private final Alumno alumno;
    private final Asignatura ass;
    private final OperacionesProfesores modc = new OperacionesProfesores();
    
    private int trimestre = 1;

    public ControladorC24(P21_AsignarNota frame, Alumno alumno, Asignatura ass) {
        this.frame = frame;
        this.alumno = alumno;
        this.ass = ass;
        setListeners();
    }
    
    private void setListeners(){
        frame.jButton_asignarNota.addActionListener(this);
        frame.jButton_cancelar.addActionListener(this);
        frame.jSpinner_trimestre.addChangeListener(this);
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Asignar nota a alumno");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        frame.jSpinner_trimestre.setValue(trimestre);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {    
        if(e.getSource() == frame.jButton_asignarNota){
            try {
                double nota = Double.parseDouble(frame.jTextField_nota.getText());
                modc.agregarNota(new Nota(0, alumno.getId(), ass.getId(), trimestre, nota));
                
                frame.dispose();
                JOptionPane.showMessageDialog(frame, "Nota asignada con exito!");
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "La nota introducida no se reconoce como número", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (NullPointerException ex){
                JOptionPane.showMessageDialog(frame, "Debe llenar el campo de nota", "ERROR", JOptionPane.ERROR_MESSAGE);
            }            
        }
        
        if(e.getSource() == frame.jButton_cancelar){
            frame.dispose();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == frame.jSpinner_trimestre){
            int val = (int) frame.jSpinner_trimestre.getValue();
            if (val > 4) val = 4;
            else if (val < 1) val = 1;
            trimestre = val;
            frame.jSpinner_trimestre.setValue(trimestre);
        }
    }
    
}
