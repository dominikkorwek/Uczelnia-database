package klasy;

import enumy.plec_enum;

import java.util.ArrayList;

public class Student extends Osoba {
    private int nr_indeksu;
    private int rok_studiow;

    ArrayList<Kursy> kursy_studenta = new ArrayList<>();
    private boolean uczestnik_ERASMUS;
    private boolean student_I_stopnia;
    private boolean isStudent_II_stopnia;
    private boolean studia_stacjonarne;
    private boolean studia_niestacjonarne;

    public Student(String imie, String nazwisko, String pesel, int wiek, plec_enum plec, int nr_indeksu, int rok_studiow, boolean uczestnik_ERASMUS, boolean student_I_stopnia, boolean isStudent_II_stopnia, boolean studia_stacjonarne, boolean studia_niestacjonarne) {
        super(imie, nazwisko, pesel, wiek, plec);
        this.nr_indeksu = nr_indeksu;
        this.rok_studiow = rok_studiow;
        this.uczestnik_ERASMUS = uczestnik_ERASMUS;
        this.student_I_stopnia = student_I_stopnia;
        this.isStudent_II_stopnia = isStudent_II_stopnia;
        this.studia_stacjonarne = studia_stacjonarne;
        this.studia_niestacjonarne = studia_niestacjonarne;
    }
    public void zapis_na_kurs(Kursy kurs){
        if (!kursy_studenta.contains(kurs) && kurs !=null){
            kursy_studenta.add(kurs);
        }
    }

    @Override
    public boolean czy_zawiera(String szukana) {
        return super.czy_zawiera(szukana) ||
                String.valueOf(getNr_indeksu()).contains(szukana) ||
                String.valueOf(getRok_studiow()).contains(szukana) ||
                getKursy_studenta().toString().contains(szukana);

    }

    @Override
    public String toString(){
        return super.toString()  +
                " nr indeksu: "+getNr_indeksu()+
                " Rok studiow: "+getRok_studiow()+
                " Kursy studenta: "+getKursy_studenta() +
                " Uczestnik ERASMUS: " + isUczestnik_ERASMUS() +
                " Student I stopnia: " + isStudent_I_stopnia() +
                " Student II stopnia: " + isStudent_II_stopnia()+
                " Studia stacjonarne: " + isStudia_stacjonarne() +
                " Studia niestacjonarne: " + isStudia_niestacjonarne();
    }
    public int getNr_indeksu() {
        return nr_indeksu;
    }

    public void setNr_indeksu(int nr_indeksu) {
        this.nr_indeksu = nr_indeksu;
    }

    public int getRok_studiow() {
        return rok_studiow;
    }

    public void setRok_studiow(int rok_studiow) {
        this.rok_studiow = rok_studiow;
    }

    public ArrayList<Kursy> getKursy_studenta() {
        return kursy_studenta;
    }

    public void setKursy_studenta(ArrayList<Kursy> kursy_studenta) {
        this.kursy_studenta = kursy_studenta;
    }

    public boolean isUczestnik_ERASMUS() {
        return uczestnik_ERASMUS;
    }

    public void setUczestnik_ERASMUS(boolean uczestnik_ERASMUS) {
        this.uczestnik_ERASMUS = uczestnik_ERASMUS;
    }

    public boolean isStudent_I_stopnia() {
        return student_I_stopnia;
    }

    public void setStudent_I_stopnia(boolean student_I_stopnia) {
        this.student_I_stopnia = student_I_stopnia;
    }

    public boolean isStudent_II_stopnia() {
        return isStudent_II_stopnia;
    }

    public void setStudent_II_stopnia(boolean student_II_stopnia) {
        isStudent_II_stopnia = student_II_stopnia;
    }

    public boolean isStudia_stacjonarne() {
        return studia_stacjonarne;
    }

    public void setStudia_stacjonarne(boolean studia_stacjonarne) {
        this.studia_stacjonarne = studia_stacjonarne;
    }

    public boolean isStudia_niestacjonarne() {
        return studia_niestacjonarne;
    }

    public void setStudia_niestacjonarne(boolean studia_niestacjonarne) {
        this.studia_niestacjonarne = studia_niestacjonarne;
    }



}
