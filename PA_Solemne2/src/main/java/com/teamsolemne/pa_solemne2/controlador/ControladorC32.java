package com.teamsolemne.pa_solemne2.controlador;

import com.teamsolemne.pa_solemne2.modelo.Alumno;
import com.teamsolemne.pa_solemne2.modelo.OperacionesAlumno;
import com.teamsolemne.pa_solemne2.vista.P32_BuscarAlumno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControladorC32 implements ActionListener {
    
    private final P32_BuscarAlumno frame;
    private final OperacionesAlumno modc = new OperacionesAlumno();

    public ControladorC32(P32_BuscarAlumno frame) {
        this.frame = frame;
        setListeners();
    }
    
    private void setListeners(){
        frame.jButton_buscar.addActionListener(this);
        frame.jButton_actualizar.addActionListener(this);
        frame.jButton_eliminar.addActionListener(this);
        frame.jButton_cerrar.addActionListener(this);
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Buscar Alumno");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {    
        if(e.getSource() == frame.jButton_buscar){
            try {
                int id = Integer.parseInt(frame.jTextField_id.getText());
                Alumno al = modc.buscarAlumno(id);
                
                if(al != null){
                    frame.jTextField_nivel.setText(al.getNivel_id() + "");
                    frame.jTextField_login.setText(al.getLogin());
                    frame.jTextField_clave.setText(al.getClave());
                    frame.jTextField_nombre.setText(al.getNombre());
                    frame.jTextField_apellidos.setText(al.getApellidos());
                    JOptionPane.showMessageDialog(frame, "Alumno encontrado con exito!");   
                } else JOptionPane.showMessageDialog(frame, "Alumno no encontrado :c");  
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "ID no reconocido como número");
            }
                 
        }
        
        if(e.getSource() == frame.jButton_actualizar){
            try {
                int id = Integer.parseInt(frame.jTextField_id.getText());
                int nivel = Integer.parseInt(frame.jTextField_nivel.getText());
                
                String login = frame.jTextField_login.getText();
                String clave = frame.jTextField_clave.getText();
                String nombre = frame.jTextField_nombre.getText();
                String apellidos = frame.jTextField_apellidos.getText();
                
                if(frame.jTextField_id.getText().length() == 0) JOptionPane.showMessageDialog(frame, "El campo id no puede quedar en blanco", "ERROR", JOptionPane.ERROR_MESSAGE);
                if(frame.jTextField_nivel.getText().length() == 0) JOptionPane.showMessageDialog(frame, "El campo nivel no puede quedar en blanco", "ERROR", JOptionPane.ERROR_MESSAGE);
                if(login.length() == 0) JOptionPane.showMessageDialog(frame, "El campo login no puede quedar en blanco", "ERROR", JOptionPane.ERROR_MESSAGE);
                if(clave.length() == 0) JOptionPane.showMessageDialog(frame, "El campo clave no puede quedar en blanco", "ERROR", JOptionPane.ERROR_MESSAGE);
                if(nombre.length() == 0) JOptionPane.showMessageDialog(frame, "El campo nombre no puede quedar en blanco", "ERROR", JOptionPane.ERROR_MESSAGE);
                if(apellidos.length() == 0) JOptionPane.showMessageDialog(frame, "El campo apellidos no puede quedar en blanco", "ERROR", JOptionPane.ERROR_MESSAGE);
                
                modc.modificarAlumno(new Alumno(id, nivel, login, clave, nombre, apellidos));
                JOptionPane.showMessageDialog(frame, "Alumno modificado con exito!");
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "ID o nivel no reconocido como número");
            }
        }
        
        if(e.getSource() == frame.jButton_eliminar){
            try {
                int id = Integer.parseInt(frame.jTextField_id.getText());
                modc.eliminarAlumno(id);
                JOptionPane.showMessageDialog(frame, "Alumno eliminado con exito!");
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "ID o nivel no reconocido como número");
            }
        }
        
        if(e.getSource() == frame.jButton_cerrar){
            frame.dispose();
        }
    }
    
}
