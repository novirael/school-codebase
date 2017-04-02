package files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;


public class Zad4 {
    public static void main(String args[]) throws ClassNotFoundException
    {
        // Zad3
        MeasurementSequence sequence = new MeasurementSequence(100, 25);

        generateInitialData(sequence);

        System.out.println("Measurements from April 2014");
        sequence.print(4, 2014, false);

        System.out.println("Measurements from April 2014 with warming");
        sequence.print(4, 2014, true);

        System.out.println("Adding new measurement chronologically");
        Time time = new Time(2014, 4, 10, 1, 0);
        sequence.addChronologically(new Measurement(time, 8.0));

        System.out.println("Measurements from April 2014");
        sequence.print(4, 2014, false);

        // Zad4

        saveObjectToFile(sequence, "measurements.txt");

        MeasurementSequence sequence2 = loadObjectFromFile("measurements.txt");

        System.out.println("Measurements from April 2014");
        sequence2.print(4, 2014, false);
    }

    public static void generateInitialData(MeasurementSequence sequence)
    {
        Time time;
        float max = 50.0f;
        float temperature;
        Random rand = new Random();

        for (int i=0; i < 30; i++) {
            time = new Time(2014, 4, 1+i, 1, 0);
            temperature = rand.nextFloat() * max;
            sequence.add(new Measurement(time, temperature));
        }
        System.out.println("Initial data has been created");
    }

    public static void saveObjectToFile(MeasurementSequence obj, String filename)
    {
        try {
            FileOutputStream fstream = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fstream);

            out.writeObject(obj);

            out.close();
            System.out.println("File has been saved");
        }
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static MeasurementSequence loadObjectFromFile(String filename) throws ClassNotFoundException
    {
        Object obj = new Object();
        try {
            FileInputStream fstream = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fstream);

            obj = in.readObject();

            in.close();
            System.out.println("File has been read");
        }
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());

        }
        return (MeasurementSequence) obj;
    }

}
