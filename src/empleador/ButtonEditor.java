package empleador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;

class ButtonEditor extends DefaultCellEditor {
    public JButton btnAceptar;
    public String label = "Contratar";
    public boolean isClicked;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        btnAceptar = new JButton();
        btnAceptar.setOpaque(true);
        btnAceptar.setText("Contratar");


        // Acción del botón
        btnAceptar.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(btnAceptar, "Botón de la fila presionado: " + label);
            fireEditingStopped(); // Notificar que la edición terminó
            btnAceptar.setText("Contratar");
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        label = (value == null) ? "Contratar" : value.toString();
        btnAceptar.setText("Contratar");
        isClicked = true;
        return btnAceptar;
    }

    @Override
    public Object getCellEditorValue() {
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isClicked = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
