package files;


public class Zad2 {

    public static void main(String args[]) {
        float [][] matrix1 = new float[15][10];
        float [][] matrix2 = new float[15][10];

        Files.fillWithRandomNumbers(matrix1);
        Files.saveToBinaryFile(matrix1, "outbin.txt");
        matrix2 = Files.readFromBinaryFile(matrix2, "outbin.txt");

        System.out.println("Saved matrix content:");
        Files.print(matrix1);
        System.out.println("Read matrix content:");
        Files.print(matrix2);
    }
}
