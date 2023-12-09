package klasy;

import interfejsy.czy_obiekt_zawiera_szukana_interface;

public class Kursy implements czy_obiekt_zawiera_szukana_interface {
    private String nazwa_kursu;
    private int ECTS;

    private Pracownik_badawczo_dydaktyczny wykladowca;

    public Kursy(String nazwa_kursu, int ECTS, Pracownik_badawczo_dydaktyczny wykladowca) {
        this.nazwa_kursu = nazwa_kursu;
        this.ECTS = ECTS;
        this.wykladowca = wykladowca;
    }

    @Override
    public boolean czy_zawiera(String szukana) {
        return getNazwa_kursu().contains(szukana) ||
                String.valueOf(getECTS()).contains(szukana) ||
                getWykladowca().czy_zawiera(szukana);
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
