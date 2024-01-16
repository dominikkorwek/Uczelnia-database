package frontend.customView;

import javax.swing.*;

public class CustomTextField extends JTextField {
    public CustomTextField(String name){
        this.setText(name);
        this.setSize(200,100);
    }
}
