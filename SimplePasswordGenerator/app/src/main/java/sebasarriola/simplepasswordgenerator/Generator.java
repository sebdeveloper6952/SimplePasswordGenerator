package sebasarriola.simplepasswordgenerator;

import java.util.Random;

/**
 * Created by gaming on 4/15/2016.
 */
public class Generator {
    private char[] caracteres = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '_' , '-'};
    public int longitudDeClave;

    public Generator(int longitud)
    {
        longitudDeClave = longitud;
    }

    public String GenerarClave(int longitud)
    {
        longitudDeClave = longitud;
        String clave = "";
        char caracter;
        Random rand = new Random();

        for(int i = 0; i < longitudDeClave; i++)
        {
            caracter = caracteres[rand.nextInt(caracteres.length -1)];
            clave += caracter;
        }
        return clave;
    }

}

