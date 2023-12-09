package klasy;

import enumy.plec_enum;
import enumy.stanowisko_badawczo_dydaktyczne_enum;

public class Pracownik_badawczo_dydaktyczny extends Pracownik_uczelni{
    private int liczba_publikacji;


    public Pracownik_badawczo_dydaktyczny(String imie, String nazwisko, String pesel, int wiek, plec_enum plec, stanowisko_badawczo_dydaktyczne_enum stanowisko, int straz_pracy, float pensja, int liczba_publikacji) {
        super(imie, nazwisko, pesel, wiek, plec,stanowisko.toString(), straz_pracy, pensja);
        this.liczba_publikacji = liczba_publikacji;

    }

    @Override
    public String toString(){
        return super.toString() +
                " liczba publikacji: " + getLiczba_publikacji();
    }

    public int getLiczba_publikacji() {
        return liczba_publikacji;
    }

    public void setLiczba_publikacji(int liczba_publikacji) {
        this.liczba_publikacji = liczba_publikacji;
    }



}
