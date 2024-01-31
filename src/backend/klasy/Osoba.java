package backend.klasy;


import backend.enumy.plec_enum;
import backend.interfejsy.czy_obiekt_zawiera_szukana_interface;

import java.io.Serial;
import java.io.Serializable;

public abstract class Osoba implements czy_obiekt_zawiera_szukana_interface, Serializable {
    @Serial
    private static final long serialVersionUID = 3895660990255762290L;

    private String imie;
    private String nazwisko;
    private String pesel;
    private int wiek;
    private String plec;


    public Osoba() {
    }

    @Override
    public boolean czy_zawiera_szukana(String szukana) {
        return getImie().contains(szukana) ||
                getNazwisko().contains(szukana);
    }

    @Override
    public boolean czy_zawiera_usuwanie(String szukana) {
        return getImie().contains(szukana) ||
                getNazwisko().contains(szukana);
    }

    @Override
    public String toString(){

        return " imie: "+ getImie()+
                " nazwisko: "+getNazwisko()+
                " wiek: " + getWiek()+
                " plec: " + getPlec() +
                " pesel: " + getPesel();
    }
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }



}
