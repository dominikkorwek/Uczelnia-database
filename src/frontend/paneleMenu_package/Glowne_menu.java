package frontend.paneleMenu_package;

import frontend.customView.CustomButton;
import frontend.customView.CustomPanel;
import frontend.customView.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Glowne_menu extends CustomPanel implements ActionListener{
    private CustomButton dodawanie_przycik ;
    private CustomButton sortowanie_przycik ;
    private CustomButton szukanie_przycik ;
    private CustomButton usuwanie_przycik ;
    private CustomButton wypisywanie_przycik ;
    public Glowne_menu(){
        dodawanie_przycik = new CustomButton("dodaj obiekt");
        dodawanie_przycik.addActionListener(this);
        sortowanie_przycik = new CustomButton("posortuj listy");
        sortowanie_przycik.addActionListener(this);
        szukanie_przycik = new CustomButton("poszukaj obiektu");
        szukanie_przycik.addActionListener(this);
        usuwanie_przycik = new CustomButton("usuwanie obiektu");
        usuwanie_przycik.addActionListener(this);
        wypisywanie_przycik = new CustomButton("wyszukiwanie obiektu");
        wypisywanie_przycik.addActionListener(this);

        this.add(dodawanie_przycik);
        this.add(sortowanie_przycik);
        this.add(szukanie_przycik);
        this.add(usuwanie_przycik);
        this.add(wypisywanie_przycik);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==dodawanie_przycik)
            MainFrame.getInstance().setPanel_glowny(new Dodawanie_menu());
        if (e.getSource()==sortowanie_przycik)
            MainFrame.getInstance().setPanel_glowny( new Sortowanie_menu());
        if (e.getSource()==szukanie_przycik)
            MainFrame.getInstance().setPanel_glowny( new Szukanie_menu());
        if (e.getSource()==usuwanie_przycik)
            MainFrame.getInstance().setPanel_glowny( new Usuwanie_menu());
        if (e.getSource()==wypisywanie_przycik)
            MainFrame.getInstance().setPanel_glowny( new Wypisywanie_menu());
    }
}
