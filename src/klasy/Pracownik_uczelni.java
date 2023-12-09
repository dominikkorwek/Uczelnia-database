package klasy;

import enumy.plec_enum;

public abstract class Pracownik_uczelni extends Osoba{

    private int staz_pracy;
    private float pensja;
    private String stanowisko;

    public Pracownik_uczelni(String imie, String nazwisko, String pesel, int wiek, plec_enum plec, String stanowisko, int staz_pracy, float pensja) {
        super(imie, nazwisko, pesel, wiek, plec);
        this.stanowisko = stanowisko;
        this.staz_pracy = staz_pracy;
        this.pensja = pensja;
    }

    @Override
    public boolean czy_zawiera(String szukana) {

        return super.czy_zawiera(szukana) ||
                getStanowisko().contains(szukana) ||
                String.valueOf(getStraz_pracy()).contains(szukana) ||
                String.valueOf(getPensja()).contains(szukana);
    }

    @Override
    public String toString(){
        return super.toString()+
                " Stanowisko: "+getStanowisko()+
                " pensja: "+getPensja() +
                " Staz pracy: "+getStraz_pracy();
    }
    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public int getStraz_pracy() {
        return staz_pracy;
    }

    public void setStraz_pracy(int staz_pracy) {
        this.staz_pracy = staz_pracy;
    }

    public float getPensja() {
        return pensja;
    }

    public void setPensja(float pensja) {
        this.pensja = pensja;
    }


}
