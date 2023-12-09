package klasy;

import enumy.plec_enum;
import enumy.stanowisko_administracyjne_enum;

public class Pracownik_administracyjny extends Pracownik_uczelni{
    private float liczba_nadgodzin;


    public Pracownik_administracyjny(String imie, String nazwisko, String pesel, int wiek, plec_enum plec, stanowisko_administracyjne_enum stanowisko, int straz_pracy, float pensja, float liczba_nadgodzin) {

        super(imie, nazwisko, pesel, wiek, plec, stanowisko.toString(), straz_pracy, pensja);
        this.liczba_nadgodzin = liczba_nadgodzin;

    }

    @Override
    public boolean czy_zawiera(String szukana) {
        return super.czy_zawiera(szukana) ||
               String.valueOf(getLiczba_nadgodzin()).contains(szukana) ;
    }

    @Override
    public String toString() {
        return super.toString()+
                " liczba nadgodzin: " + getLiczba_nadgodzin();
    }

    public float getLiczba_nadgodzin() {
        return liczba_nadgodzin;
    }

    public void setLiczba_nadgodzin(float liczba_nadgodzin) {
        this.liczba_nadgodzin = liczba_nadgodzin;
    }



}
