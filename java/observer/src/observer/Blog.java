package board;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Observable;

public class Blog extends Observable {
    private String url;
    private int max_retries;

    public Blog(String url, int max_retries) {
        this.url = url;
        this.max_retries = max_retries;
    }

    public void addObserverFromList(Student[] students, String[][] lines) {
        for (int i=0; i<lines.length; i++) {
            if (lines[i][0] != null) {
                students[i] = new Student(
                        lines[i][0], lines[i][1], lines[i][2]);
                this.addObserver(students[i]);
            }
        }
    }

    public void check() throws IOException, InterruptedException {
        String prev_html, act_html;
        prev_html = Jsoup.connect(this.url).get().html();
        int k = 0;
        while (k++ < this.max_retries) {
            act_html = Jsoup.connect(this.url).get().html();
            if (!prev_html.equals(act_html)) {
                System.out.print("Changes");
                setChanged();
                notifyObservers(this.url);
            }
            Thread.sleep(10 * 1000);
            prev_html = act_html;
        }

    }
}
