package frontend.customView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CustomTextField extends JTextField implements FocusListener {
    JLabel placeholder;
    public CustomTextField(String name){
        super();
        setLayout(new BorderLayout());
        placeholder = new JLabel(name);
        placeholder.setForeground(Color.GRAY);
        add(placeholder,BorderLayout.WEST);
        setPreferredSize(new Dimension(200,20));
        setSize(100,50);
        addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (this.getText().isEmpty()){
            placeholder.setVisible(false);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().isEmpty()){
            placeholder.setVisible(true);
        }
    }
}
