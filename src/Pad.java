import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Pad extends JPanel {
    public JButton[] numButtons;
    public JButton prefijoButton, infijoButton, sufijoButton;
    public JButton delButton, acButton;
    public JButton masButton, menosButton, multButton, divButton;
    public JButton puntoButton, expButton;
    public JButton igualButton, parentesisIzq, parentesisDer, menosUnarioButton;
    public JButton llaveIzq, llaveDer, corcheteIzq, corcheteDer;

    public Pad(){
        this.setLayout(new GridLayout(6,5,5,5));
        createButtons();
        addButtons();
        setButtonColor();
    }

    private void createButtons(){
        numButtons = new JButton[10];
        for(int i = 0; i < 10; i++){
            numButtons[i] = new JButton(String.valueOf(i));
        }

        prefijoButton = new JButton("Prefijo");
        infijoButton = new JButton("Infijo");
        sufijoButton = new JButton("Sufijo");

        delButton = new JButton("DEL");
        acButton = new JButton("AC");

        masButton = new JButton("+");
        menosButton = new JButton("-");
        multButton = new JButton("*");
        divButton = new JButton("/");

        puntoButton = new JButton(".");
        expButton = new JButton("^");

        igualButton = new JButton("=");
        parentesisIzq = new JButton("(");
        parentesisDer = new JButton(")");
        menosUnarioButton = new JButton("(-)");

        corcheteDer = new JButton("]");
        corcheteIzq = new JButton("[");
        llaveDer = new JButton("}");
        llaveIzq = new JButton("{");

    }

    private void addButtons(){
        add(numButtons[7]);
        add(numButtons[8]);
        add(numButtons[9]);
        add(delButton);
        add(acButton);

        add(numButtons[4]);
        add(numButtons[5]);
        add(numButtons[6]);
        add(multButton);
        add(divButton);

        add(numButtons[1]);
        add(numButtons[2]);
        add(numButtons[3]);
        add(masButton);
        add(menosButton);

        add(numButtons[0]);
        add(parentesisIzq);
        add(parentesisDer);
        add(puntoButton);
        add(expButton);

        add(menosUnarioButton);
        add(prefijoButton);
        add(infijoButton);
        add(sufijoButton);
        add(igualButton);

        add(corcheteIzq);
        add(corcheteDer);
        add(llaveIzq);
        add(llaveDer);

    }

    public void addListeners(ActionListener listenForActions){
        for (int i = 0; i < 10; i++){
            numButtons[i].addActionListener(listenForActions);
        }

        prefijoButton.addActionListener(listenForActions);
        infijoButton.addActionListener(listenForActions);
        sufijoButton.addActionListener(listenForActions);

        delButton.addActionListener(listenForActions);
        acButton.addActionListener(listenForActions);

        masButton.addActionListener(listenForActions);
        menosButton.addActionListener(listenForActions);
        multButton.addActionListener(listenForActions);
        divButton.addActionListener(listenForActions);

        puntoButton.addActionListener(listenForActions);
        expButton.addActionListener(listenForActions);

        igualButton.addActionListener(listenForActions);
        parentesisIzq.addActionListener(listenForActions);
        parentesisDer.addActionListener(listenForActions);
        menosUnarioButton.addActionListener(listenForActions);
    }

    private void setButtonColor(){
        for (int i = 0; i < 10; i++){
            numButtons[i].setBackground(Color.WHITE);
        }

        prefijoButton.setBackground(Color.WHITE);
        infijoButton.setBackground(Color.WHITE);
        sufijoButton.setBackground(Color.WHITE);

        delButton.setBackground(Color.WHITE);
        acButton.setBackground(Color.WHITE);

        masButton.setBackground(Color.WHITE);
        menosButton.setBackground(Color.WHITE);
        multButton.setBackground(Color.WHITE);
        divButton.setBackground(Color.WHITE);

        puntoButton.setBackground(Color.WHITE);
        expButton.setBackground(Color.WHITE);

        igualButton.setBackground(Color.WHITE);
        parentesisIzq.setBackground(Color.WHITE);
        parentesisDer.setBackground(Color.WHITE);
        menosUnarioButton.setBackground(Color.WHITE);

        corcheteIzq.setBackground(Color.WHITE);
        corcheteDer.setBackground(Color.WHITE);
        llaveIzq.setBackground(Color.WHITE);
        llaveDer.setBackground(Color.WHITE);
    }
}