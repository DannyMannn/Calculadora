import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraControl {
    private CalculadoraVista vista;
    private CalculadoraModelo modelo;

    public CalculadoraControl(CalculadoraVista vista, CalculadoraModelo modelo){
        this.vista = vista;
        this.modelo = modelo;

        this.vista.addListeners(new ButtonsListener());
    }

    class ButtonsListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String a;

            try {
                a = vista.numField.field.getText();
                if (vista.numberPad.numButtons[1].equals(event.getSource())) {
                    vista.numField.field.setText(a + 1);
                }
                if (vista.numberPad.numButtons[2].equals(event.getSource())) {
                    vista.numField.field.setText(a + 2);
                }
                if (vista.numberPad.numButtons[3].equals(event.getSource())) {
                    vista.numField.field.setText(a + 3);
                }
                if (vista.numberPad.numButtons[4].equals(event.getSource())) {
                    vista.numField.field.setText(a + 4);
                }
                if (vista.numberPad.numButtons[5].equals(event.getSource())) {
                    vista.numField.field.setText(a + 5);
                }
                if (vista.numberPad.numButtons[6].equals(event.getSource())) {
                    vista.numField.field.setText(a + 6);
                }
                if (vista.numberPad.numButtons[7].equals(event.getSource())) {
                    vista.numField.field.setText(a + 7);
                }
                if (vista.numberPad.numButtons[8].equals(event.getSource())) {
                    vista.numField.field.setText(a + 8);
                }
                if (vista.numberPad.numButtons[9].equals(event.getSource())) {
                    vista.numField.field.setText(a + 9);
                }
                if (vista.numberPad.numButtons[0].equals(event.getSource())) {
                    vista.numField.field.setText(a + 0);
                }

                if (vista.numberPad.masButton.equals(event.getSource())) {
                    vista.numField.field.setText(a + "+");
                }
                if (vista.numberPad.menosButton.equals(event.getSource())) {
                    vista.numField.field.setText(a + "-");
                }
                if (vista.numberPad.multButton.equals(event.getSource())) {
                    vista.numField.field.setText(a + "*");
                }
                if (vista.numberPad.divButton.equals(event.getSource())) {
                    vista.numField.field.setText(a + "/");
                }
                if (vista.numberPad.puntoButton.equals(event.getSource())) {
                    vista.numField.field.setText(a + ".");
                }
                if (vista.numberPad.parentesisIzq.equals(event.getSource())) {
                    vista.numField.field.setText(a + "(");
                }
                if (vista.numberPad.parentesisDer.equals(event.getSource())) {
                    vista.numField.field.setText(a + ")");
                }
                if (vista.numberPad.expButton.equals(event.getSource())) {
                    vista.numField.field.setText(a + "^");
                }
                if (vista.numberPad.acButton.equals(event.getSource())) {
                    vista.numField.field.setText("");
                }
                if (vista.numberPad.delButton.equals(event.getSource())) {
                    String aux = a.substring(0, a.length() - 1);
                    vista.numField.field.setText(aux);
                }
                if (vista.numberPad.igualButton.equals(event.getSource())) {
                    modelo.setExpressionString(a);
                    String aux = String.valueOf(modelo.calcularOperacion());
                    vista.numField.field.setText(aux);
                }

                //HACER XD
                if (vista.numberPad.prefijoButton.equals(event.getSource())) {

                }

                if (vista.numberPad.infijoButton.equals(event.getSource())) {

                }

                if (vista.numberPad.sufijoButton.equals(event.getSource())) {

                }

                if (vista.numberPad.menosUnarioButton.equals(event.getSource())) {

                }
            }catch (Exception e){//METER TODAS LAS EXCEPCIONES NECESARIAS
                vista.displayErrors("ERROROROROR01010101");
                System.out.println(e.getMessage());
            }

        }
    }

}
