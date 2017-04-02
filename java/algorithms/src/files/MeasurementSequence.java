package files;

import java.io.Serializable;


public class MeasurementSequence implements Serializable {

    private static final long serialVersionUID = 8413630658568799165L;
    Measurement[] measurements;
    int curr = 0;
    double warmingTemperature;

    public MeasurementSequence(int size, double ociep) {
        measurements = new Measurement[size];
        warmingTemperature = ociep;
    }

    public void add(Measurement measurement) {
        if (curr < measurements.length) {
            measurements[curr] = measurement;
            curr++;
        }
        else System.out.println("Measure already exists");
    }

    public void addChronologically(Measurement measurement) {
        add(measurement);
        int size = curr - 1;
        Measurement temp;
        for (int i = 0; i < curr; i++) {
            for (int j = 0; j < size; j++) {
                if (measurements[j].time.day > measurements[j + 1].time.day) {
                    temp = measurements[j];
                    measurements[j] = measurements[j + 1];
                    measurements[j + 1] = temp;
                }
            }
            size--;
        }
    }

    public void print(int month, int year, boolean onlyWarming) {
        for (int i = 0; i < curr; i++) {
            if (measurements[i].time.month == month && measurements[i].time.year == year) {
                if (!onlyWarming || measurements[i].temperature > warmingTemperature)
                    System.out.printf("%02d.%02d.%4d - %5.2f\n", measurements[i].time.day, month, year, measurements[i].temperature);
            }
        }
        System.out.println();
    }

}
