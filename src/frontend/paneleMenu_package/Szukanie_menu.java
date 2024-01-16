package frontend.paneleMenu_package;

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
    private JPanel panel_gorny;
    private JPanel panel_dolny;
    private ArrayList<T> lista;
    private String szukana;

    public Szukanie_menu(){
        szukaj_studenta_przycisk = new CustomRadioButton("szukaj danego studenta");
        szukaj_kurs_przycisk = new CustomRadioButton("szukaj dany kurs");
        szukaj_pracownika_przycisk = new CustomRadioButton("szukaj danego pracownika");
        szukaj_wszystko_przycisk = new CustomRadioButton("szukaj dowolne");

        ButtonGroup group = new ButtonGroup();
        group.add(szukaj_studenta_przycisk);
        group.add(szukaj_kurs_przycisk);
        group.add(szukaj_pracownika_przycisk);
        group.add(szukaj_wszystko_przycisk);

        podaj_wartosc = new CustomTextField("podaj wartosc");
        podaj_wartosc.setSize(100,50);


        potwierdz_przycisk = new CustomButton("akceptuj");
        potwierdz_przycisk.addActionListener(this);

        panel_gorny = new JPanel();
        panel_gorny.add(szukaj_studenta_przycisk);
        panel_gorny.add(szukaj_kurs_przycisk);
        panel_gorny.add(szukaj_pracownika_przycisk);
        panel_gorny.add(szukaj_wszystko_przycisk);

        panel_dolny = new JPanel();
        panel_dolny.setLayout(new FlowLayout());
        panel_dolny.add(potwierdz_przycisk);
        panel_dolny.add(podaj_wartosc);

        this.add(panel_gorny);
        this.add(panel_dolny);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lista.clear();
        if (e.getSource() == szukaj_studenta_przycisk)
            lista = (ArrayList<T>) lista_studentow;
        if (e.getSource() == szukaj_pracownika_przycisk)
            lista = (ArrayList<T>) lista_pracownikow;
        if (e.getSource() == szukaj_kurs_przycisk)
            lista = (ArrayList<T>) lista_kursow;
        if (e.getSource() == szukaj_wszystko_przycisk){
            lista.addAll((Collection<? extends T>) lista_studentow);
            lista.addAll((Collection<? extends T>) lista_pracownikow);
            lista.addAll((Collection<? extends T>) lista_kursow);
        }

        if (e.getSource() == potwierdz_przycisk){
            szukana = podaj_wartosc.getText();
            if (szukana!=null && lista!=null) {
                JFrame frame = new Szukanie_popUp(lista,szukana);
            }
        }
    }
}
