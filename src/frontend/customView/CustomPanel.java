package frontend.customView;

import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {
    public CustomPanel(){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBounds(0,0,420,210);
        this.setBackground(Color.WHITE);
    }
}
