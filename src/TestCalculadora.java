import java.util.*;
import javax.swing.*;
import java.awt.*;

public class TestCalculadora {

    public static void main(String[] args) {
        CalculadoraVista theView = new CalculadoraVista();

        CalculadoraModelo theModel = new CalculadoraModelo();

        CalculadoraControl theController = new CalculadoraControl(theView,theModel);
        theView.setVisible(true);

    }
}
