package frontend.paneleMenu_package;

import backend.Menu_package.Dodawanie_obiektow_package.Dodaj_kurs;
import backend.Menu_package.Dodawanie_obiektow_package.Dodaj_studenta;
import frontend.PopUp.dodawanie_package.*;
import frontend.customView.CustomButton;
import frontend.customView.CustomPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dodawanie_menu extends CustomPanel implements ActionListener {
    private CustomButton dodaj_kurs_przycisk;
    private CustomButton dodaj_pracownika_administracyjego_przycisk;
    private CustomButton dodaj_pracownika_badawczego_przycisk;
    private CustomButton dodaj_studenta_przycisk;
    private CustomButton dodaj_studentowi_kurs_przycisk;

    public Dodawanie_menu(){
         dodaj_kurs_przycisk = new CustomButton("dodaj kurs");
         dodaj_pracownika_administracyjego_przycisk = new CustomButton("dodaj pracownika administracyjnego");
         dodaj_pracownika_badawczego_przycisk = new CustomButton("dodaj pracownika badawczo-naukowego");
         dodaj_studenta_przycisk = new CustomButton("dodaj studenta");
         dodaj_studentowi_kurs_przycisk = new CustomButton("dodaj studentowi kurs");

        dodaj_kurs_przycisk.addActionListener(this);
        dodaj_pracownika_administracyjego_przycisk.addActionListener(this);
        dodaj_pracownika_badawczego_przycisk.addActionListener(this);
        dodaj_studenta_przycisk.addActionListener(this);
        dodaj_studentowi_kurs_przycisk.addActionListener(this);

        this.add(dodaj_kurs_przycisk);
        this.add(dodaj_pracownika_administracyjego_przycisk);
        this.add(dodaj_pracownika_badawczego_przycisk);
        this.add(dodaj_studentowi_kurs_przycisk);
        this.add(dodaj_studenta_przycisk);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Dodawanie_abstract frame;

        if (e.getSource() == dodaj_kurs_przycisk)
            frame = new Dodawanie_kursu_popup();

        if (e.getSource() == dodaj_pracownika_administracyjego_przycisk)
            frame = new Dodawanie_pracownika_admini_popup();

        if (e.getSource() == dodaj_pracownika_badawczego_przycisk)
            frame = new Dodawanie_pracownika_badawcz_popup();

        if (e.getSource() == dodaj_studentowi_kurs_przycisk)
            frame = new Dodaj_kurs_studentowi_popup();

        if (e.getSource() == dodaj_studenta_przycisk)
            frame = new Dodawanie_studenta_popup();
    }
}
