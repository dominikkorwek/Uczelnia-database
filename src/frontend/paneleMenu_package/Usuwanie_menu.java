package frontend.paneleMenu_package;

import frontend.customView.CustomButton;
import frontend.customView.CustomPanel;
import frontend.customView.CustomRadioButton;
import frontend.customView.CustomTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Usuwanie_menu extends CustomPanel implements ActionListener {
    private CustomPanel panel_wyboru = new CustomPanel();
    private CustomRadioButton po_szukanej_przycisk;
    private CustomRadioButton po_powtorzeniach_przycisk;
    private CustomButton studenci_przycisk;
    private CustomButton pracownicy_przycisk;
    private CustomButton kursy_przycisk;
    private CustomTextField podaj_wartosc;
    private CustomButton akceptuj;
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
        pracownicy_przycisk = new CustomButton("usun z pracownikow");

        panel_wyboru.add(studenci_przycisk);
        panel_wyboru.add(pracownicy_przycisk);

        this.add(panel_wyboru);

        revalidate();
        repaint();
    }
    public void dodaj_usuwanie_wszystkiego(){
        dodaj_usuwanie_osob();
        kursy_przycisk = new CustomButton("usun z kursow");

        panel_wyboru.add(kursy_przycisk);

        podaj_wartosc = new CustomTextField("podaj wartosc");
        akceptuj = new CustomButton("potwierdz");

        CustomPanel panel = new CustomPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(akceptuj);
        panel.add(podaj_wartosc);

        panel_wyboru.add(panel);

        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == po_szukanej_przycisk)
            dodaj_usuwanie_wszystkiego();
        else
            dodaj_usuwanie_osob();
    }
}
