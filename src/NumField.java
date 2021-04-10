import java.awt.*;
import javax.swing.*;

public class NumField extends JPanel {
    public JTextField field;

    public NumField(int width) {
        field = new JTextField("");
        //field.setEditable(false);
        field.setBackground(Color.WHITE);
        field.setPreferredSize(new Dimension(width, 50));
        field.setHorizontalAlignment(JTextField.RIGHT);
        field.setFont(new Font(field.getFont().getName(), Font.PLAIN, 30));
        add(field);
    }
}
