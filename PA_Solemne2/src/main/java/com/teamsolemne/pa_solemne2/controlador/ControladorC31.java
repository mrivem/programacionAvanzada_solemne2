package com.teamsolemne.pa_solemne2.controlador;

import com.teamsolemne.pa_solemne2.modelo.Alumno;
import com.teamsolemne.pa_solemne2.modelo.OperacionesAlumno;
import com.teamsolemne.pa_solemne2.modelo.OperacionesAuxiliares;
import com.teamsolemne.pa_solemne2.vista.P31_CrearAlumno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControladorC31 implements ActionListener {
    
    private final P31_CrearAlumno frame;
    private final OperacionesAlumno modc = new OperacionesAlumno();
    private final OperacionesAuxiliares modaux = new OperacionesAuxiliares();

    public ControladorC31(P31_CrearAlumno frame) {
        this.frame = frame;
        setListeners();
    }
    
    private void setListeners(){
        frame.jButton_registrar.addActionListener(this);
        frame.jButton_cancelar.addActionListener(this);
        frame.jComboBox1.addActionListener(this);
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Registrar Alumno");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        frame.jComboBox1.setModel(new DefaultComboBoxModel<>(modaux.getNiveles()));
        frame.jComboBox1.setSelectedIndex(0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {    
        if(e.getSource() == frame.jButton_registrar){
            int nivel = Integer.parseInt(frame.jComboBox1.getSelectedItem().toString());
            String login = frame.jTextField_login.getText();
            String clave = frame.jTextField_clave.getText();
            String nombre = frame.jTextField_nombre.getText();
            String apellidos = frame.jTextField_apellidos.getText();

            if(login.length() == 0) JOptionPane.showMessageDialog(frame, "El campo login no puede quedar en blanco", "ERROR", JOptionPane.ERROR_MESSAGE);
            if(clave.length() == 0) JOptionPane.showMessageDialog(frame, "El campo clave no puede quedar en blanco", "ERROR", JOptionPane.ERROR_MESSAGE);
            if(nombre.length() == 0) JOptionPane.showMessageDialog(frame, "El campo nombre no puede quedar en blanco", "ERROR", JOptionPane.ERROR_MESSAGE);
            if(apellidos.length() == 0) JOptionPane.showMessageDialog(frame, "El campo apellidos no puede quedar en blanco", "ERROR", JOptionPane.ERROR_MESSAGE);

            modc.registrarAlumno(new Alumno(-1, nivel, login, clave, nombre, apellidos));

            frame.dispose();
            JOptionPane.showMessageDialog(frame, "Alumno registrado con exito!");        
        }
        
        if(e.getSource() == frame.jButton_cancelar){
            frame.dispose();
        }
    }
    
}
