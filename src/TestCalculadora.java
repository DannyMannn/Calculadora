import Controls.CalculadoraControl;
import GUI.CalculadoraVista;
import Models.CalculadoraModelo;

public class TestCalculadora {

    public static void main(String[] args) {
        CalculadoraVista theView = new CalculadoraVista();

        CalculadoraModelo theModel = new CalculadoraModelo();

        CalculadoraControl theController = new CalculadoraControl(theView,theModel);
        theView.setVisible(true);

    }
}
