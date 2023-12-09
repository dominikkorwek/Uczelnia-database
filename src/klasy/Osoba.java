package klasy;


import enumy.plec_enum;
import interfejsy.czy_obiekt_zawiera_szukana_interface;

public abstract class Osoba implements czy_obiekt_zawiera_szukana_interface {
    private String imie;
    private String nazwisko;
    private String pesel;
    private int wiek;
    private plec_enum plec;

    public Osoba(String imie, String nazwisko, String pesel, int wiek, plec_enum plec) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.wiek = wiek;
        this.plec = plec;
    }

    @Override
    public boolean czy_zawiera(String szukana) {
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

    public plec_enum getPlec() {
        return plec;
    }

    public void setPlec(plec_enum plec) {
        this.plec = plec;
    }



}
