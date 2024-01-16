package frontend.customView;

import javax.swing.*;

public class CustomRadioButton extends JRadioButton {
    private String name;

    public CustomRadioButton(String name){
        this.setBounds(100,100,100,50);
        this.setText(name);
        this.setFocusable(false);
        this.name = name;
    }
}
