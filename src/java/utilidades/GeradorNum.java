package utilidades;

import java.util.Random;

public class GeradorNum {
    public static String geradorCod(){
        Random r = new Random();
        String aux = String.valueOf(r.nextInt(1000));
        return aux;
    }
}
