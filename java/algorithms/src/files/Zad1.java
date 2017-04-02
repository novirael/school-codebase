package files;


public class Zad1 {

    public static void main(String args[]) {
        float [][] matrix1 = new float[15][10];
        float [][] matrix2 = new float[15][10];

        Files.fillWithRandomNumbers(matrix1);
        Files.saveToTextFile(matrix1, "out.txt");
        matrix2 = Files.readFromTextFile(matrix2, "out.txt");

        System.out.println("Saved matrix content:");
        Files.print(matrix1);
        System.out.println("Read matrix content:");
        Files.print(matrix2);
    }
}

