/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package empleador;
import DAO.DAOCandidatos;
import Objetos.Candidatos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "Cotratar" : value.toString());
        return this;
    }
}
/**
 *
 * @author Campos Cuaquentzi
 */
public class IndexEmpresas extends javax.swing.JFrame implements ActionListener {
    public JTextField campoTexto;
    DefaultTableModel modeloTabla;
    DAOCandidatos daoc= new DAOCandidatos();
    public IndexEmpresas() {
        initComponents();
        // Asegúrate de agregar los listeners en el constructor
        btnOfertas.addActionListener(this);
        btnEmpleadores.addActionListener(this);
        btnPostulaciones.addActionListener(this);
        btnCandidatos.addActionListener(this);
       }
  @Override
   public void actionPerformed(ActionEvent e) {
    // Aquí manejas las acciones de los botones
    if (e.getSource() == btnEmpleadores) {
        // Crear tabla de candidatos
        modeloTabla = new DefaultTableModel(); // Inicializar el modelo correctamente

        // Definir las columnas de la tabla
        String[] columnas = {"ID", "Nombre"};
        modeloTabla.setColumnIdentifiers(columnas); // Agregar columnas al modelo

        // Obtener datos
        java.util.List<Candidatos> datos = daoc.obtenerEmpleadores();
        if (datos != null) {
            // Llenar los datos en el modelo
            for (Candidatos candidato : datos) {
                Object[] fila = new Object[2]; // Ajustar el tamaño según el número de columnas
                fila[0] = candidato.getId();  // ID
                fila[1] = candidato.getName(); // Nombre
                modeloTabla.addRow(fila); // Agregar fila al modelo
            }
        }

        // Crear la tabla con el modelo
        JTable tabla = new JTable(modeloTabla);

        // Crear un JScrollPane para la tabla
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(20, 20, 700, 500); // Ajustar la posición y tamaño

        // Limpiar el panel para evitar acumulación de componentes
        jPanel1.removeAll();

        // Agregar el JScrollPane al panel
        jPanel1.add(scrollPane);

        // Redibujar el panel para reflejar los cambios
        jPanel1.revalidate();
        jPanel1.repaint();

        
    } else if (e.getSource() == btnCandidatos) {
        // Crear tabla de candidatos
        modeloTabla = new DefaultTableModel(); // Inicializar el modelo correctamente

        // Definir las columnas de la tabla
        String[] columnas = {"ID", "Nombre", "Aceptar o denegar"};
        modeloTabla.setColumnIdentifiers(columnas); // Agregar columnas al modelo

        // Obtener datos
        java.util.List<Candidatos> datos = daoc.obtenerCandidatos();
        if (datos != null) {
            // Llenar los datos en el modelo
            for (Candidatos candidato : datos) {
                Object[] fila = new Object[3]; // Ajustar el tamaño según el número de columnas
                fila[0] = candidato.getId();  // ID
                fila[1] = candidato.getName(); // Nombre
                fila[2] = "Aceptar"; // Texto del botón (se puede usar como etiqueta para el botón)
                modeloTabla.addRow(fila); // Agregar fila al modelo
            }
            
        }
        // Crear la tabla con el modelo
        JTable tabla = new JTable(modeloTabla);

        // Renderizador personalizado para mostrar botones en la columna 2 (fila[2])
        tabla.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());

        // Editor personalizado para manejar los eventos de los botones
        tabla.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox()));

        // Crear un JScrollPane para la tabla
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(20, 20, 700, 500); // Ajustar la posición y tamaño

        // Limpiar el panel para evitar acumulación de componentes
        jPanel1.removeAll();

        // Agregar el JScrollPane al panel
        jPanel1.add(scrollPane);

        // Redibujar el panel para reflejar los cambios
        jPanel1.revalidate();
        jPanel1.repaint();
        
    } else if (e.getSource() == btnOfertas) {
        // Crear tabla de ofertas
        String[] columnas = {"ID", "Puesto", "Salario"};
        Object[][] datos = {
            {1, "Desarrollador Java", "$3000"},
            {2, "Analista de Sistemas", "$2500"},
            {3, "Diseñador UX", "$2200"}
        };

        // Crear el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel(datos, columnas);
        
        // Crear la tabla
        JTable tabla = new JTable(modeloTabla);
        
        // Crear un JScrollPane para la tabla
        JScrollPane scrollPane = new JScrollPane(tabla);
        
        // Asegúrate de usar setBounds aquí
        scrollPane.setBounds(50, 100, 600, 300);  // Ajusta la posición y el tamaño según sea necesario

        // Limpiar el panel para evitar que se acumulen tablas
        jPanel1.removeAll();
        
        // Agregar el JScrollPane al panel
        jPanel1.add(scrollPane);
        
        // Redibujar el JFrame para reflejar la nueva tabla
        jPanel1.revalidate();
        jPanel1.repaint();
        
    } else if (e.getSource() == btnPostulaciones) {
        // Crear tabla de postulaciones
        String[] columnas = {"ID", "Nombre Candidato", "Puesto Postulado"};
        Object[][] datos = {
            {1, "Carlos Díaz", "Desarrollador Java"},
            {2, "Laura Pérez", "Analista de Sistemas"},
            {3, "Pedro Martínez", "Diseñador UX"}
        };

        // Crear el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel(datos, columnas);
        
        // Crear la tabla
        JTable tabla = new JTable(modeloTabla);
        
        // Crear un JScrollPane para la tabla
        JScrollPane scrollPane = new JScrollPane(tabla);
        
        // Aquí también, asegúrate de usar setBounds
        scrollPane.setBounds(50, 100, 600, 300);  // Ajusta la posición y el tamaño según sea necesario

        // Limpiar el panel para evitar que se acumulen tablas
        jPanel1.removeAll();
        
        // Agregar el JScrollPane al panel
        jPanel1.add(scrollPane);
        
        // Redibujar el JFrame para reflejar la nueva tabla
        jPanel1.revalidate();
        jPanel1.repaint();
    }
}





    public class CambiarColorBoton {
       public static void main(String[] args) {
           JFrame frame = new JFrame("Cambiar Color Botón");
           frame.setSize(300, 200);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setLayout(null);

           JButton boton = new JButton("Haz clic aquí");
           boton.setBounds(50, 50, 200, 50);

           // Agregar ActionListener al botón
           boton.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   boton.setBackground(Color.GREEN); // Cambia el color del fondo
               }
           });

           frame.add(boton);
           frame.setVisible(true);
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

        Fondo = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        btnCandidatos = new javax.swing.JButton();
        btnEmpleadores = new javax.swing.JButton();
        btnOfertas = new javax.swing.JButton();
        btnPostulaciones = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        Fondo.setBackground(new java.awt.Color(235, 235, 235));
        Fondo.setForeground(new java.awt.Color(204, 204, 204));
        Fondo.setPreferredSize(new java.awt.Dimension(479, 630));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 0, 102));
        jButton1.setText("Cerrar sesion");
        jButton1.setBorder(null);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 170, 40));

        btnInicio.setBackground(new java.awt.Color(153, 153, 255));
        btnInicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(51, 0, 102));
        btnInicio.setText("Inicio");
        btnInicio.setBorder(null);
        btnInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        jPanel3.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 170, 40));

        btnCandidatos.setBackground(new java.awt.Color(153, 153, 255));
        btnCandidatos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCandidatos.setForeground(new java.awt.Color(51, 0, 102));
        btnCandidatos.setText("Candidatos");
        btnCandidatos.setBorder(null);
        btnCandidatos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCandidatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCandidatosActionPerformed(evt);
            }
        });
        jPanel3.add(btnCandidatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 170, 40));

        btnEmpleadores.setBackground(new java.awt.Color(153, 153, 255));
        btnEmpleadores.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEmpleadores.setForeground(new java.awt.Color(51, 0, 102));
        btnEmpleadores.setText("Empleadores");
        btnEmpleadores.setBorder(null);
        btnEmpleadores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEmpleadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadoresActionPerformed(evt);
            }
        });
        jPanel3.add(btnEmpleadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 170, 40));

        btnOfertas.setBackground(new java.awt.Color(153, 153, 255));
        btnOfertas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnOfertas.setForeground(new java.awt.Color(51, 0, 102));
        btnOfertas.setText("Ofertas de trabajo");
        btnOfertas.setBorder(null);
        btnOfertas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnOfertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOfertasActionPerformed(evt);
            }
        });
        jPanel3.add(btnOfertas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 170, 40));

        btnPostulaciones.setBackground(new java.awt.Color(153, 153, 255));
        btnPostulaciones.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPostulaciones.setForeground(new java.awt.Color(51, 0, 102));
        btnPostulaciones.setText("<html>Postulacion de<br>trabajo</html>");
        btnPostulaciones.setActionCommand("Postulaciones de trabajo");
        btnPostulaciones.setBorder(null);
        btnPostulaciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPostulaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostulacionesActionPerformed(evt);
            }
        });
        jPanel3.add(btnPostulaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 170, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N
        jLabel1.setText("NEXUM");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, 50));

        Fondo.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 630));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        Fondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 770, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        login lg = new login(new javax.swing.JFrame(), true);
        lg.setLocationRelativeTo(null);
        this.dispose();
        lg.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
    btnInicio.setBackground(Color.WHITE);
    
    btnCandidatos.setBackground(new Color(153, 153, 255));    
    btnEmpleadores.setBackground(new Color(153, 153, 255));
    btnOfertas.setBackground(new Color(153, 153, 255));
    btnPostulaciones.setBackground(new Color(153, 153, 255));
    jButton1.setBackground(new Color(153, 153, 255));

        // Configurar el botón
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnCandidatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCandidatosActionPerformed
    btnCandidatos.setBackground(Color.WHITE);
    
    jButton1.setBackground(new Color(153, 153, 255));    
    btnEmpleadores.setBackground(new Color(153, 153, 255));
    btnInicio.setBackground(new Color(153, 153, 255));
    btnPostulaciones.setBackground(new Color(153, 153, 255));
    btnOfertas.setBackground(new Color(153, 153, 255));
    }//GEN-LAST:event_btnCandidatosActionPerformed

    private void btnEmpleadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadoresActionPerformed
    btnEmpleadores.setBackground(Color.WHITE);
    
    jButton1.setBackground(new Color(153, 153, 255));    
    btnCandidatos.setBackground(new Color(153, 153, 255));
    btnInicio.setBackground(new Color(153, 153, 255));
    btnOfertas.setBackground(new Color(153, 153, 255));
    btnPostulaciones.setBackground(new Color(153, 153, 255));
    }//GEN-LAST:event_btnEmpleadoresActionPerformed

    private void btnOfertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOfertasActionPerformed
    btnOfertas.setBackground(Color.WHITE);
    
    jButton1.setBackground(new Color(153, 153, 255));    
    btnCandidatos.setBackground(new Color(153, 153, 255));
    btnEmpleadores.setBackground(new Color(153, 153, 255));
    btnInicio.setBackground(new Color(153, 153, 255));
    btnPostulaciones.setBackground(new Color(153, 153, 255));
    }//GEN-LAST:event_btnOfertasActionPerformed

    private void btnPostulacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostulacionesActionPerformed
    btnPostulaciones.setBackground(Color.WHITE);
    
    jButton1.setBackground(new Color(153, 153, 255));    
    btnCandidatos.setBackground(new Color(153, 153, 255));
    btnEmpleadores.setBackground(new Color(153, 153, 255));
    btnInicio.setBackground(new Color(153, 153, 255));
    btnOfertas.setBackground(new Color(153, 153, 255));
    }//GEN-LAST:event_btnPostulacionesActionPerformed

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
            java.util.logging.Logger.getLogger(IndexEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IndexEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IndexEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IndexEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IndexEmpresas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton btnCandidatos;
    private javax.swing.JButton btnEmpleadores;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnOfertas;
    private javax.swing.JButton btnPostulaciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
