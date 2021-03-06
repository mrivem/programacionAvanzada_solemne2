package com.teamsolemne.pa_solemne2.vista;

public class P10_VistaAlumno extends javax.swing.JFrame {

    public P10_VistaAlumno() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_body = new javax.swing.JPanel();
        jLabel_titulo = new javax.swing.JLabel();
        jButton_cerrarSesion = new javax.swing.JButton();
        jPanel_opciones = new javax.swing.JPanel();
        jButton_listarCompaneros = new javax.swing.JButton();
        jButton_listarProfesores = new javax.swing.JButton();
        jButton_consultarNotas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_titulo.setText("Portal del alumno");

        jButton_cerrarSesion.setText("Cerrar sesión");

        jPanel_opciones.setLayout(new javax.swing.BoxLayout(jPanel_opciones, javax.swing.BoxLayout.PAGE_AXIS));

        jButton_listarCompaneros.setText("Listar mis compañeros de clase");
        jButton_listarCompaneros.setMaximumSize(new java.awt.Dimension(500, 28));
        jPanel_opciones.add(jButton_listarCompaneros);

        jButton_listarProfesores.setText("Listar mis profesores");
        jButton_listarProfesores.setMaximumSize(new java.awt.Dimension(500, 28));
        jPanel_opciones.add(jButton_listarProfesores);

        jButton_consultarNotas.setText("Consultar mis notas");
        jButton_consultarNotas.setMaximumSize(new java.awt.Dimension(500, 28));
        jPanel_opciones.add(jButton_consultarNotas);

        javax.swing.GroupLayout jPanel_bodyLayout = new javax.swing.GroupLayout(jPanel_body);
        jPanel_body.setLayout(jPanel_bodyLayout);
        jPanel_bodyLayout.setHorizontalGroup(
            jPanel_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_bodyLayout.createSequentialGroup()
                        .addComponent(jButton_cerrarSesion)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel_bodyLayout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(jPanel_opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel_bodyLayout.setVerticalGroup(
            jPanel_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_titulo)
                .addGap(18, 18, 18)
                .addComponent(jPanel_opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addComponent(jButton_cerrarSesion))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(P10_VistaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(P10_VistaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(P10_VistaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(P10_VistaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new P10_VistaAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton_cerrarSesion;
    public javax.swing.JButton jButton_consultarNotas;
    public javax.swing.JButton jButton_listarCompaneros;
    public javax.swing.JButton jButton_listarProfesores;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JPanel jPanel_body;
    private javax.swing.JPanel jPanel_opciones;
    // End of variables declaration//GEN-END:variables
}
