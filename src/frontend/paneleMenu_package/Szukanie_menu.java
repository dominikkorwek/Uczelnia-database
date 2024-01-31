package frontend.paneleMenu_package;

import backend.interfejsy.czy_obiekt_zawiera_szukana_interface;
import frontend.PopUp.Szukanie_popUp;
import frontend.customView.CustomButton;
import frontend.customView.CustomPanel;
import frontend.customView.CustomRadioButton;
import frontend.customView.CustomTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static backend.Bazy_danych_package.Bazy_danych.*;

public class Szukanie_menu <T> extends CustomPanel implements ActionListener {
    private CustomRadioButton szukaj_studenta_przycisk;
    private CustomRadioButton szukaj_kurs_przycisk;
    private CustomRadioButton szukaj_pracownika_przycisk;
    private CustomRadioButton szukaj_wszystko_przycisk;
    private CustomTextField podaj_wartosc;
    private CustomButton potwierdz_przycisk;
    private CustomPanel panel_gorny;
    private CustomPanel panel_dolny;
    private String szukana;

    public Szukanie_menu(){
        szukaj_studenta_przycisk = new CustomRadioButton("szukaj danego studenta");
        szukaj_studenta_przycisk.addActionListener(this);

        szukaj_kurs_przycisk = new CustomRadioButton("szukaj dany kurs");
        szukaj_kurs_przycisk.addActionListener(this);

        szukaj_pracownika_przycisk = new CustomRadioButton("szukaj danego pracownika");
        szukaj_pracownika_przycisk.addActionListener(this);

        szukaj_wszystko_przycisk = new CustomRadioButton("szukaj dowolne");
        szukaj_wszystko_przycisk.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(szukaj_studenta_przycisk);
        group.add(szukaj_kurs_przycisk);
        group.add(szukaj_pracownika_przycisk);
        group.add(szukaj_wszystko_przycisk);

        podaj_wartosc = new CustomTextField("podaj wartosc");


        potwierdz_przycisk = new CustomButton("akceptuj");
        potwierdz_przycisk.addActionListener(this);

        panel_gorny = new CustomPanel();
        panel_gorny.add(szukaj_studenta_przycisk);
        panel_gorny.add(szukaj_kurs_przycisk);
        panel_gorny.add(szukaj_pracownika_przycisk);
        panel_gorny.add(szukaj_wszystko_przycisk);

        panel_dolny = new CustomPanel();
        panel_dolny.setLayout(new FlowLayout());
        panel_dolny.add(potwierdz_przycisk);
        panel_dolny.add(podaj_wartosc);

        this.add(panel_gorny);
        this.add(panel_dolny);
    }
    private ArrayList<T> lista = new ArrayList<>();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == szukaj_studenta_przycisk){
            lista.clear();
            lista.addAll((Collection<? extends T>) lista_studentow);
        }
        if (e.getSource() == szukaj_pracownika_przycisk){
            lista.clear();
            lista.addAll((Collection<? extends T>) lista_pracownikow);
        }
        if (e.getSource() == szukaj_kurs_przycisk){
            lista.clear();
            lista.addAll((Collection<? extends T>) lista_kursow);
        }
        if (e.getSource() == szukaj_wszystko_przycisk){
            lista.clear();
            lista.addAll((Collection<? extends T>) lista_studentow);
            lista.addAll((Collection<? extends T>) lista_pracownikow);
            lista.addAll((Collection<? extends T>) lista_kursow);
        }
        if (e.getSource() == potwierdz_przycisk){
            szukana = podaj_wartosc.getText();
            System.out.println(lista);
            if (!szukana.isEmpty() && lista!=null) {
                JFrame frame = new Szukanie_popUp((ArrayList<? extends czy_obiekt_zawiera_szukana_interface>) lista,szukana);
            }
            else {
                JOptionPane.showMessageDialog(null,"sprobuj ponownie");
            }
        }
    }
}
