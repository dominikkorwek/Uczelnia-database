package frontend.PopUp.dodawanie_package;

import backend.klasy.Kursy;
import backend.klasy.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Dodaj_kurs_studentowi_popup extends Dodawanie_abstract{
    public Dodaj_kurs_studentowi_popup(){
        dodaj_kurs_studentowi();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message ="";
        message += wiadomosc_bledu_kurs_studentowi(message);
        if (message.isEmpty()){
            Student student = (Student) studenci_list.getSelectedItem();
            Kursy kurs = (Kursy) kursy_list.getSelectedItem();
            assert student != null;
            student.getKursy_studenta().add(kurs);
            wylacz();
        }
        else {
            JOptionPane.showMessageDialog(null,message);
        }
    }
}
