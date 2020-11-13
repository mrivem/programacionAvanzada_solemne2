package com.teamsolemne.pa_solemne2.controlador;

import com.teamsolemne.pa_solemne2.modelo.Alumno;
import com.teamsolemne.pa_solemne2.modelo.Asignatura;
import com.teamsolemne.pa_solemne2.modelo.OperacionesAsignatura;
import com.teamsolemne.pa_solemne2.vista.P34_BuscarAsignatura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControladorC34 implements ActionListener {
    
    private final P34_BuscarAsignatura frame;
    private final OperacionesAsignatura modc = new OperacionesAsignatura();

    public ControladorC34(P34_BuscarAsignatura frame) {
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
        frame.setTitle("Buscar Asignatura");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {    
        if(e.getSource() == frame.jButton_buscar){
            try {
                int id = Integer.parseInt(frame.jTextField_id.getText());
                Asignatura as = modc.buscarAsignatura(id);
                
                if(as != null){
                    frame.jTextField_nivel.setText(as.getNivel_id() + "");
                    frame.jTextField_idProfesor.setText(as.getProfesor_id() + "");
                    frame.jTextField_nombre.setText(as.getNombre());
                    JOptionPane.showMessageDialog(frame, "Asignatura encontrada con exito!");   
                } else JOptionPane.showMessageDialog(frame, "Asignatura no encontrada :c");  
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "ID no reconocido como número");
            }
                 
        }
        
        if(e.getSource() == frame.jButton_actualizar){
            try {
                int id = Integer.parseInt(frame.jTextField_id.getText());
                int nivel = Integer.parseInt(frame.jTextField_nivel.getText());
                int id_profe = Integer.parseInt(frame.jTextField_idProfesor.getText());
                String nombre = frame.jTextField_nombre.getText();
                
                if(frame.jTextField_id.getText().length() == 0) JOptionPane.showMessageDialog(frame, "El campo id no puede quedar en blanco", "ERROR", JOptionPane.ERROR_MESSAGE);
                if(frame.jTextField_nivel.getText().length() == 0) JOptionPane.showMessageDialog(frame, "El campo nivel no puede quedar en blanco", "ERROR", JOptionPane.ERROR_MESSAGE);
                if(frame.jTextField_idProfesor.getText().length() == 0) JOptionPane.showMessageDialog(frame, "El campo nivel no puede quedar en blanco", "ERROR", JOptionPane.ERROR_MESSAGE);
                if(nombre.length() == 0) JOptionPane.showMessageDialog(frame, "El campo nombre no puede quedar en blanco", "ERROR", JOptionPane.ERROR_MESSAGE);
                
                modc.modificarAsignatura(new Asignatura(id, nivel, id_profe, nombre));
                JOptionPane.showMessageDialog(frame, "Asignatura modificada con exito!");
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "ID, nivel o idProfesor no reconocido como número");
            }
        }
        
        if(e.getSource() == frame.jButton_eliminar){
            try {
                int id = Integer.parseInt(frame.jTextField_id.getText());
                modc.eliminarAsignatura(id);
                JOptionPane.showMessageDialog(frame, "Asignatura eliminada con exito!");
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "ID no reconocido como número");
            }
        }
        
        if(e.getSource() == frame.jButton_cerrar){
            frame.dispose();
        }
    }
    
}
