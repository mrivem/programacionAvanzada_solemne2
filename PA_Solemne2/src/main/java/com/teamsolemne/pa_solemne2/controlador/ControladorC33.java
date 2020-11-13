package com.teamsolemne.pa_solemne2.controlador;

import com.teamsolemne.pa_solemne2.modelo.Asignatura;
import com.teamsolemne.pa_solemne2.modelo.OperacionesAsignatura;
import com.teamsolemne.pa_solemne2.modelo.OperacionesAuxiliares;
import com.teamsolemne.pa_solemne2.vista.P33_CrearAsignatura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControladorC33 implements ActionListener {
    
    private final P33_CrearAsignatura frame;
    private final OperacionesAsignatura modc = new OperacionesAsignatura();
    private final OperacionesAuxiliares modaux = new OperacionesAuxiliares();

    public ControladorC33(P33_CrearAsignatura frame) {
        this.frame = frame;
        setListeners();
    }
    
    private void setListeners(){
        frame.jButton_registrar.addActionListener(this);
        frame.jButton_cancelar.addActionListener(this);
        frame.jComboBox_nivel.addActionListener(this);
        frame.jComboBox_profesor.addActionListener(this);
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Registrar Asignatura");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        frame.jComboBox_nivel.setModel(new DefaultComboBoxModel<>(modaux.getNiveles()));
        frame.jComboBox_nivel.setSelectedIndex(0);
        
        frame.jComboBox_profesor.setModel(new DefaultComboBoxModel<>(modaux.getProfesores()));
        frame.jComboBox_profesor.setSelectedIndex(0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {    
        if(e.getSource() == frame.jButton_registrar){
            int nivel = Integer.parseInt(frame.jComboBox_nivel.getSelectedItem().toString());
            
            String s = frame.jComboBox_profesor.getSelectedItem().toString().split(" - ")[0];
            int id_profesor = Integer.parseInt(s);
            
            String nombre = frame.jTextField_nombre.getText();


            if(nombre.length() == 0) JOptionPane.showMessageDialog(frame, "El campo nombre no puede quedar en blanco", "ERROR", JOptionPane.ERROR_MESSAGE);

            modc.registrarAsignatura(new Asignatura(-1, nivel, id_profesor, nombre));

            frame.dispose();
            JOptionPane.showMessageDialog(frame, "Asignatura registrada con exito!");        
        }
        
        if(e.getSource() == frame.jButton_cancelar){
            frame.dispose();
        }
    }
    
}
