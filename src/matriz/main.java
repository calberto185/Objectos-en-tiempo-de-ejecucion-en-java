package matriz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javafx.scene.layout.Border;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class main implements ActionListener {

    javax.swing.JFrame frame = new javax.swing.JFrame();
    javax.swing.JPanel main = new javax.swing.JPanel();
    javax.swing.JPanel control = new javax.swing.JPanel();
    GridBagConstraints gbc = new GridBagConstraints();
    GridBagConstraints gbc2 = new GridBagConstraints();
    javax.swing.JPanel vista = new javax.swing.JPanel();
    javax.swing.JButton iniciar = new javax.swing.JButton("Iniciar");
    javax.swing.JButton limpiar = new javax.swing.JButton("Limpiar");
    javax.swing.JButton operar = new javax.swing.JButton("Operar");

    //sub menu
    javax.swing.JPanel inputs = new javax.swing.JPanel();
    javax.swing.JTextField x = new javax.swing.JTextField();
    javax.swing.JTextField y = new javax.swing.JTextField();
    javax.swing.JTextField p = new javax.swing.JTextField();

    ArrayList<javax.swing.JTextField> textos = new ArrayList<javax.swing.JTextField>();

    main() {
        initComponets();
    }

    public static void main(String[] args) {
        new main();
    }

    private void initComponets() {
        frame.setSize(400, 300);
        frame.setTitle("Desarrollado por: Carlosvm <carlos_vm_7@hotmail.com>");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        main.setBackground(Color.white);
        GridBagLayout layout = new GridBagLayout();
        main.setLayout(layout);
        frame.add(main);
        //components
        controles();
        control.setBackground(new java.awt.Color(20, 100, 200));
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        layout.setConstraints(control, gbc);
        main.add(control);

        vista.setBackground(new java.awt.Color(254, 254, 254));
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gbc2.weightx = 4;
        gbc2.weighty = 4;
        layout.setConstraints(vista, gbc2);

        vista.setLayout(new FlowLayout());
        main.add(vista);
        //fin-components
        frame.setVisible(true);
    }

    public void actionPerformed(java.awt.event.ActionEvent ae) {

        if (ae.getSource() == iniciar) {
            try {
                if (!x.getText().trim().isEmpty() && !y.getText().trim().isEmpty() && !p.getText().trim().isEmpty()) {
                    System.out.println(ae.getActionCommand());
                    operar.setVisible(true);
                    vista.setLayout(new GridLayout(Integer.parseInt(x.getText()), Integer.parseInt(y.getText())));
                    for (int i = 0; i < Integer.parseInt(x.getText()); i++) {
                        for (int j = 0; j < Integer.parseInt(y.getText()); j++) {
                            textos.add(new JTextField());
                        }
                    }
                    for (int i = 0; i < Integer.parseInt(x.getText()) * Integer.parseInt(y.getText()); i++) {
                        javax.swing.JTextField txt = textos.get(i);
                        txt.setName("input" + 1);
                        txt.setHorizontalAlignment(JTextField.CENTER);  
                        vista.add(txt);
                    }
                    vista.updateUI();
                } else {
                    JOptionPane.showMessageDialog(null, "Cuidado!!!. Ingresa solo numeros");
                }
            } catch (Exception e) {
                System.out.println("no muestra nada");
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        if (ae.getSource() == limpiar) {
            System.out.println(ae.getActionCommand());
            operar.setVisible(false);
            x.setText("");
            y.setText("");
            p.setText("");
            vista.removeAll();
            vista.repaint();
            textos.removeAll(textos);
        }
        if (ae.getSource() == operar) {
            System.out.println(ae.getActionCommand());
            try {
                for (int i = 0; i < Integer.parseInt(x.getText()) * Integer.parseInt(y.getText()); i++) {
                    javax.swing.JTextField txt = textos.get(i);
                    String dato = txt.getText();
                    txt.setToolTipText("Dato anterior: " + dato);
                    txt.setText(String.valueOf((int) Math.pow(Integer.parseInt(dato), Integer.parseInt(p.getText()))));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Only numbers: " + e.getMessage());
            }
        }
    }
    
    private void controles() {
        control.setLayout(new GridLayout(15, 2));
        control.add(new JLabel("<html><font color='white'>Dimension en X</font></html>"));
        x.setHorizontalAlignment(JTextField.CENTER);
        control.add(x);
        control.add(new JLabel("<html><font color='white'>Dimension en Y</font></html>"));
        y.setHorizontalAlignment(JTextField.CENTER);
        control.add(y);
        control.add(new JLabel("<html><font color='white'>Potencia</font></html>"));
        p.setHorizontalAlignment(JTextField.CENTER);
        control.add(p);
        control.add(new JLabel(""));
        iniciar.addActionListener(this);
        control.add(iniciar);
        limpiar.addActionListener(this);
        control.add(limpiar);
        control.add(new JLabel(""));
        operar.addActionListener(this);
        operar.setVisible(false);
        control.add(operar);
    }
}
