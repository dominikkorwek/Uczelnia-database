package frontend.customView;

import frontend.paneleMenu_package.Dodawanie_menu;
import frontend.paneleMenu_package.Glowne_menu;
import frontend.paneleMenu_package.Sortowanie_menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame  implements ActionListener {
    private CustomPanel panel_glowny = new Glowne_menu();
    private CustomButton EXIT = new CustomButton("Wyjscie");
    private ArrayList<CustomPanel> historia_paneli = new ArrayList<>();
    private int width = 420;
    private int height = 420;
    private JLayeredPane layeredPane = new JLayeredPane();
    public static MainFrame instance;

    private MainFrame() {
        this.setTitle("Zarzadzanie uczelnia");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(width, height);

        EXIT.setBounds(0, height-80, 80, 40);//y = height - button's height
        EXIT.addActionListener(this);

        layeredPane.add(panel_glowny, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(EXIT, JLayeredPane.PALETTE_LAYER);

        panel_glowny.setBounds(0,0,width,height);

        this.getContentPane().add(layeredPane);
        this.setVisible(true);
    }
    public static MainFrame getInstance(){
        if (instance == null)
            instance = new MainFrame();
        return instance;
    }

    public CustomPanel getPanel_glowny() {
        return panel_glowny;
    }

    public void setPanel_glowny(CustomPanel panel_glowny) {
        historia_paneli.add(this.panel_glowny);
        zmien_panel(panel_glowny);
    }
    public void powroc_panel(){
        if (historia_paneli.isEmpty())
            System.exit(0);
        zmien_panel(historia_paneli.get(historia_paneli.size()-1));
        historia_paneli.remove(historia_paneli.size()-1);
    }
    private void zmien_panel(CustomPanel panel_glowny){
        layeredPane.remove(this.panel_glowny);
        remove(this.panel_glowny);
        this.getContentPane().remove(layeredPane);

        panel_glowny.setBounds(0,0,width,height);
        this.panel_glowny = panel_glowny;

        layeredPane.add(panel_glowny, JLayeredPane.DEFAULT_LAYER);
        this.getContentPane().add(layeredPane);

        revalidate();
        repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == EXIT)
            powroc_panel();
    }
}
