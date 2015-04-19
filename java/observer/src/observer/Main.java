package board;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        int max_attributes = 3, max_students = 10;
        Student[] students = new Student[max_students];
        Blog blog = new Blog("http://novirael.com/blog/", 15);

        String[][] lines = FileUtils.read(
            "observers.txt", max_students, max_attributes);

        blog.addObserverFromList(students, lines);
        blog.check();
    }
}
