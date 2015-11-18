package FHW;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Jhon
 */
public class GuiFHW extends javax.swing.JFrame {

    /**
     * Creates new form GuiRedPersonal
     */
    public GuiFHW() {
        initComponents();
        setLocationRelativeTo(null);
        txtAreaSalida.setText("");
        txtAreaSalida.append("\n\t\t\t            **BIENVENIDO A FREE HOTSPOT WI-FI**\n\n" +
"\t     El Propósito principal de este proyecto es facilitar de forma totalmente gratuita y sin animo de lucro\n\t     la conexión de dispositivos móviles " +
"a internet por medio de la conexion de nuestro computador ya sea\n\t     una computadora portátil o un equipo de escritorio que cuente con un adaptador de red inalámbrica.");

    }

    static FHWMethods rp;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNombreRed = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtClaveRed = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnIniciarRedVirtual = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaSalida = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnHabilitarAdaptador = new javax.swing.JButton();
        btnAADR = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtNombreRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 250, -1));

        jLabel1.setFont(new java.awt.Font("Bauhaus 93", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre De La Red");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 130, -1));
        jPanel1.add(txtClaveRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 250, -1));

        jLabel2.setFont(new java.awt.Font("Bauhaus 93", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Clave de la Red");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 130, -1));

        btnIniciarRedVirtual.setText("Iniciar Red Virtual");
        btnIniciarRedVirtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarRedVirtualActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciarRedVirtual, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 180, 40));

        txtAreaSalida.setColumns(20);
        txtAreaSalida.setRows(5);
        jScrollPane1.setViewportView(txtAreaSalida);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 820, 250));

        jLabel4.setFont(new java.awt.Font("Bauhaus 93", 0, 26)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("FREE HOTSPOT WI-FI ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 340, -1));

        btnHabilitarAdaptador.setText("Habilitar Adaptador");
        btnHabilitarAdaptador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabilitarAdaptadorActionPerformed(evt);
            }
        });
        jPanel1.add(btnHabilitarAdaptador, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 180, 40));

        btnAADR.setText("Administrar Adaptadores de Red");
        btnAADR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAADRActionPerformed(evt);
            }
        });
        jPanel1.add(btnAADR, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 230, 40));

        jLabel8.setFont(new java.awt.Font("Bauhaus 93", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("V:1.0 By Jota31337");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 490, 270, -1));

        jLabel6.setFont(new java.awt.Font("Bauhaus 93", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Contraseña por defecto: clave1234");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 240, 20));

        jLabel9.setFont(new java.awt.Font("Bauhaus 93", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Contraseña por defecto: clave1234");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 240, 20));

        jLabel10.setFont(new java.awt.Font("Bauhaus 93", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nombre de red por defecto: Default");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 240, -1));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rsz_bg.png"))); // NOI18N
        jPanel1.add(lblIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarRedVirtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarRedVirtualActionPerformed
        rp = new FHWMethods();

        String nombre = "Default";
        String clave = "clave1234";
        if (txtNombreRed.getText().split(" ").length > 0) {
            txtNombreRed.setText(txtNombreRed.getText().replace(" ", "_"));
            nombre = txtNombreRed.getText();
        }
        if (txtClaveRed.getText().split(" ").length > 0) {
            clave = txtClaveRed.getText();
        }
        if (rp.validarSistemaOperativo(txtAreaSalida) == true) {

            rp.iniciarRed(nombre,clave,txtAreaSalida);
            txtClaveRed.setText("");
            txtNombreRed.setText("");
        }

    }//GEN-LAST:event_btnIniciarRedVirtualActionPerformed

    private void btnHabilitarAdaptadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabilitarAdaptadorActionPerformed
        if (rp.validarSistemaOperativo(txtAreaSalida) == true) {

            rp.habilitarAdaptador(txtAreaSalida);

        }
    }//GEN-LAST:event_btnHabilitarAdaptadorActionPerformed

    private void btnAADRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAADRActionPerformed

        if (rp.validarSistemaOperativo(txtAreaSalida) == true) {
            rp.compartir();

        }
    }//GEN-LAST:event_btnAADRActionPerformed

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
                    rp.look();
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiFHW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiFHW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiFHW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiFHW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/icono1.png"));

                GuiFHW g = new GuiFHW();
                g.setIconImage(icon);
                g.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAADR;
    private javax.swing.JButton btnHabilitarAdaptador;
    private javax.swing.JButton btnIniciarRedVirtual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JTextArea txtAreaSalida;
    private javax.swing.JTextField txtClaveRed;
    private javax.swing.JTextField txtNombreRed;
    // End of variables declaration//GEN-END:variables
}
