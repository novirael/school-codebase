package stacks2;


public class ListaPustaException extends Exception {

    @Override
    public String getMessage() {
        return "Lista jest pusta";

    }
}
