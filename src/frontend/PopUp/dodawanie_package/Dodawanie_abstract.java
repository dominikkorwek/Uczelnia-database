package frontend.PopUp.dodawanie_package;

import frontend.customView.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public abstract class Dodawanie_abstract extends JFrame implements ActionListener {
    CustomPanel panel_wyboru;
    CustomButton akceptuj_przycisk;
    CustomTextField imie_field;
    CustomTextField nazwisko_field;
    CustomTextField pesel_field;
    CustomTextField wiek_field;
    CustomTextField plec_field;
    CustomTextField indeks_field;
    CustomTextField rok_field;
    CustomCheckBox erasmus_field;
    CustomCheckBox stopien_field;
    CustomCheckBox stacjonarne_field;
    CustomTextField staz_field;
    CustomTextField pensja_field;
    CustomTextField stanowisko;
    CustomTextField nagodziny_field;
    CustomTextField publikacje_field;
    CustomTextField nazwa_field;
    CustomTextField ECTS_field;
    JComboBox wykladowca_list;

    private String[] typy_plci = {"M","K","mezczyzna","kobieta","Mezczyzna","Kobieta"};


    public Dodawanie_abstract() {
        this.setTitle("Dodawanie obiektow");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,500);

        akceptuj_przycisk.addActionListener(this);
        panel_wyboru.add(akceptuj_przycisk);

        this.getContentPane().add(panel_wyboru);
        this.setVisible(true);
    }

    public void dodaj_wybory_osoby() {
        CustomTextField imie_field = new CustomTextField("podaj imie");
        CustomTextField nazwisko_field = new CustomTextField("podaj nazwisko");
        CustomTextField pesel_field = new CustomTextField("podaj pesel");
        CustomTextField wiek_field = new CustomTextField("podaj wiek");
        CustomTextField plec_field = new CustomTextField("podaj plec");

        panel_wyboru.add(imie_field);
        panel_wyboru.add(nazwisko_field);
        panel_wyboru.add(pesel_field);
        panel_wyboru.add(wiek_field);
        panel_wyboru.add(plec_field);
    }

    public void dodaj_wybory_studenta() {
        dodaj_wybory_osoby();

        indeks_field = new CustomTextField("podaj indeks");
        rok_field = new CustomTextField("podaj rok");
        erasmus_field = new CustomCheckBox("uczestnik erasmus");
        stopien_field = new CustomCheckBox("czy to student I stopnia");
        stacjonarne_field = new CustomCheckBox("ma studia stacjonarne");

        panel_wyboru.add(indeks_field);
        panel_wyboru.add(rok_field);
        panel_wyboru.add(erasmus_field);
        panel_wyboru.add(stopien_field);
        panel_wyboru.add(stacjonarne_field);
    }

    public void dodaj_wybory_pracownika() {
        dodaj_wybory_osoby();

        staz_field = new CustomTextField("staz pracy");
        pensja_field = new CustomTextField("pensja");
        stanowisko = new CustomTextField("stanowisko");

        panel_wyboru.add(staz_field);
        panel_wyboru.add(pensja_field);
        panel_wyboru.add(stanowisko);

    }

    public void dodaj_wybory_pracownika_admini() {
        dodaj_wybory_pracownika();

        nagodziny_field = new CustomTextField("liczba nadgodzin");

        panel_wyboru.add(nagodziny_field);

    }

    public void dodaj_wybory_pracownika_badawcz() {
        dodaj_wybory_pracownika();

        publikacje_field = new CustomTextField("ilosc publikacji");

        panel_wyboru.add(publikacje_field);
    }

    public void dodaj_kurs_studentowi(){

    }
    public void dodaj_kurs(){
        nazwa_field = new CustomTextField("nazwa kursu");
        ECTS_field = new CustomTextField("ECTS");
        wykladowca_list = new JComboBox();

        panel_wyboru.add(nazwa_field);
        panel_wyboru.add(ECTS_field);
        panel_wyboru.add(wykladowca_list);
    }

    @Override
    public abstract void actionPerformed(ActionEvent e);
    /*
    public String wiadomosc_bledu_osoba(String message){
        if (czy_zawiera_liczbe(imie_field.getText())||imie_field.getText()==null)
            message+="Nieprawidlowe imie\n";
        if (czy_zawiera_liczbe(imie_field.getText())||nazwisko_field.getText()==null)
            message+="Nieprawidlowe nazwisko\n";
        if (czy_to_int(nazwa_field.getText())||nazwa_field.getText()==null)
            message+="Nieprawidlowy pesel\n";
        if (czy_to_int(nazwa_field.getText())||nazwa_field.getText()==null)
            message+="Nieprawidlowy wiek\n";
        if (czy_zawiera_liczbe(plec_field.getText())||plec_field.getText()==null){
            boolean prawidlowe = false;
            for (String s : typy_plci)
                if (s == plec_field.getText())
                    prawidlowe = true;
            if (!prawidlowe)
                message+="Nieprawidlowa plec(Wybierz M lub K)\n";
        }
        return message;
    }
    public String wiadomosc_bledu_student(String message){
        if (czy_to_int(indeks_field.getText())||indeks_field.getText()==null)
            message+="Nieprawidlowy indeks\n";
        if (czy_to_int(rok_field.getText())||rok_field.getText()==null)
            message+="Nieprawidlowy rok studiow\n";
        return message;
    }


    public boolean czy_to_int(String nazwa){
        try{
            int numer = Integer.parseInt(nazwa);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
    public boolean czy_zawiera_liczbe(String nazwa){
        for (int i=0;i<nazwa.length();i++)
            if (Character.isDigit(nazwa.charAt(i))) {
                return true;
            }
        return false;
    }

     */

}
