package files;

import java.io.*;
import java.util.Random;
import java.util.StringTokenizer;

public class Files {
    public static void print(float[][] matrix)
    {
        for (int y=0; y<matrix.length; y++) {
            for (int x=0; x<matrix[y].length; x++) {
                System.out.printf("%6.2f ", matrix[y][x]);
            }
            System.out.print("\n");
        }
    }

    public static void fillWithRandomNumbers(float[][] matrix)
    {
        float max = 100.0f;
        Random rand = new Random();

        for (int y=0; y<matrix.length; y++) {
            for (int x=0; x<matrix[y].length; x++) {
                matrix[y][x] = rand.nextFloat() * max;
            }
        }

        System.out.println("Matrix has been filled with random numbers.");
    }

    public static void saveToTextFile(float[][] matrix, String filename)
    {
        try {
            FileWriter fstream = new FileWriter(filename);
            BufferedWriter out = new BufferedWriter(fstream);

            out.write("Macierz\n");
            out.write("" + matrix.length + "\n");
            out.write("" + matrix[0].length + "\n");

            for (int y=0; y<matrix.length; y++) {
                for (int x=0; x<matrix[y].length; x++) {
                    out.write(""+matrix[y][x]+" ");
                }
                out.write("\n");
            }

            out.close();
            System.out.println("Matrix has been saved to text file");
        }
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static float[][] readFromTextFile(float[][] matrix, String filename)
    {
        try {
            FileReader fstream = new FileReader(filename);
            BufferedReader in = new BufferedReader(fstream);
            in.readLine();

            int rowNumb = Integer.parseInt(in.readLine());
            int colNumb = Integer.parseInt(in.readLine());
            int max_y = 0, max_x = 0;

            matrix = new float[rowNumb][colNumb];
            StringTokenizer number;

            for (int y=0; y<rowNumb; y++) {
                number = new StringTokenizer(in.readLine());
                for (int x=0; x<colNumb; x++) {
                    matrix[y][x] = Float.parseFloat(number.nextToken());
                    if (matrix[y][x] > matrix[max_y][max_x]) {
                        max_y = y;
                        max_x = x;
                    }
                }
            }

            in.close();
            
            System.out.println("Matrix has been read from text file");
            System.out.println("Max value coordinates is: " + max_x + ":" + max_y);
            System.out.println("Max value is: " + matrix[max_y][max_x]);
        }
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return matrix;
    }

    public static void saveToBinaryFile(float[][] matrix, String filename)
    {
        try {
            FileOutputStream fstream = new FileOutputStream(filename);
            DataOutputStream out = new DataOutputStream(fstream);

            out.writeInt(matrix.length);
            out.writeInt(matrix[0].length);

            for (int y=0; y<matrix.length; y++) {
                for (int x=0; x<matrix[y].length; x++) {
                    out.writeFloat(matrix[y][x]);
                }
            }

            out.close();
            System.out.println("Matrix has been saved to binary file");
        }
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static float[][] readFromBinaryFile(float[][] matrix, String filename)
    {
        try {
            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);

            int rowNumb = in.readInt();
            int colNumb = in.readInt();
            int max_y = 0, max_x = 0;

            matrix = new float[rowNumb][colNumb];

            for (int y=0; y<rowNumb; y++) {
                for (int x=0; x<colNumb; x++) {
                    matrix[y][x] = in.readFloat();
                    if (matrix[y][x] > matrix[max_y][max_x]) {
                        max_y = y;
                        max_x = x;
                    }
                }
            }

            in.close();
            System.out.println("Matrix has been read from binary file");
            System.out.println("Max value coordinates is: " + max_x + ":" + max_y);
            System.out.println("Max value is: " + matrix[max_y][max_x]);

        }
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return matrix;
    }
}
