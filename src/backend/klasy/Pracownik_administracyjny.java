package backend.klasy;


import backend.enumy.plec_enum;

public class Pracownik_administracyjny extends Pracownik_uczelni{
    private float liczba_nadgodzin;

    public Pracownik_administracyjny(String imie, String nazwisko, String pesel, int wiek, plec_enum plec, int staz_pracy, float pensja, String stanowisko, float liczba_nadgodzin) {
        super(imie, nazwisko, pesel, wiek, plec, staz_pracy, pensja, stanowisko);
        this.liczba_nadgodzin = liczba_nadgodzin;
    }

    public Pracownik_administracyjny() {
    }

    @Override
    public boolean czy_zawiera_szukana(String szukana) {
        return super.czy_zawiera_szukana(szukana) ||
               String.valueOf(getLiczba_nadgodzin()).contains(szukana) ;
    }

    @Override
    public boolean czy_zawiera_usuwanie(String szukana) {
        return super.czy_zawiera_usuwanie(szukana);
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
