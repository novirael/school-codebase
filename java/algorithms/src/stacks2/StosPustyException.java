package stacks2;


public class StosPustyException extends Exception{
    @Override
    public String getMessage(){
        return "Stos jest pusty";

    }
}
