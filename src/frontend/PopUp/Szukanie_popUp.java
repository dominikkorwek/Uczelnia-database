package frontend.PopUp;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Szukanie_popUp extends JFrame{
    public <T> Szukanie_popUp(ArrayList<T> lista, String szukana){
        this.setTitle("Szukanie w bazach danych");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setMinimumSize(new Dimension(100,50));

        JLabel label = new JLabel();
        label.setText("tu bedzie lista");

        this.add(label);
        this.pack();
        this.setVisible(true);

    }
}
