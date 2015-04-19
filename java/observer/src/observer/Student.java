package board;

import java.util.Observable;
import java.util.Observer;


public class Student implements Observer {
    private String name;
    private String surname;
    private String email_address;

    public Student(String name, String surname, String email_address) {
        this.name = name;
        this.surname = surname;
        this.email_address = email_address;
    }

    public String get_full_name() {
        return String.format("%s %s", this.name, this.surname);
    }

    public void update(Observable o, Object url) {
        String subject = "Update is comming";
        String content = String.format("Hi %s!\nCheck your update on %s", get_full_name(), url);

        MailUtils.send(this.email_address, subject, content);

    }
}
