package frontend.paneleMenu_package;

import frontend.customView.CustomButton;
import frontend.customView.CustomPanel;
import frontend.customView.CustomRadioButton;
import frontend.customView.CustomTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

import static backend.Bazy_danych_package.Bazy_danych.*;
import static backend.menager_list.menager_list.*;

public class Usuwanie_menu extends CustomPanel implements ActionListener {
    private CustomPanel panel_wyboru = new CustomPanel();
    private CustomRadioButton po_szukanej_przycisk;
    private CustomRadioButton po_powtorzeniach_przycisk;
    private CustomButton studenci_przycisk;
    private CustomButton pracownicy_przycisk;
    private CustomButton kursy_przycisk;
    private CustomTextField podaj_wartosc;
    public Usuwanie_menu(){
        po_szukanej_przycisk = new CustomRadioButton("usun po szukanej");
        po_szukanej_przycisk.addActionListener(this);
        po_powtorzeniach_przycisk = new CustomRadioButton("usun powtorzenia");
        po_powtorzeniach_przycisk.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(po_powtorzeniach_przycisk);
        group.add(po_szukanej_przycisk);


        this.add(po_powtorzeniach_przycisk);
        this.add(po_szukanej_przycisk);
        this.add(panel_wyboru);
    }

    public void dodaj_usuwanie_osob(){
        remove(panel_wyboru);
        panel_wyboru = new CustomPanel();

        studenci_przycisk = new CustomButton("usun z studentow");
        studenci_przycisk.addActionListener(new usuwanie());
        pracownicy_przycisk = new CustomButton("usun z pracownikow");
        pracownicy_przycisk.addActionListener(new usuwanie());

        panel_wyboru.add(studenci_przycisk);
        panel_wyboru.add(pracownicy_przycisk);

        this.add(panel_wyboru);

        revalidate();
        repaint();
    }
    public void dodaj_usuwanie_wszystkiego(){
        dodaj_usuwanie_osob();
        kursy_przycisk = new CustomButton("usun z kursow");
        kursy_przycisk.addActionListener(new usuwanie());

        panel_wyboru.add(kursy_przycisk);

        podaj_wartosc = new CustomTextField("podaj wartosc");

        CustomPanel panel = new CustomPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(podaj_wartosc);

        panel_wyboru.add(panel);

        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == po_szukanej_przycisk)
            dodaj_usuwanie_wszystkiego();
        if (e.getSource() == po_powtorzeniach_przycisk)
            dodaj_usuwanie_osob();
    }
    class usuwanie implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (po_powtorzeniach_przycisk.isSelected()){
                if (e.getSource() == studenci_przycisk){
                    usun_powtorzenia_z_listy(lista_studentow);
                }
                if (e.getSource() == pracownicy_przycisk){
                    usun_powtorzenia_z_listy(lista_pracownikow);
                    usun_powtorzenia_z_listy(lista_wykladowcow);
                }
            }

            if (po_szukanej_przycisk.isSelected()){
                if (podaj_wartosc.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"nie podales wartosci szukanej");
                    return;
                }

                if (e.getSource() == studenci_przycisk){
                    usun_obiekt_z_listy(lista_studentow,podaj_wartosc.getText());
                }
                if (e.getSource() == pracownicy_przycisk){
                    usun_obiekt_z_listy(lista_pracownikow,podaj_wartosc.getText());
                }
                if (e.getSource() == kursy_przycisk){
                    usun_obiekt_z_listy(lista_kursow,podaj_wartosc.getText());
                }
            }
            JOptionPane.showMessageDialog(null,"wykonalem polecenie");
        }
    }
}
