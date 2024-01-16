package backend.klasy;

import backend.interfejsy.ObserwowanyStudenci_interface;

import java.util.ArrayList;

public class Uczelnia implements ObserwowanyStudenci_interface {
    private Uczelnia(){}
    public static  Uczelnia instance;

    public static Uczelnia getInstance(){
        if (instance == null) {
            instance = new Uczelnia();
        }
        return instance;
    }

    private ArrayList<Student> studenci = new ArrayList<>();


    @Override
    public void zrejestrujObserwatora(Student obiekt) {
        getStudenci().add(obiekt);
    }

    @Override
    public void usunObserwatora(Student obiekt) {
        getStudenci().remove(obiekt);
    }

    @Override
    public void aktualizuj_rok_studiow() {
        for (Student student : getStudenci()){
            student.aktualizuj_rok_studiow();
        }
    }

    public ArrayList<Student> getStudenci() {
        return studenci;
    }

    public void setStudenci(ArrayList<Student> studenci) {
        this.studenci = studenci;
    }
}
