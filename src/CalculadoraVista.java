import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculadoraVista extends JFrame {
    public static final int HEIGHT = 400, WIDTH = 400;
    public NumField numField;
    public Pad numberPad;

    public CalculadoraVista() {
        numField = new NumField(WIDTH - 20);
        numberPad = new Pad();

        //add the components
        add(numField, BorderLayout.NORTH);
        add(numberPad);

        //configure the frame
        setSize(WIDTH, HEIGHT);
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);//ponerlo al centro
    }

    public void addListeners(ActionListener listenForActions){
        //agrega listeners a cada boton del Pad
        numberPad.addListeners(listenForActions);
    }

    public void displayErrors(String errorMessage){
        JOptionPane.showMessageDialog(this,errorMessage);
    }

}
