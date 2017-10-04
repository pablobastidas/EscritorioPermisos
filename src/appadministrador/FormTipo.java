package appadministrador;

import javax.swing.table.DefaultTableModel;
import Conexion.conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Inés Muñoz
 */
public class FormTipo extends javax.swing.JFrame {

    DefaultTableModel model;
    Connection conn;
    Statement sent;

    private static FormTipo instance1;

    public static FormTipo getInstance1() {
        if (instance1 == null) {
            instance1 = new FormTipo();
        }
        return instance1;
    }

    private FormTipo() {
        initComponents();
        setLocationRelativeTo(null);
        Deshabilitar();
        conn = conexion.getConexion();
        llenar();

    }

    void Deshabilitar() {
        this.tfDescripcionTP.setEditable(false);
        this.tfCantidadTP.setEditable(false);
    }

    void Limpiar() {
        this.tfDescripcionTP.setText("");
        this.tfCantidadTP.setText("");
    }

    void Habilitar() {
        this.tfDescripcionTP.setEditable(true);
        this.tfCantidadTP.setEditable(true);
        this.tfDescripcionTP.requestFocus();
    }

    //Validar Campos del Formulario
    private boolean ValidarCampos() {
        if (!this.tfDescripcionTP.getText().equals("") && !this.tfCantidadTP.getText().equals("")) {
            return true;
        }
        return false;
    }

    void llenar() {
        try {
            conn = conexion.getConexion();
            String[] titulos = {"Id Tipo", "Descripcion Tipo", "cantidad dias", "Fecha Creación", "Fecha Modificacion", "estado"};
            String sql = "select * from tipo_solicitud";
            model = new DefaultTableModel(null, titulos);
            sent = conn.createStatement();

            ResultSet rs = sent.executeQuery(sql);

            String[] fila = new String[6];

            while (rs.next()) {
                if (rs.getString("estado").equals("1")) {
                    fila[0] = rs.getString("id_tiposolicitud");
                    fila[1] = rs.getString("descripcion");
                    fila[2] = rs.getString("cantidad_dias");
                    fila[3] = rs.getString("fecha_creacion");
                    fila[4] = rs.getString("fecha_modifacion");
                    fila[5] = rs.getString("estado");
                    model.addRow(fila);
                }
            }
            this.tbTipos.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfDescripcionTP = new javax.swing.JTextField();
        tfCantidadTP = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btNuevoTP = new javax.swing.JButton();
        btGuardarTP = new javax.swing.JButton();
        btModificarrTp = new javax.swing.JButton();
        btEliminarTP = new javax.swing.JButton();
        lblDescripcion = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTipos = new javax.swing.JTable();

        setTitle("MUNICIPALIDAD DE VISTA HERMOSA");
        setLocation(new java.awt.Point(0, 0));
        setName("formtipo"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 500));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestión de Tipos de Permisos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel3.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Descripción");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Cantidad de Días");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btNuevoTP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btNuevoTP.setText("Nuevo");
        btNuevoTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoTPActionPerformed(evt);
            }
        });

        btGuardarTP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btGuardarTP.setText("Guardar");
        btGuardarTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarTPActionPerformed(evt);
            }
        });

        btModificarrTp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btModificarrTp.setText("Modificar");
        btModificarrTp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarrTpActionPerformed(evt);
            }
        });

        btEliminarTP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btEliminarTP.setText("Eliminar");
        btEliminarTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarTPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btModificarrTp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGuardarTP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNuevoTP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEliminarTP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btNuevoTP)
                .addGap(13, 13, 13)
                .addComponent(btGuardarTP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btModificarrTp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btEliminarTP)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        lblDescripcion.setText("jLabel3");

        lblCantidad.setText("jLabel4");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfCantidadTP, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                .addComponent(tfDescripcionTP))
                            .addComponent(lblCantidad))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfDescripcionTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDescripcion)
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfCantidadTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCantidad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbTipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbTipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTiposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTipos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNuevoTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoTPActionPerformed
        Limpiar();
        Habilitar();
    }//GEN-LAST:event_btNuevoTPActionPerformed

    private void btGuardarTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarTPActionPerformed

        if (ValidarCampos()) {
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fechacreacion = dateFormat.format(date);
            String fechamodificacion = fechacreacion;
            String estado = "1";
            try {
                String sql = "insert into tipo_solicitud(descripcion,cantidad_dias,fecha_creacion,fecha_modifacion,estado) values(?,?,?,?,?)";
                PreparedStatement ps = conn.prepareCall(sql);
                ps.setString(1, this.tfDescripcionTP.getText());
                ps.setString(2, this.tfCantidadTP.getText());

                ps.setString(3, fechacreacion);

                ps.setString(4, fechamodificacion);
                ps.setString(5, estado);
                int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Tipo de Permiso Ingresado con éxito");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al insertar " + e.getMessage());
            }
            llenar();
            Limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "Error Validado!!!");
        }


    }//GEN-LAST:event_btGuardarTPActionPerformed

    private void tbTiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTiposMouseClicked

        if (evt.getButton() == 1) {
            int fila = this.tbTipos.getSelectedRow();

            try {
                Habilitar();
                String sql = "select * from tipo_solicitud where id_tiposolicitud = " + this.tbTipos.getValueAt(fila, 0);
                sent = conn.createStatement();
                ResultSet rs = sent.executeQuery(sql);

                rs.next();
                this.tfDescripcionTP.setText(rs.getString("descripcion"));
                this.tfCantidadTP.setText(rs.getString("cantidad_dias"));

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_tbTiposMouseClicked

    private void btEliminarTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarTPActionPerformed

        if (this.tbTipos.getSelectedRow() > -1) {
            try {
                int fila = this.tbTipos.getSelectedRow();
                String sql = "Update tipo_solicitud  SET estado = '0' where id_tiposolicitud = " + this.tbTipos.getValueAt(fila, 0);

                sent = conn.createStatement();
                int n = sent.executeUpdate(sql);

                if (n > 0) {
                    llenar();
                    JOptionPane.showMessageDialog(null, "Tipo de solicitud Eliminada exitosamente");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error Validado!!!");
        }


    }//GEN-LAST:event_btEliminarTPActionPerformed

    private void btModificarrTpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarrTpActionPerformed

        if (ValidarCampos()) {
            try {

                String sql = "Update tipo_solicitud  SET descripcion = ? ,cantidad_dias= ? where id_tiposolicitud = ?";

                int fila = this.tbTipos.getSelectedRow();
                String dao = (String) this.tbTipos.getValueAt(fila, 0);
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, this.tfDescripcionTP.getText());
                ps.setString(2, this.tfCantidadTP.getText());
                ps.setString(3, dao);
                int n = ps.executeUpdate();
                if (n > 0) {
                    Limpiar();
                    llenar();
                    JOptionPane.showMessageDialog(null, "Tipo de solicitud Modificada");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error Validado!!!");
        }


    }//GEN-LAST:event_btModificarrTpActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEliminarTP;
    private javax.swing.JButton btGuardarTP;
    private javax.swing.JButton btModificarrTp;
    private javax.swing.JButton btNuevoTP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JTable tbTipos;
    private javax.swing.JTextField tfCantidadTP;
    private javax.swing.JTextField tfDescripcionTP;
    // End of variables declaration//GEN-END:variables

}
