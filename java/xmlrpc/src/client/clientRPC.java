package client;

import org.apache.xmlrpc.XmlRpcClient;

import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class clientRPC {

    public static void main(String[] args) {

        AC cb = new AC();
        Vector<Object> params = new Vector<>();
        Scanner scanner = new Scanner(System.in);

        String serverName = "moria";
        String serverLocation = "localhost";
        String port = "10000";

        String choice = null;
        Object result;

        try {

            System.out.println("Server location:");
            serverLocation = scanner.next();
            System.out.println("Port:");
            port = scanner.next();
            System.out.println("Server name:");
            serverName = scanner.next();

            XmlRpcClient server = new XmlRpcClient("http://" + serverLocation + ":" + port);

            result = server.execute(serverName + ".show", params);
            System.out.println(result);
            System.out.println("exit - exit terminal");

            while (!Objects.equals(choice, "exit")) {
                choice = scanner.next();

                switch (choice) {
                    case "fibonacci":
                        params.clear();
                        System.out.print("\nn=");
                        params.addElement(scanner.nextInt());
                        result = server.execute(serverName + ".fibonacci", params);
                        System.out.println(result);
                        break;
                    case "multiplyString":
                        params.clear();
                        System.out.print("\ntext=");
                        params.addElement(scanner.next());
                        System.out.print("\nn=");
                        params.addElement(scanner.nextInt());
                        result = server.execute(serverName + ".multiplyString", params);
                        System.out.println(result);
                        break;
                    case "ping":
                        params.clear();
                        result = server.execute(serverName + ".ping", params);
                        System.out.println(result);
                        break;
                    case "count":
                        params.clear();
                        System.out.print("\nn=");
                        params.addElement(scanner.nextInt());
                        server.executeAsync(serverName + ".count", params, cb);
                        break;
                    case "show":
                        params.clear();
                        result = server.execute(serverName + ".show", params);
                        System.out.println(result);
                        System.out.println("exit - exit terminal");
                        break;
                    case "exit":
                        choice = "exit";
                        break;
                    default:
                        System.out.println("Invalid choice! Type 'show' to see available options,");
                }
            }

        } catch (Exception exception) {
            System.err.println("Client XML-RPC: " + exception);
        }

    }
}
