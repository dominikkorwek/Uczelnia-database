package backend.interfejsy;

import backend.klasy.Student;

public interface ObserwowanyStudenci_interface {
    void zrejestrujObserwatora(Student obiekt);
    void usunObserwatora(Student obiekt);
    void aktualizuj_rok_studiow();
}
