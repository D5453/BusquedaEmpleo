/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package empleador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author diegi
 */
public class login extends javax.swing.JFrame {
    ResultSet rs;
    Conexion cn;
    Connection con;
    PreparedStatement ps;
    /**
     * Creates new form login
     */
    public login(java.awt.Frame parent, boolean modal) {
        initComponents();
    }

    public void ingresar(){
        ResultSet rs;
        String usuario = txtEmail.getText();
        String password = txtPassword.getText();
        if(usuario.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(null, "LLene los dos campo de usuario y contraseña");
        }
        else{
            try {
                 cn = new Conexion();
        con = cn.obtenerconexion();
                //Peticion
                PreparedStatement ps = con.prepareStatement("SELECT email, password FROM ussers where email='"+usuario+"' AND password='"+password+"'");
                //Cajon de enviado
                // rs un dato de devolucion
                rs = ps.executeQuery();
                if(rs.next()){
                    
                    IndexEmpresas in = new IndexEmpresas();
                    this.dispose();
                    in.setLocationRelativeTo(null);
                    in.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Contraseña o correo no valido");
                    txtPassword.setText("");
                    txtEmail.setText("");
                }
            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al ingresar   "+ex.getMessage());
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        PanelRight = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelRight.setBackground(new java.awt.Color(153, 153, 255));
        PanelRight.setForeground(new java.awt.Color(204, 255, 255));
        PanelRight.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("Iniciar sesion");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        PanelRight.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 190, 40));

        jButton1.setText("Registrar");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PanelRight.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 190, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 58)); // NOI18N
        jLabel2.setText("Bienvenidos");
        PanelRight.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 370, 90));

        txtPassword.setBackground(new java.awt.Color(153, 153, 255));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtPassword.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, new java.awt.Color(153, 153, 255), new java.awt.Color(153, 153, 255)));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        PanelRight.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 310, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Correo");
        PanelRight.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 190, -1));

        txtEmail.setBackground(new java.awt.Color(153, 153, 255));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtEmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 255, 255), new java.awt.Color(153, 153, 255), new java.awt.Color(153, 153, 255), new java.awt.Color(153, 153, 255)));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        PanelRight.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 310, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Contraseña");
        PanelRight.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        jPanel2.add(PanelRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 470, 620));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/FondoLogin.jpeg"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ingresar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        registroempleador rg = new registroempleador(new javax.swing.JFrame(), true);
        this.dispose();
        rg.setLocationRelativeTo(null);
        rg.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelRight;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
