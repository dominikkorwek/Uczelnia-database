package frontend.customView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomButton extends JButton {
    private String name;
    public CustomButton(String name){
        this.setSize(100,50);
        this.setText(name);
        this.setFocusable(false);
        this.name = name;
    }
}
