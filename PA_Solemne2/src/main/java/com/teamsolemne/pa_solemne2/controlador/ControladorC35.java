package com.teamsolemne.pa_solemne2.controlador;

import com.teamsolemne.pa_solemne2.modelo.Alumno;
import com.teamsolemne.pa_solemne2.modelo.Asignatura;
import com.teamsolemne.pa_solemne2.modelo.OperacionesAlumno;
import com.teamsolemne.pa_solemne2.modelo.OperacionesAuxiliares;
import com.teamsolemne.pa_solemne2.vista.P35_MatricularAlumno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControladorC35 implements ActionListener {
    
    private final P35_MatricularAlumno frame;
    private final OperacionesAlumno modc = new OperacionesAlumno();
    private final OperacionesAuxiliares modaux = new OperacionesAuxiliares();

    public ControladorC35(P35_MatricularAlumno frame) {
        this.frame = frame;
        setListeners();
    }
    
    private void setListeners(){
        frame.jButton_registrar.addActionListener(this);
        frame.jButton_cancelar.addActionListener(this);
        frame.jComboBox_alumno.addActionListener(this);
        frame.jComboBox_asignatura.addActionListener(this);
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Matricular Alumno");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        frame.jComboBox_alumno.setModel(new DefaultComboBoxModel<>(modaux.getAlumnos()));
        frame.jComboBox_alumno.setSelectedIndex(0);
        
        frame.jComboBox_asignatura.setModel(new DefaultComboBoxModel<>(modaux.getAsignaturas()));
        frame.jComboBox_asignatura.setSelectedIndex(0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {    
        if(e.getSource() == frame.jButton_registrar){
            String s = frame.jComboBox_alumno.getSelectedItem().toString().split(" - ")[0];
            int id_alumno = Integer.parseInt(s);
            s = frame.jComboBox_asignatura.getSelectedItem().toString().split(" - ")[0];
            int id_asignatura = Integer.parseInt(s);

            modc.matricularAlumno(
                    new Alumno(id_alumno, -1, "", "", "", ""),
                    new Asignatura(id_asignatura, -1, -1, "")
            );

            frame.dispose();
            JOptionPane.showMessageDialog(frame, "Alumno matriculado con exito!");        
        }
        
        if(e.getSource() == frame.jButton_cancelar){
            frame.dispose();
        }
    }
    
}
