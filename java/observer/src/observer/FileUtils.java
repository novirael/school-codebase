package board;

import java.io.*;
import java.util.Scanner;


public class FileUtils {
    public static String[][] read(String filename, int max_lines, int max_words) {
        String[][] lines = new String[max_lines][max_words];
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
        int i = 0;

        while (sc != null && sc.hasNextLine()) {
            String line = sc.nextLine();
            lines[i++] = line.split(" ");
        }
        return lines;
    }
}
