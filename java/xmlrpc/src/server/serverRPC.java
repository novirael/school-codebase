package server;
import org.apache.xmlrpc.WebServer;

public class serverRPC {

    public String ping() {
        System.out.println("ping");
        return "pong";
    }

    public int count(int n) {
        try {
            for(int i=1; i<=n; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }
        return n;

    }

    public int fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    public String multiplyString(String text, int n) {
        StringBuilder result = new StringBuilder();
        for(int i=0; i<n; i++) {
            result.append(text);
        }
        return result.toString();
    }

    public String show() {
        return  "fibonacci - int n - returns n-number of Fibonacci collection\n" +
                "multiplyString - str text, int n - returns n-times multiplication of given text\n" +
                "ping - test method\n" +
                "count - int n - counts from 0 to n with 1 seconds delay\n" +
                "show - returns available methods with short descriptions\n";
    }

    public static void main(String[] args) {
        int port = 10001;
        String serverName = "moria";
        String serverLocation = "localhost";

        try {
            WebServer server = new WebServer(port);
            server.addHandler(serverName, new serverRPC());
            server.start();

            System.out.println("Server is running at " + serverLocation + ":" + port + ". Server name: " + serverName);
        } catch (Exception exception) {
            System.err.println("Server XML-RPC: " + exception);
        }

    }

}
