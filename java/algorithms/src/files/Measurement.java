package files;

import java.io.Serializable;


public class Measurement implements Serializable {

    private static final long serialVersionUID = 1L;
    Time time;
    double temperature;

    public Measurement(Time time, double temp) {
        this.time = time;
        temperature = temp;
    }
}
