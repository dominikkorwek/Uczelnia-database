package frontend.paneleMenu_package;

import frontend.customView.CustomButton;
import frontend.customView.CustomPanel;
import frontend.customView.CustomRadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sortowanie_menu extends CustomPanel implements ActionListener{
    private CustomPanel sortowanie_panel = new CustomPanel();
    private CustomRadioButton sort_kursow_przycisk;
    private CustomRadioButton sort_studentow_przycisk;
    private CustomRadioButton sort_pracownikow_przycisk;
    private CustomButton nazwisko_przycisk;
    private CustomButton nazwisko_wiek_przycisk;
    private CustomButton nazwisko_imie_przycisk;
    private CustomButton prowadzacy_przycisk;
    private CustomButton ECTS_przycisk;
    public Sortowanie_menu(){
        sort_kursow_przycisk = new CustomRadioButton("posortuj kursy");
        sort_kursow_przycisk.addActionListener(this);
        sort_studentow_przycisk = new CustomRadioButton("posortuj studentow");
        sort_studentow_przycisk.addActionListener(this);
        sort_pracownikow_przycisk = new CustomRadioButton("posortuj pracownikow");
        sort_pracownikow_przycisk.addActionListener(this);
        CustomPanel panel = new CustomPanel();

        ButtonGroup group = new ButtonGroup();
        group.add(sort_kursow_przycisk);
        group.add(sort_studentow_przycisk);
        group.add(sort_pracownikow_przycisk);

        panel.add(sort_kursow_przycisk);
        panel.add(sort_studentow_przycisk);
        panel.add(sort_pracownikow_przycisk);

        this.add(panel);
        this.add(sortowanie_panel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sort_kursow_przycisk)
            dodaj_sortowanie_kursow();
        else
            dodaj_srotowanie_osob();
    }

    public void dodaj_srotowanie_osob(){
        remove(sortowanie_panel);
        sortowanie_panel = new CustomPanel();
        nazwisko_przycisk = new CustomButton("sortowanie po nazwisku");
        nazwisko_wiek_przycisk = new CustomButton("sortowanie po wieku");
        nazwisko_imie_przycisk = new CustomButton("sortowanie po imieniu");

        sortowanie_panel.add(nazwisko_przycisk);
        sortowanie_panel.add(nazwisko_imie_przycisk);
        sortowanie_panel.add(nazwisko_wiek_przycisk);

        this.add(sortowanie_panel);

        revalidate();
        repaint();
    }
    public void dodaj_sortowanie_kursow(){
        remove(sortowanie_panel);
        sortowanie_panel = new CustomPanel();
        prowadzacy_przycisk = new CustomButton("sortowanie po porwadzacym");
        ECTS_przycisk = new CustomButton("sortowanie po ECTS");

        sortowanie_panel.add(prowadzacy_przycisk);
        sortowanie_panel.add(ECTS_przycisk);

        this.add(sortowanie_panel);

        revalidate();
        repaint();
    }

}
