package frontend.PopUp.dodawanie_package;

import backend.klasy.*;
import frontend.customView.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import backend.enumy.*;

import static backend.Bazy_danych_package.Bazy_danych.*;


public abstract class Dodawanie_abstract extends JFrame implements ActionListener {
    CustomPanel panel_wyboru;
    CustomButton akceptuj_przycisk;
    CustomTextField imie_field;
    CustomTextField nazwisko_field;
    CustomTextField pesel_field;
    CustomTextField wiek_field;
    JComboBox plec_field;
    CustomTextField indeks_field;
    CustomTextField rok_field;
    CustomCheckBox erasmus_field;
    CustomCheckBox stopien_field;
    CustomCheckBox stacjonarne_field;
    CustomTextField staz_field;
    CustomTextField pensja_field;
    JComboBox stanowisko;
    CustomTextField nagodziny_field;
    CustomTextField publikacje_field;
    CustomTextField nazwa_field;
    CustomTextField ECTS_field;
    JComboBox<Pracownik_badawczo_dydaktyczny> wykladowca_list;
    JComboBox<Osoba> studenci_list;
    JComboBox<Kursy> kursy_list;


    public Dodawanie_abstract() {
        this.setTitle("Dodawanie obiektow");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,500);
        akceptuj_przycisk = new CustomButton("akceptuj");
        akceptuj_przycisk.addActionListener(this);
        panel_wyboru = new CustomPanel();

        panel_wyboru.add(akceptuj_przycisk);

        this.getContentPane().add(panel_wyboru);
        this.setVisible(true);
    }

    public void dodaj_wybory_osoby() {
        imie_field = new CustomTextField("podaj imie");
        nazwisko_field = new CustomTextField("podaj nazwisko");
        pesel_field = new CustomTextField("podaj pesel");
        wiek_field = new CustomTextField("podaj wiek");
        plec_field = new JComboBox<>(plec_enum.values());

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

        panel_wyboru.add(staz_field);
        panel_wyboru.add(pensja_field);

    }

    public void dodaj_wybory_pracownika_admini() {
        dodaj_wybory_pracownika();

        nagodziny_field = new CustomTextField("liczba nadgodzin");
        stanowisko = new JComboBox<>(stanowisko_administracyjne_enum.values());


        panel_wyboru.add(nagodziny_field);
        panel_wyboru.add(stanowisko);
    }

    public void dodaj_wybory_pracownika_badawcz() {
        dodaj_wybory_pracownika();

        publikacje_field = new CustomTextField("ilosc publikacji");

        stanowisko = new JComboBox<>(stanowisko_badawczo_dydaktyczne_enum.values());

        panel_wyboru.add(publikacje_field);
        panel_wyboru.add(stanowisko);
    }

    public void dodaj_kurs_studentowi(){
        studenci_list = new JComboBox<>(lista_studentow.toArray(new Osoba[0]));
        kursy_list = new JComboBox<>(lista_kursow.toArray(new Kursy[0]));

        panel_wyboru.add(studenci_list);
        panel_wyboru.add(kursy_list);
    }
    public void dodaj_kurs(){
        nazwa_field = new CustomTextField("nazwa kursu");
        ECTS_field = new CustomTextField("ECTS");
        wykladowca_list = new JComboBox<>(lista_wykladowcow.toArray(new Pracownik_badawczo_dydaktyczny[0]));
        panel_wyboru.add(nazwa_field);
        panel_wyboru.add(ECTS_field);
        panel_wyboru.add(wykladowca_list);
    }

    @Override
    public abstract void actionPerformed(ActionEvent e);

    public String wiadomosc_bledu_osoba(String message){
        if (czy_zawiera_liczbe(imie_field.getText())||imie_field.getText().isEmpty())
            message+="Nieprawidlowe imie\n";
        if (czy_zawiera_liczbe(nazwisko_field.getText())||nazwisko_field.getText().isEmpty())
            message+="Nieprawidlowe nazwisko\n";
        if (czy_to_int(wiek_field.getText())||wiek_field.getText().isEmpty())
            message+="Nieprawidlowy pesel\n";
        if (czy_to_int(pesel_field.getText())||pesel_field.getText().isEmpty())
            message+="Nieprawidlowy wiek\n";
        if (plec_field.getSelectedItem() == null){
            message+="Nieprawidlowa plec\n";
        }
        return message;
    }
    public String wiadomosc_bledu_student(String message){
        if (czy_to_int(indeks_field.getText())||indeks_field.getText().isEmpty())
            message+="Nieprawidlowy indeks\n";
        if (czy_to_int(rok_field.getText())||rok_field.getText().isEmpty())
            message+="Nieprawidlowy rok studiow\n";
        return message;
    }

    public String wiadomosc_bledu_pracownik(String message){
        if(czy_to_int(staz_field.getText())||staz_field.getText().isEmpty())
            message+="Nieprawidlowy staz\n";
        if ( stanowisko.getSelectedItem() == null)
            message+="nieprawidlowe stanowisko";
        if(czy_to_int(pensja_field.getText()) || pensja_field.getText().isEmpty())
            message+="nieprawidlowa pensja\n";
        return message;
    }
    public String wiadomosc_bledu_pracownik_bada(String message){
        if (czy_to_int(publikacje_field.getText()) || publikacje_field.getText().isEmpty())
            message+="nieprawidlowa ilosc publikacji\n";
        return message;
    }
    public String wiadomosc_bledu_pracownik_admini(String message){
        if (czy_to_int(nagodziny_field.getText()) || nagodziny_field.getText().isEmpty())
            message+="nieprawidlowe nadgodziny\n";
        return message;
    }
    public String wiadomosc_bledu_kurs(String message){
        if (czy_to_int(ECTS_field.getText())  || ECTS_field.getText().isEmpty())
            message += "nieprawidlowe ECTS\n";
        if (czy_zawiera_liczbe(nazwa_field.getText()) || nazwa_field.getText().isEmpty())
            message+= "nieprawidlowa nazwa\n";
        return message;
    }
    public String wiadomosc_bledu_kurs_studentowi(String message){
        if (studenci_list.getSelectedItem() == null)
            message+="nieprawidlowy student\n";
        if (kursy_list.getSelectedItem() == null)
            message+="nieprawidlowy kurs\n";
        return message;
    }


    public boolean czy_to_int(String nazwa){
        if (nazwa.isEmpty()){
            return true;
        }
        try{
            int numer = Integer.parseInt(nazwa);
        }catch (Exception e){
            return true;
        }
        return false;
    }
    public boolean czy_zawiera_liczbe(String nazwa){
        for (int i=0;i<nazwa.length();i++)
            if (Character.isDigit(nazwa.charAt(i))) {
                return true;
            }
        return false;
    }

    public void dodaj_osobe(Osoba osoba){
        osoba.setImie(imie_field.getText());
        osoba.setNazwisko(nazwisko_field.getText());
        osoba.setPesel(pesel_field.getText());
        osoba.setPlec(( plec_field.getSelectedItem()).toString());
        osoba.setWiek(Integer.parseInt(wiek_field.getText()));
    }
    public void dodaj_pracownika(Pracownik_uczelni pracownik){
        pracownik.setStraz_pracy(Integer.parseInt(staz_field.getText()));
        pracownik.setPensja(Float.parseFloat(pensja_field.getText()));
        pracownik.setStanowisko( stanowisko.getSelectedItem().toString());
    }
    public void dodaj_pracownika_admini(Pracownik_administracyjny pracownik){
        pracownik.setLiczba_nadgodzin(Float.parseFloat(nagodziny_field.getText()));
    }
    public void dodaj_pracownika_bada(Pracownik_badawczo_dydaktyczny pracownik){
        pracownik.setLiczba_publikacji(Integer.parseInt(publikacje_field.getText()));
    }
    public void dodaj_kurs(Kursy kurs){
        kurs.setNazwa_kursu(nazwa_field.getText());
        kurs.setECTS(Integer.parseInt(ECTS_field.getText()));
        kurs.setWykladowca((Pracownik_badawczo_dydaktyczny) wykladowca_list.getSelectedItem());
    }
    public void dodaj_studenta(Student student){
        student.setStudent_I_stopnia(stopien_field.isSelected());
        student.setStudent_II_stopnia(!stopien_field.isSelected());
        student.setNr_indeksu(Integer.parseInt(indeks_field.getText()));
        student.setRok_studiow(Integer.parseInt(rok_field.getText()));
        student.setStudia_stacjonarne(stacjonarne_field.isSelected());
        student.setStudia_niestacjonarne(!stacjonarne_field.isSelected());
        student.setUczestnik_ERASMUS(erasmus_field.isSelected());
    }
    public void wylacz(){
        JOptionPane.showMessageDialog(null,"dodano obiekt");
        this.dispose();
    }

}
