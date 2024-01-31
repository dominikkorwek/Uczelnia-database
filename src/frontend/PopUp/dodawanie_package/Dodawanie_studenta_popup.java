package frontend.PopUp.dodawanie_package;

import backend.enumy.plec_enum;
import backend.klasy.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static backend.Bazy_danych_package.Bazy_danych.lista_studentow;
import static backend.menager_list.menager_list.dodaj_na_liste;

public class Dodawanie_studenta_popup extends Dodawanie_abstract{
    public Dodawanie_studenta_popup(){
        dodaj_wybory_studenta();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String message = "";
        message += wiadomosc_bledu_osoba(message);
        message += wiadomosc_bledu_student(message);
        if (message.isEmpty()){
            Student student = new Student();
            dodaj_osobe(student);
            dodaj_studenta(student);
            System.out.println("dodano");
            dodaj_na_liste(lista_studentow,student);
            wylacz();
        }
        else {
            JOptionPane.showMessageDialog(null,message);
        }
    }
}
