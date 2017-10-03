package appadministrador;

import javax.swing.table.DefaultTableModel;
import Conexion.conexion;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Inés Muñoz
 */
public class FormFuncionario extends javax.swing.JFrame {

    DefaultTableModel model;
    Connection conn;
    Statement sent;
    private static FormFuncionario instance1;

    public static FormFuncionario getInstance1() {
        if (instance1 == null) {
            instance1 = new FormFuncionario();
        }
        return instance1;
    }

    private FormFuncionario() {
        initComponents();
        setLocationRelativeTo(null);
        Deshabilitar();
        DeshabilitarError();

        this.cbRolF.removeAllItems();
        ArrayList<String> lista = new ArrayList<String>();

        lista = this.cargarComboRolId();

        for (String i : lista) {
            this.cbRolF.addItem(i);
        }

        conn = conexion.getConexion();
        llenar();
    }

    public ArrayList<String> cargarComboRolId() {
        ArrayList<String> lista = new ArrayList<String>();

        try {
            conn = conexion.getConexion();
            String sql = "select id_rol from rol";
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            while (rs.next()) {
                lista.add(rs.getString("id_rol"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    void DeshabilitarError() {
        this.lbl1.setVisible(false);
        this.lbl2.setVisible(false);
        this.lbl3.setVisible(false);
        this.lbl4.setVisible(false);
        this.lbl5.setVisible(false);
        this.lbl6.setVisible(false);
        this.lbl7.setVisible(false);
        this.lbl8.setVisible(false);
    }

    private void ValidarCampos(int campo) {
        String mensaje = "Error: Debe ingresar campo ";

        switch (campo) {
            case 1:
                mensaje += "RUT";
                this.lbl1.setVisible(true);
                break;
            case 2:
                mensaje += "NOMBRE";
                this.lbl2.setVisible(true);
                break;
            case 3:
                mensaje += "APELLIDO PATERNO";
                this.lbl3.setVisible(true);
                break;
            case 4:
                mensaje += "APELLIDO MATERNO";
                this.lbl4.setVisible(true);
                break;
            case 5:
                mensaje += "PASSWORD";
                this.lbl5.setVisible(true);
                break;
            case 6:
                mensaje += "EMAIL";
                this.lbl6.setVisible(true);
                break;
            case 7:
                mensaje += "DIRECCIÓN";
                this.lbl7.setVisible(true);
                break;
            case 8:
                mensaje += "TELÉFONO";
                this.lbl8.setVisible(true);
                break;
        }
    }

    private boolean ComprobarCampos() {
        if (!this.tfRutF.getText().equals("") && !this.tfNombreF1.getText().equals("") && !this.tfApaternoF.getText().equals("")
                && Integer.parseInt(this.tfPassword.toString()) > 0 && !this.tfEmailF.getText().equals("")
                && Integer.parseInt(this.tfTelefonoF.toString()) > 0 && !this.tfDireccionF.getText().equals("")) {
            DeshabilitarError();
            return true;
        }
        return false;
    }

    void Deshabilitar() {
        this.tfAmaternoF.setEditable(false);
        this.tfApaternoF.setEditable(false);
        this.tfNombreF1.setEditable(false);
        this.tfEmailF.setEditable(false);
        this.tfPassword.setEditable(false);
        this.tfRutF.setEditable(false);
        this.tfTelefonoF.setEditable(false);
        this.tfDireccionF.setEditable(false);
    }

    void Limpiar() {
        this.tfAmaternoF.setText("");
        this.tfApaternoF.setText("");
        this.tfNombreF1.setText("");
        this.tfEmailF.setText("");
        this.tfPassword.setText("");
        this.tfRutF.setText("");
        this.tfTelefonoF.setText("");
        this.tfDireccionF.setText("");

    }

    void Habilitar() {
        this.tfAmaternoF.setEditable(true);
        this.tfApaternoF.setEditable(true);
        this.tfNombreF1.setEditable(true);
        this.tfEmailF.setEditable(true);
        this.tfPassword.setEditable(true);
        this.tfRutF.setEditable(true);
        this.tfTelefonoF.setEditable(true);
        this.tfRutF.requestFocus();
    }

    void llenar() {
        try {
            conn = conexion.getConexion();
            String[] titulos = {"Rut", "Rut Evaluador", "Nombre", "Apellido Paterno", "Apellido Materno", "Dirección", "Telefono", "Password", "Email", "Fecha creacion", "Fecha modificacion", "Estado", "Rol", "Unidad Interna",};
            String sql = "select * from funcionario";
            model = new DefaultTableModel(null, titulos);
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);

            String[] fila = new String[14];

            while (rs.next()) {
                if (rs.getString("estado").equals("1")) {
                    fila[0] = rs.getString("rut");
                    fila[1] = rs.getString("rut_evaluador");
                    fila[2] = rs.getString("nombre");
                    fila[3] = rs.getString("apellido_paterno");
                    fila[4] = rs.getString("apellido_materno");
                    fila[5] = rs.getString("direccion");
                    fila[6] = rs.getString("telefono");
                    fila[7] = rs.getString("password");
                    fila[8] = rs.getString("email");
                    fila[9] = rs.getString("fecha_creacion");
                    fila[10] = rs.getString("fecha_modificacion");
                    fila[11] = rs.getString("estado");
                    fila[12] = rs.getString("id_rol");
                    fila[13] = rs.getString("id_unidad");

                    model.addRow(fila);
                }
            }
            this.tbFuncionarios.setModel(model);
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
        tfRutF = new javax.swing.JTextField();
        tfApaternoF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfNombreF1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfAmaternoF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfDireccionF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfTelefonoF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfEmailF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbRolF = new javax.swing.JComboBox<>();
        tfUnidad = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btNuevoF = new javax.swing.JButton();
        btGuardarF = new javax.swing.JButton();
        btModificarF = new javax.swing.JButton();
        btEliminarF = new javax.swing.JButton();
        lbl1 = new java.awt.Label();
        lbl2 = new java.awt.Label();
        lbl3 = new java.awt.Label();
        lbl4 = new java.awt.Label();
        lbl5 = new java.awt.Label();
        lbl6 = new java.awt.Label();
        lbl7 = new java.awt.Label();
        lbl8 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFuncionarios = new javax.swing.JTable();

        setTitle("MUNICIPALIDAD DE VISTA HERMOSA");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestión de Funcionarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel3.setToolTipText("");
        jPanel3.setFocusable(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Rut");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Apellido Paterno");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Apellido Materno");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Dirección");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Teléfono");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Email");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Password");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Rol");

        cbRolF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tfUnidad.setEditable(false);
        tfUnidad.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Unidad");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btNuevoF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btNuevoF.setText("Nuevo");
        btNuevoF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoFActionPerformed(evt);
            }
        });

        btGuardarF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btGuardarF.setText("Guardar");
        btGuardarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarFActionPerformed(evt);
            }
        });

        btModificarF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btModificarF.setText("Modificar");
        btModificarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarFActionPerformed(evt);
            }
        });

        btEliminarF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btEliminarF.setText("Eliminar");
        btEliminarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btModificarF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNuevoF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGuardarF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEliminarF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btNuevoF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGuardarF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btModificarF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btEliminarF, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl1.setText("label1");

        lbl2.setText("label2");

        lbl3.setText("label3");

        lbl4.setText("label4");

        lbl5.setText("label5");

        lbl6.setText("label6");

        lbl7.setText("label7");

        lbl8.setText("label8");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(91, 91, 91)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(tfRutF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(cbRolF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)))
                        .addGap(50, 50, 50))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(60, 60, 60)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfDireccionF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel8))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6))
                            .addGap(45, 45, 45))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(tfEmailF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfNombreF1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(tfUnidad)
                        .addComponent(tfTelefonoF)
                        .addComponent(lbl8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfApaternoF, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(tfAmaternoF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfRutF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(tfNombreF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfAmaternoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(tfEmailF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tfApaternoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfDireccionF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addComponent(tfTelefonoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbRolF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10))
                            .addComponent(tfUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );

        tbFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tbFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbFuncionarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String UnidadPorRol(String itemR) {

        String itemU = "";
        try {
            conn = conexion.getConexion();

            String sql = "select id_unidad from rol where id_rol=" + itemR;

            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            rs.next();
            itemU = rs.getString("id_unidad");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemU;
    }

    private void tbFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFuncionariosMouseClicked
        if (evt.getButton() == 1) {
            int fila = this.tbFuncionarios.getSelectedRow();

            try {
                Habilitar();
                String sql = "select * from funcionario where rut = '" + this.tbFuncionarios.getValueAt(fila, 0) + "'";
                sent = conn.createStatement();
                ResultSet rs = sent.executeQuery(sql);

                rs.next();

                this.tfRutF.setText(rs.getString("rut"));
                //this.tfRutJefeU.setText(rs.getString("rut_evaluador"));
                this.tfNombreF1.setText(rs.getString("nombre"));
                this.tfApaternoF.setText(rs.getString("apellido_paterno"));
                this.tfAmaternoF.setText(rs.getString("apellido_materno"));
                this.tfDireccionF.setText(rs.getString("direccion"));
                this.tfTelefonoF.setText(rs.getString("telefono"));
                this.tfPassword.setText(rs.getString("password"));
                this.tfEmailF.setText(rs.getString("email"));
                this.cbRolF.setSelectedItem(rs.getString("id_rol"));
                this.tfUnidad.setText(rs.getString("id_unidad"));

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_tbFuncionariosMouseClicked

    private void btEliminarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarFActionPerformed
        try {
            DeshabilitarError();
            int fila = this.tbFuncionarios.getSelectedRow();
            String sql = "Update funcionario  SET estado = '0' where rut = '" + this.tbFuncionarios.getValueAt(fila, 0) + "'";

            sent = conn.createStatement();
            int n = sent.executeUpdate(sql);

            if (n > 0) {
                llenar();
                JOptionPane.showMessageDialog(null, "Funcionario Eliminado exitosamente");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }//GEN-LAST:event_btEliminarFActionPerformed

    private void btModificarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarFActionPerformed
        try {
            DeshabilitarError();
            String itemR = (String) this.cbRolF.getSelectedItem();
            String itemU = this.UnidadPorRol(itemR);
            java.util.Date date = new java.util.Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fechamodificacion = dateFormat.format(date);

            String sql = "Update funcionario  SET nombre = ? ,apellido_paterno= ? ,apellido_materno= ? ,"
                    + "  direccion = ? ,telefono= ? ,password= ?, email = ? ,fecha_modificacion= ? , id_rol= ?,"
                    + " id_unidad=?  where rut = ?";

            int fila = this.tbFuncionarios.getSelectedRow();
            String dao = (String) this.tbFuncionarios.getValueAt(fila, 0);
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, this.tfNombreF1.getText());
            ps.setString(2, this.tfApaternoF.getText());
            ps.setString(3, this.tfAmaternoF.getText());
            ps.setString(4, this.tfDireccionF.getText());
            ps.setString(5, this.tfTelefonoF.getText());
            ps.setString(6, this.tfPassword.getText());
            ps.setString(7, this.tfEmailF.getText());
            ps.setString(8, fechamodificacion);
            ps.setString(9, itemR);
            ps.setString(10, itemU);
            ps.setString(11, dao);
            int n = ps.executeUpdate();
            if (n > 0) {
                Limpiar();
                llenar();
                JOptionPane.showMessageDialog(null, "Funcionario Modificado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }//GEN-LAST:event_btModificarFActionPerformed

    private void btGuardarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarFActionPerformed

        if (ComprobarCampos()) {
            String itemR = (String) this.cbRolF.getSelectedItem();
            String itemU = this.UnidadPorRol(itemR);
            java.util.Date date = new java.util.Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fechacreacion = dateFormat.format(date);
            String fechamodificacion = fechacreacion;
            String estado = "1";
            try {
                String sql = "insert into funcionario(rut,rut_evaluador,nombre,apellido_paterno,apellido_materno,direccion,telefono,password,email,fecha_creacion,\n"
                        + "                fecha_modificacion,estado,id_rol,id_unidad) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareCall(sql);
                ps.setString(1, this.tfRutF.getText());
                ps.setString(2, "");//this.tfRutJefeU.getText());
                ps.setString(3, this.tfNombreF1.getText());
                ps.setString(4, this.tfApaternoF.getText());
                ps.setString(5, this.tfAmaternoF.getText());
                ps.setString(6, this.tfDireccionF.getText());
                ps.setString(7, this.tfTelefonoF.getText());
                ps.setString(8, this.tfPassword.getText());
                ps.setString(9, this.tfEmailF.getText());
                ps.setString(10, fechacreacion);
                ps.setString(11, fechamodificacion);
                ps.setString(12, estado);
                ps.setString(13, itemR);
                ps.setString(14, itemU);
                int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Funcionario Ingresado con éxito");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al insertar " + e.getMessage());
            }
            llenar();
            Limpiar();
        }else{
            for(int i=1; i<=8; i++){
                ValidarCampos(i);
            }
        }


    }//GEN-LAST:event_btGuardarFActionPerformed

    private void btNuevoFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoFActionPerformed
        Limpiar();
        Habilitar();
    }//GEN-LAST:event_btNuevoFActionPerformed

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
            java.util.logging.Logger.getLogger(FormFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEliminarF;
    private javax.swing.JButton btGuardarF;
    private javax.swing.JButton btModificarF;
    private javax.swing.JButton btNuevoF;
    private javax.swing.JComboBox<String> cbRolF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label lbl1;
    private java.awt.Label lbl2;
    private java.awt.Label lbl3;
    private java.awt.Label lbl4;
    private java.awt.Label lbl5;
    private java.awt.Label lbl6;
    private java.awt.Label lbl7;
    private java.awt.Label lbl8;
    private javax.swing.JTable tbFuncionarios;
    private javax.swing.JTextField tfAmaternoF;
    private javax.swing.JTextField tfApaternoF;
    private javax.swing.JTextField tfDireccionF;
    private javax.swing.JTextField tfEmailF;
    private javax.swing.JTextField tfNombreF1;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfRutF;
    private javax.swing.JTextField tfTelefonoF;
    private javax.swing.JTextField tfUnidad;
    // End of variables declaration//GEN-END:variables
}
