package backend.klasy;

import backend.interfejsy.czy_obiekt_zawiera_szukana_interface;

import java.io.Serial;
import java.io.Serializable;

public class Kursy implements czy_obiekt_zawiera_szukana_interface, Serializable {
    @Serial
    private static final long serialVersionUID = 2895670990255762290L;

    private String nazwa_kursu;
    private int ECTS;
    private Pracownik_badawczo_dydaktyczny wykladowca;

    @Override
    public boolean czy_zawiera_szukana(String szukana) {
        return getNazwa_kursu().contains(szukana) ||
                String.valueOf(getECTS()).contains(szukana) ||
                getWykladowca().czy_zawiera_szukana(szukana);
    }

    @Override
    public boolean czy_zawiera_usuwanie(String szukana) {
        return getNazwa_kursu().contains(szukana) ||
                getWykladowca().getNazwisko().contains(szukana) ||
                String.valueOf(getECTS()).contains(szukana);
    }

    @Override
    public String toString(){
        return " nazwa kursu: " + getNazwa_kursu()+
                " ECTS: " + getECTS() +
                " Wykladowca: "+ getWykladowca().toString();
    }
    public String getNazwa_kursu() {
        return nazwa_kursu;
    }

    public void setNazwa_kursu(String nazwa_kursu) {
        this.nazwa_kursu = nazwa_kursu;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }

    public Pracownik_badawczo_dydaktyczny getWykladowca() {
        return wykladowca;
    }

    public void setWykladowca(Pracownik_badawczo_dydaktyczny wykladowca) {
        this.wykladowca = wykladowca;
    }




}
