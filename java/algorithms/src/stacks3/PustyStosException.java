package stacks3;


public class PustyStosException extends  Exception {
    @Override
    public String getMessage(){
        return "Stos jest pusty";
    }
}
