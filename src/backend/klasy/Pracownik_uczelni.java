package backend.klasy;


import backend.enumy.plec_enum;

import java.util.Objects;

public abstract class Pracownik_uczelni extends Osoba{

    private int staz_pracy;
    private float pensja;
    private String stanowisko;


    public Pracownik_uczelni() {
    }

    @Override
    public int hashCode(){
        return Objects.hash(getPesel());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pracownik_uczelni pracownik = (Pracownik_uczelni) o;
        return Objects.equals(getPesel(), pracownik.getPesel());
    }

    @Override
    public boolean czy_zawiera_szukana(String szukana) {

        return super.czy_zawiera_szukana(szukana) ||
                getStanowisko().contains(szukana) ||
                String.valueOf(getStraz_pracy()).contains(szukana) ||
                String.valueOf(getPensja()).contains(szukana);
    }

    @Override
    public boolean czy_zawiera_usuwanie(String szukana) {
        return super.czy_zawiera_usuwanie(szukana) ||
                String.valueOf(getStraz_pracy()).contains(szukana) ||
                getStanowisko().contains(szukana);
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
