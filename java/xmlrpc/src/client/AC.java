package client;

import org.apache.xmlrpc.AsyncCallback;

import java.net.URL;

public class AC implements AsyncCallback {


    @Override
    public void handleResult(Object result, URL url, String method) {
        System.out.println("Running async method: " + method + " with result: " + result);
    }

    @Override
    public void handleError(Exception e, URL url, String s) {
        System.out.println("Error occurred, async.");
    }
}
