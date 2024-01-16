package frontend.customView;

import javax.swing.*;

public class CustomCheckBox extends JCheckBox {
    public CustomCheckBox(String nazwa){
        this.setText(nazwa);
        this.setFocusable(false);
    }
}
