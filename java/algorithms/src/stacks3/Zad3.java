package stacks3;
import  java.io.*;


// Todo
public class Zad3 {
    public static void main(String[] args) {

        Stos stos = new Stos();
        while (true) {
            System.out.println("Podaj napis do odwrócenia (Puste konczy program)");
            String napis = "";

            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                napis = br.readLine();
                System.out.println(napis);
            }
            catch (IOException e){
                e.printStackTrace();
            }

            if (napis.isEmpty()) {
                break;
            }
            for (String litera : napis.split("")) {
                stos.dodajDoStosu(litera);
            }
            String napisDoWypisania = "";
            while (true){
                try{

                    napisDoWypisania += stos.pobierzZeStosu();
                }
                catch (PustyStosException e){
                    break;
                }
            }
            System.out.println(napisDoWypisania);
        }

    }
}