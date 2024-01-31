package backend.klasy;

import backend.enumy.plec_enum;

public class Pracownik_badawczo_dydaktyczny extends Pracownik_uczelni{
    private int liczba_publikacji;


    public Pracownik_badawczo_dydaktyczny() {
    }

    @Override
    public String toString(){
        return super.toString() +
                " liczba publikacji: " + getLiczba_publikacji();
    }

    @Override
    public boolean czy_zawiera_usuwanie(String szukana) {
        return super.czy_zawiera_usuwanie(szukana);
    }

    @Override
    public boolean czy_zawiera_szukana(String szukana) {
        return super.czy_zawiera_szukana(szukana);
    }

    public int getLiczba_publikacji() {
        return liczba_publikacji;
    }

    public void setLiczba_publikacji(int liczba_publikacji) {
        this.liczba_publikacji = liczba_publikacji;
    }



}
