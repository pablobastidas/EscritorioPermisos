package appadministrador;

import Conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ines Muñoz
 *
 */
public class FormLogin extends javax.swing.JFrame {

    Connection conn;
    Statement sent;

    public FormLogin() {
        initComponents();

        this.setLocationRelativeTo(null);
    }

    void Limpiar() {
        this.tfUsuario.setText("");
        this.tfPassword.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        btIngresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfPassword = new javax.swing.JPasswordField();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MUNICIPALIDAD DE VISTA HERMOSA");
        setPreferredSize(new java.awt.Dimension(600, 550));
        setSize(new java.awt.Dimension(700, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Ilustre Municipalidad de Vista Hermosa");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        tfUsuario.setToolTipText("");
        getContentPane().add(tfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 200, -1));
        tfUsuario.getAccessibleContext().setAccessibleName("");

        btIngresar.setBackground(new java.awt.Color(66, 139, 202));
        btIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btIngresar.setText("Ingresar");
        btIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 200, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Usuario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Contraseña");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/logo .png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 175, 153));
        getContentPane().add(tfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 200, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarActionPerformed

        try {
            conn = conexion.getConexion();
            String sql = "select id_rol from funcionario where rut='" + this.tfUsuario.getText() + "' AND password ='" + this.tfPassword.getText() + "'";

            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);

//rs.getString("id_rol")!=null
            if (rs.next()) {
                String rol = rs.getString("id_rol");
                if (rol.equals("1")) {
                    FormAdministrador a = new FormAdministrador();
                    a.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usted no es Administrador!\n Su acceso es por Web");
                    Limpiar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe el usuario");
                Limpiar();
            }
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
