package frontend.paneleMenu_package;

import frontend.customView.CustomButton;
import frontend.customView.CustomPanel;
import frontend.customView.CustomRadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

import backend.klasy.*;

import static backend.Bazy_danych_package.Bazy_danych.*;

public class Sortowanie_menu <T> extends CustomPanel implements ActionListener{
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


    public void dodaj_srotowanie_osob(){
        remove(sortowanie_panel);
        sortowanie_panel = new CustomPanel();
        nazwisko_przycisk = new CustomButton("sortowanie po nazwisku");
        nazwisko_przycisk.addActionListener(new sortowanie_osob());
        nazwisko_wiek_przycisk = new CustomButton("sortowanie po wieku");
        nazwisko_wiek_przycisk.addActionListener(new sortowanie_osob());
        nazwisko_imie_przycisk = new CustomButton("sortowanie po imieniu");
        nazwisko_imie_przycisk.addActionListener(new sortowanie_osob());

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
        prowadzacy_przycisk.addActionListener(new sortowanie_kursow());
        ECTS_przycisk = new CustomButton("sortowanie po ECTS");
        ECTS_przycisk.addActionListener(new sortowanie_kursow());

        sortowanie_panel.add(prowadzacy_przycisk);
        sortowanie_panel.add(ECTS_przycisk);

        this.add(sortowanie_panel);

        revalidate();
        repaint();
    }
    private ArrayList<Osoba>  lista_obecna = new ArrayList<>();
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sort_kursow_przycisk)
            dodaj_sortowanie_kursow();

        if(e.getSource() == sort_studentow_przycisk){
            dodaj_srotowanie_osob();
            lista_obecna = (lista_studentow);
        }
        if(e.getSource() == sort_pracownikow_przycisk){
            dodaj_srotowanie_osob();
            lista_obecna = (lista_pracownikow);
        }
    }

    class sortowanie_osob implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == nazwisko_imie_przycisk){
                if (lista_obecna.get(0) instanceof Student)
                    sortowanie_nazwisko_imie(lista_studentow);
                else
                    sortowanie_nazwisko_imie(lista_pracownikow);
            }

            if (e.getSource() == nazwisko_przycisk){
                if (lista_obecna.get(0) instanceof Student)
                    sortowanie_nazwisko(lista_studentow);
                else
                    sortowanie_nazwisko(lista_pracownikow);
            }
            if (e.getSource() == nazwisko_wiek_przycisk){
                if (lista_obecna.get(0) instanceof Student)
                    sortowanie_nazwisko_wiek(lista_studentow);
                else
                    sortowanie_nazwisko_wiek(lista_pracownikow);
            }

        }
    }
    private void sortowanie_nazwisko (ArrayList<Osoba> lista){
        lista.sort(Comparator.comparing(Osoba::getNazwisko));
    }
    private void sortowanie_nazwisko_wiek (ArrayList<Osoba> lista){
        lista.sort((o1, o2) -> {
            if (Objects.equals(o1.getNazwisko(), o2.getNazwisko())) {
                return o1.getWiek() - o2.getWiek();
            } else {
                return o1.getNazwisko().compareTo(o2.getNazwisko());
            }
        });
    }
    private void sortowanie_nazwisko_imie ( ArrayList<Osoba> lista){
        lista.sort((o1, o2) -> {
            if (Objects.equals(o1.getNazwisko(), o2.getNazwisko())) {
                return o2.getImie().compareTo(o1.getImie());
            } else {
                return o1.getNazwisko().compareTo(o2.getNazwisko());
            }
        });
    }

    class sortowanie_kursow implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == prowadzacy_przycisk)
                lista_kursow.sort(Comparator.comparing((Kursy k) -> k.getWykladowca().getNazwisko()));
            if (e.getSource() == ECTS_przycisk)
                lista_kursow.sort(Comparator.comparingInt(Kursy::getECTS));
        }
    }
}
